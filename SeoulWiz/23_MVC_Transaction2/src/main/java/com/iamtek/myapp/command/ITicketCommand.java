package com.iamtek.myapp.command;

import com.iamtek.myapp.dto.TicketDto;

public interface ITicketCommand {
	
	public void execute(TicketDto dto);

}
