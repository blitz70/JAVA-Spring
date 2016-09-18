package com.iamtek.myapp.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.iamtek.myapp.dao.BDao;

//
public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map= model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String BContent = request.getParameter("BContent");
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, BContent);
	
	}

}
