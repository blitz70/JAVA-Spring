package com.iamtek.myapp.command;

import org.springframework.ui.Model;

import com.iamtek.myapp.dao.BDao;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		BDao dao = new BDao();
		model.addAttribute("list", dao.list());
		
	}

}
