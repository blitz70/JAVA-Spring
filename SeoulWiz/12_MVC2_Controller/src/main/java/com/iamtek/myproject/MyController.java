package com.iamtek.myproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("board/view")
	public String view() {
		return "board/view";
	}
	
	@RequestMapping("board/content")
	public String content(Model model) {
		model.addAttribute("id", "board's content");
		return "/board/content";
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", "board's reply");
		mv.setViewName("board/reply");
		return mv;
	}

}

@Controller
	@RequestMapping("test")
	class MyController2 {

		@RequestMapping("/view")
		public String view() {
			return "/test/view";
		}
		
		@RequestMapping("/content")
		public String content(Model model) {
			model.addAttribute("id", "test's content");
			return "/test/content";
		}
		
		@RequestMapping("/reply")
		public ModelAndView reply() {
			ModelAndView mv = new ModelAndView();
			mv.addObject("id", "test's reply");
			mv.setViewName("/test/reply");
			return mv;
		}
	
}