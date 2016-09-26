package com.iamtek.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.iamtek.myapp.dto.TicketDto;

public class TicketDao {

	private String sql;
	private JdbcTemplate template;
	private PlatformTransactionManager transactionManager;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public TicketDao() {
		System.out.println("TicketDao() :" + template);
	}
	
	public void buyTicket(TicketDto dto) {
		
		final String consumerId = dto.getConsumerId();
		final String amount = dto.getAmount();
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		try {
			//logic1
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
			//logic2
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
			transactionManager.commit(status);
		} catch (Exception e) {
			System.out.println("buyTicket()");
			transactionManager.rollback(status);;
			e.printStackTrace();
		}
		
	}
	
}
