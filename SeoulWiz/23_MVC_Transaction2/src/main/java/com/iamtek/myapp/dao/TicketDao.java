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
	private TransactionTemplate transactionTemplate1;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void setTransactionTemplate1(TransactionTemplate transactionTemplate) {
		this.transactionTemplate1 = transactionTemplate;
	}
	
	public TicketDao() {
		System.out.println("TicketDao() :" + template);
	}
	
	public void buyTicket(final TicketDto dto) {
		
		transactionTemplate1.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				//logic1
				template.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						sql = "INSERT INTO card (consumerId, amount) VALUES (?, ?)";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, dto.getConsumerId());
						ps.setString(2, dto.getAmount());
						return ps;
					}
				});
				//logic2
				template.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						sql = "INSERT INTO ticket (consumerId, countNum) VALUES (?, ?)";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, dto.getConsumerId());
						ps.setString(2, dto.getAmount());
						return ps;
					}
				});
			}
		});
	
	}
	
}
