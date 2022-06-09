package com.spring_movie01.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_movie01.dto.ReservationDto;
import com.spring_movie01.dto.ReviewDto;
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
		System.out.println("예매정보 입력 요청 요청");
		ModelAndView mav = mvsvc.movieReservation(redto, ra);
		return mav;
	}
	
	@RequestMapping(value="/reservationInfo")
	public ModelAndView reservationInfo(String recode) {
		System.out.println("예매정보 조회 요청");
		System.out.println("컨트롤러 recode : " + recode);
		ModelAndView mav = mvsvc.reservationInfo(recode);
		return mav;
	}
	
	@RequestMapping(value="/reservationList")
	public ModelAndView reservationList() {
		System.out.println("예매목록 조회 요청");
		ModelAndView mav = mvsvc.reservationList();
		return mav;
	}
	
	@RequestMapping(value="/cancleReservation")
	public ModelAndView cancleReservation(String recode, RedirectAttributes ra) {
		System.out.println("예매취소 요청");
		ModelAndView mav = mvsvc.deleteReservation(recode, ra);
		return mav;
	}
	
	@RequestMapping(value="/insertReview")
	public ModelAndView insertReview(ReviewDto rvdto, RedirectAttributes ra) {
		System.out.println("관람평 작성 요청");
		ModelAndView mav = mvsvc.insertReview(rvdto, ra);
		return mav;
	}
	
	@RequestMapping(value="/getReview")
	public @ResponseBody String getReview(String rvrecode) {
		System.out.println("작성된 관람평 확인");
		String rvInfo = mvsvc.getReview(rvrecode);
		return rvInfo;
	}
	
	// 관람평 수정에 추천/비추천 변경
	@RequestMapping(value="/modifyReview")
	public ModelAndView modifyReview(ReviewDto rvdto, RedirectAttributes ra){
		System.out.println("관람평 수정 요청");
		ModelAndView mav = mvsvc.modifyReview(rvdto, ra);
		return mav;
	}
	
	@RequestMapping(value="/pagingReview")
	public @ResponseBody String pagingReview(String mvcode, int page) {
		System.out.println("페이징 된 관람평 조회 요청");
		String pagingReviewList = mvsvc.pagingReview(mvcode, page);
		return pagingReviewList;
	}
	
	@RequestMapping(value="/pagingNumber")
	public @ResponseBody String pagingNumber(String mvcode, int page) {
		System.out.println("페이징 넘버 조회 요청");
		String pagingNumber = mvsvc.pagingNumber(mvcode, page);
		return pagingNumber;
	}
	
	@RequestMapping(value="/searchMovie")
	public ModelAndView searchMovie(String searchText) {
		System.out.println("영화 검색 요청");
		ModelAndView mav = mvsvc.getSearchMovie(searchText);
		return mav;
	}
}
