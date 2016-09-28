package com.iamtek.myapp.command;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.iamtek.myapp.dao.TicketDao;
import com.iamtek.myapp.dto.TicketDto;

public class TicketCommand implements ITicketCommand {

	private TicketDao dao;
	private TransactionTemplate transactionTemplate2;
	
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}
	public void setTransactionTemplate2(TransactionTemplate transactionTemplate) {
		this.transactionTemplate2 = transactionTemplate;
	}

	@Override
	public void execute(final TicketDto dto) {
		try {
			transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					dto.setAmount("1");
					dao.buyTicket(dto);
					dto.setAmount("5");
					dao.buyTicket(dto);
				}
			});
			System.out.println("TicketCommand.execute() commit");
		} catch (Exception e) {
			System.out.println("TicketCommand.execute() rollback");
			e.printStackTrace();
		}
	}

}
