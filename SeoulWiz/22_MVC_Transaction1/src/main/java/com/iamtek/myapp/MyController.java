package com.iamtek.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iamtek.myapp.dao.TicketDao;
import com.iamtek.myapp.dto.TicketDto;

@Controller
public class MyController {
	
	private TicketDao dao;
	
	@Autowired
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDto ticketDto, Model model) {
		System.out.println( "buy_ticket_card" );
		System.out.println( "ticketDto : " + ticketDto.getConsumerId() );
		System.out.println( "ticketDto : " + ticketDto.getAmount() );
		
		dao.buyTicket(ticketDto);
		
		model.addAttribute("ticketInfo", ticketDto);
		
		return "buy_ticket_end";
	}

}
