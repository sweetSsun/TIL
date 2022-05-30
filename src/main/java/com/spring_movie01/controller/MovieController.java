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

}
