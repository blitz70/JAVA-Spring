package com.iamtek.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.iamtek.myapp.dto.BDto;
import com.iamtek.myapp.util.Constant;

public class BDao {
	
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;
	private JdbcTemplate template;

	public BDao() {
		template = Constant.template;
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (Exception e) {
			System.out.println("BDao()");
			e.printStackTrace();
		}
	}

	public void dbClose() {
		try {
			if (resultSet != null) resultSet.close();
			if (preparedStatement != null) preparedStatement.close();
			if (connection != null) connection.close();
		} catch (Exception e) {
			System.out.println("dbClose()");
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDto> list() {	//OK
		sql = "SELECT * FROM mvc_board ORDER BY bGroup desc, bStep asc";
		return (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper<BDto> (BDto.class));
	}
	
	public int write(final String bName, final String bTitle, final String bContent) {	//OK
		int result = 0;
		//insert new post
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				sql = "INSERT INTO mvc_board(bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES (?, ?, ?, now(), 0, 0, 0, 0)";
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, bName);
				preparedStatement.setString(2, bTitle);
				preparedStatement.setString(3, bContent);
				return preparedStatement;
			}
		});
		//set bGroup == bId
		sql = "UPDATE mvc_board SET bGroup = bId WHERE bGroup=0";
		template.update(sql);
		return result;
	}

	public BDto content(final String bId) {	//OK
		//bHit++
		sql = "UPDATE mvc_board SET bHit = bHit+1 WHERE bId="+bId;
		template.update(sql);
		//get content
		sql = "SELECT * FROM mvc_board WHERE bId="+bId;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BDto> (BDto.class));
	}

	public int modify(final String bId, final String bName, final String bTitle, final String bContent) {	//OK
		sql = "UPDATE mvc_board SET bName=?, bTitle=?, bContent=? WHERE bId=?";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});
	}

	public int delete(final String bId) {	//OK
		sql = "DELETE FROM mvc_board WHERE bId=?";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}

	public int reply(String bId, String bName, String bTitle, String bContent) {	//to do
		int result = 0;
		try {
			int bGroup = 0;
			int bStep = 0;
			int bIndent = 0;
			connection = dataSource.getConnection();
			//original bGroup, bStep, bIndent
			sql = "SELECT bGroup, bStep, bIndent FROM mvc_board WHERE bId=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bGroup = resultSet.getInt("bGroup");
				bStep = resultSet.getInt("bStep");
				bIndent = resultSet.getInt("bIndent");
			}
			//make space for reply post, bGroup, bStep
			sql = "UPDATE mvc_board SET bStep=bStep+1 WHERE bGroup=? AND bStep>?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bGroup);
			preparedStatement.setInt(2, bStep);
			preparedStatement.executeUpdate();
			//insert reply
			sql = "INSERT INTO mvc_board("+
			"bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES (?, ?, ?, now(), 0, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, bGroup);
			preparedStatement.setInt(5, bStep+1);
			preparedStatement.setInt(6, bIndent+1);
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("BDao.reply()");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}

}
