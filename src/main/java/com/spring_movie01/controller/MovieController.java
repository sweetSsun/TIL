package com.spring_movie01.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_movie01.dto.ReservationDto;
import com.spring_movie01.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService mvsvc;
	
	@RequestMapping(value="/getThList")
	public @ResponseBody String getThList(String mvcode) {
		System.out.println("상영극장 조회 요청");
		String thList = mvsvc.getThList(mvcode);
		return thList;
	}
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
	
	@RequestMapping(value="/movieReservationPage")
	public ModelAndView movieReservationPage() {
		System.out.println("영화 예매페이지 이동 요청");
		
		ModelAndView mav = mvsvc.movieReservationPage();
		return mav;
	}
	
	
	@RequestMapping(value="/getScDay")
	public @ResponseBody String getScDay(String mvcode, String thcode) {
		System.out.println("상영일 조회 요청");
		String dayList = mvsvc.getScDay(mvcode, thcode);
		return dayList;
	}
	
	@RequestMapping(value="/getScTime")
	public @ResponseBody String getScTime(String mvcode, String thcode, String scday) {
		System.out.println("시간 및 상영관 조회 요청");
		String timeList = mvsvc.getScTime(mvcode, thcode, scday);
		return timeList;
	}
	
	@RequestMapping(value="/movieReservation")
	public ModelAndView movieReservation(ReservationDto redto, RedirectAttributes ra) {
		ModelAndView mav = mvsvc.movieReservation(redto, ra);
		return mav;
	}
}
