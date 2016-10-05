package com.iamtek.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iamtek.myapp.dao.IDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private IDao dao;
	
	@Autowired
	private SqlSession sqlsession;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list");
		dao = sqlsession.getMapper(IDao.class);
		model.addAttribute("list", dao.list());
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		System.out.println("writeForm");
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write");
		dao = sqlsession.getMapper(IDao.class);
		dao.write(request.getParameter("mWriter"), request.getParameter("mContent"));
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete");
		dao = sqlsession.getMapper(IDao.class);
		dao.delete(request.getParameter("mId"));
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String content(HttpServletRequest request, Model model) {
		System.out.println("view");
		dao = sqlsession.getMapper(IDao.class);
		model.addAttribute("view", dao.view(request.getParameter("mId")));
		return "view";
	}
	
}
