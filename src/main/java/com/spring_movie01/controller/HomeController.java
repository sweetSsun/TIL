package com.spring_movie01.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		if(session.getAttribute("adminPw") != null) {
			session.removeAttribute("adminPw");
		}
		return "Main";
	}
	
	@RequestMapping(value="/adminMain", method = RequestMethod.GET)
	public String adminMain(String inputPw, RedirectAttributes ra) {
		String pw = "1234";
		if (session.getAttribute("adminPw") != null) {
			return "AdminMain";
		} else if(pw.equals(inputPw)) {
			session.setAttribute("adminPw", pw);
			return "AdminMain";
		} else {
			ra.addFlashAttribute("msg", "관리자 비밀번호가 일치하지 않습니다.");
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/testPage")
	public String testPage() {
		return "TestPage";
	}
	
	@RequestMapping(value="/chatPage")
	public String chatPage() {
		return "ChatPage";
	}
	
}
