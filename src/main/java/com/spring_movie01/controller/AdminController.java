package com.spring_movie01.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_movie01.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService asvc;
	
	@RequestMapping(value="/getCgvMovieList")
	public ModelAndView getCgvMovieList(RedirectAttributes ra) throws IOException {
		System.out.println("영화 등록 요청");
		ModelAndView mav = asvc.getCgvMovieList(ra);
		return mav;
	}
	
	@RequestMapping(value="/adminMovieList")
	public ModelAndView adminMovieList() {
		System.out.println("관리자 영화목록페이지 이동 요청");
		ModelAndView mav = asvc.adminMovieList();
		return mav;
	}
	
	@RequestMapping(value="/changeMvstate")
	public @ResponseBody int changeMvstate(String mvcode, int mvstate) {
		System.out.println("mvstate 1로 변경 요청");
		System.out.println("변경할 영화코드 : " + mvcode);
		System.out.println("변경할 활성 상태 : " + mvstate);
		int selectMvstate = asvc.changeMvstate(mvcode, mvstate);
		return selectMvstate;
	}
}
