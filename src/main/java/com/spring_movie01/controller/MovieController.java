package com.spring_movie01.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_movie01.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService mvsvc;
	
	@RequestMapping(value="/getCgvMovieList")
	public ModelAndView getCgvMovieList() throws IOException {
		System.out.println("영화 등록 요청");
		ModelAndView mav = mvsvc.getCgvMovieList();
		return mav;
	}

	@RequestMapping(value="/movieList")
	public ModelAndView movieList() {
		System.out.println("영화 목록페이지 이동 요청");
		ModelAndView mav = mvsvc.movieList();
		return mav;
	}
	
	@RequestMapping(value="/movieView")
	public ModelAndView movieView(String mvcode) {
		System.out.println("영화 상세페이지 이동 요청");
		ModelAndView mav = mvsvc.movieInfoView(mvcode);
		System.out.println(mav.getModel());
		return mav;
	}
}
