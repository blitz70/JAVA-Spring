package com.iamtek.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.iamtek.myapp.dto.TicketDto;

public class TicketDao {

	private String sql;
	private JdbcTemplate template;
	private TransactionTemplate transactionTemplate;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	public TicketDao() {
		System.out.println("TicketDao() :" + template);
	}
	
	public void buyTicket(TicketDto dto) {
		
		final String consumerId = dto.getConsumerId();
		final String amount = dto.getAmount();
		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
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
				}
			});
		} catch (Exception e) {
			System.out.println("buyTicket()");
			e.printStackTrace();
		}
	
	}
	
}
