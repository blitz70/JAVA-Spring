package com.iamtek.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.iamtek.myapp.dto.BDto;

public class BDao {
	
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql;

	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (Exception e) {
			System.out.println("BDao()");
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		try {
			connection = dataSource.getConnection();
			sql = "SELECT * FROM mvc_board ORDER BY bGroup desc, bStep asc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			System.out.println("BDao.list()");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return dtos;
	}

	public void write(String bName, String bTitle, String bContent) {
		try {
			connection = dataSource.getConnection();
			sql = "INSERT INTO mvc_board("+
			"bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent) VALUES (?, ?, ?, now(), 0, 0, 0, 0)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.executeUpdate();
			sql = "UPDATE mvc_board SET bGroup = bId WHERE bGroup=0";		//set bGroup == bId
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("BDao.write()");
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	public BDto content(int bId) {
		BDto dto = null;
		try {
			connection = dataSource.getConnection();
			//bHit++
			sql = "UPDATE mvc_board SET bHit = bHit+1 WHERE bId=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bId);
			preparedStatement.executeUpdate();
			//get content
			sql = "SELECT * FROM mvc_board WHERE bId=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		} catch (Exception e) {
			System.out.println("BDao.list()");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return dto;
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

}
