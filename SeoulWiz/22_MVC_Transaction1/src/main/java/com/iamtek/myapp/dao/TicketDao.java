package com.iamtek.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.iamtek.myapp.dto.TicketDto;

public class TicketDao {

	private String sql;
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public TicketDao() {
		System.out.println("TicketDao()");
		System.out.println(template);
	}
	
	public void buyTicket(TicketDto dto) {
		System.out.println("TicketDao.buyTicket()");
		final String consumerId = dto.getConsumerId();
		final String amount = dto.getAmount();
		System.out.println("consumerId:"+consumerId);
		System.out.println("amount:"+amount);
		
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				sql = "INSERT INTO card (consumerId, amount) VALUES (?, ?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, consumerId);
				ps.setString(2, amount);
				return ps;
			}
		});
		
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				sql = "INSERT INTO ticket (consumerId, countNum) VALUES (?, ?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, consumerId);
				ps.setString(2, amount);
				return ps;
			}
		});
	}
	
}
