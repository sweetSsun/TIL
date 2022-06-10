package com.spring_movie01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_movie01.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService asvc;
	
	@RequestMapping(value="/adminMovieList")
	public ModelAndView adminMovieList() {
		System.out.println("관리자 영화목록페이지 이동 요청");
		ModelAndView mav = asvc.adminMovieList();
		return mav;
	}
}
