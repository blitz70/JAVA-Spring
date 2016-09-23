package com.iamtek.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.iamtek.myapp.dto.BDto;
import com.iamtek.myapp.util.Constant;

public class BDao {
	
	private String sql;
	private JdbcTemplate template;

	public BDao() {
		template = Constant.template;
	}

	public ArrayList<BDto> list() {	//OK
		sql = "SELECT * FROM mvc_board ORDER BY bGroup desc, bStep asc";
		return (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper<BDto> (BDto.class));
	}
	
	public int write(final String bName, final String bTitle, final String bContent) {	//OK
		//insert new post
		int result = template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				sql = "INSERT INTO mvc_board(bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES (?, ?, ?, now(), 0, 0, 0, 0)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				return ps;
			}
		});
		updateGroup();	//set bGroup == bId
		return result;
	}

	public BDto content(String bId) {	//OK
		upHit(bId);	//bHit++
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

	public int delete(String bId) {	//OK
		sql = "DELETE FROM mvc_board WHERE bId=" + bId;
		return template.update(sql);
	}

	public int reply(String bId, final String bName, final String bTitle, final String bContent) {	//to do
		BDto dto = getShape(bId);	//get bGroup, bStep, bIndent from bId
		final int bGroup = dto.getbGroup();
		final int bStep = dto.getbStep();
		final int bIndent = dto.getbIndent();
		setShape(bGroup, bStep);	//make space for reply post, bGroup, bStep
		//insert reply
		sql = "INSERT INTO mvc_board("+
		"bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES (?, ?, ?, now(), 0, ?, ?, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, bGroup);
				ps.setInt(5, bStep+1);
				ps.setInt(6, bIndent+1);
			}
		});
	}

	private int upHit(String bId) {
		sql = "UPDATE mvc_board SET bHit = bHit+1 WHERE bId="+bId;
		return template.update(sql);
	}

	private int updateGroup() {
		sql = "UPDATE mvc_board SET bGroup = bId WHERE bGroup=0";
		return template.update(sql);
	}

	private int setShape(final int bGroup, final int bStep) {
		sql = "UPDATE mvc_board SET bStep=bStep+1 WHERE bGroup=? AND bStep>?";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, bGroup);
				ps.setInt(2, bStep);
			}
		});
	}

	private BDto getShape(String bId) {
		sql = "SELECT bGroup, bStep, bIndent FROM mvc_board WHERE bId=" + bId;
		return (BDto) template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
}
