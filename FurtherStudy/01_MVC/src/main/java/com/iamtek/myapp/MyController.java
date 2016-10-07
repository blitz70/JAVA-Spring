package com.iamtek.myapp;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iamtek.myapp.dao.ITicketDao;
import com.iamtek.myapp.dto.TicketDto;

@Controller
public class MyController {
	
	private ITicketDao dao;
	private TransactionTemplate transactionTemplate;
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}	

	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(final TicketDto ticketDto, Model model) {
		System.out.println( "buy_ticket_card" );
		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					dao = sqlSession.getMapper(ITicketDao.class);
					dao.buyTicket(ticketDto);
				}
			});
		} catch (Exception e) {
			return "redirect:buy_ticket";
		}
		model.addAttribute("ticketInfo", ticketDto);
		return "buy_ticket_end";
	}
	
}
