package com.iamtek.myapp.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.iamtek.myapp.dao.BDao;
import com.iamtek.myapp.dto.BDto;

//get list of post titles
public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}

}
