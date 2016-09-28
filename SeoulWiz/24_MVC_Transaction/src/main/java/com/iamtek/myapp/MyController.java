package com.iamtek.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iamtek.myapp.command.ITicketCommand;
import com.iamtek.myapp.dto.TicketDto;

@Controller
public class MyController {
	
	private ITicketCommand ticketCommand;
	
	@Autowired
	public void setTicketCommand(ITicketCommand ticketCommand) {
		this.ticketCommand = ticketCommand;
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDto dto, Model model) {
		System.out.println( "buy_ticket_card" );
		System.out.println( "ticketDto : " + dto.getConsumerId() );
		System.out.println( "ticketDto : " + dto.getAmount() );
		
		ticketCommand.execute(dto);
		
		model.addAttribute("ticketInfo", dto);
		
		return "buy_ticket_end";
	}

}
