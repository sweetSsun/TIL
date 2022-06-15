package com.spring_movie01.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_movie01.dto.MovieDto;
import com.spring_movie01.dto.SchedulesDto;
import com.spring_movie01.dto.TheaterDto;
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
		System.out.println("mvstate 변경 요청");
		System.out.println("변경할 영화코드 : " + mvcode);
		System.out.println("변경할 활성 상태 : " + mvstate);
		int selectMvstate = asvc.changeMvstate(mvcode, mvstate);
		return selectMvstate;
	}
	
	@RequestMapping(value="/adminMovieView")
	public ModelAndView adminMovieView(String mvcode) {
		System.out.println("관리자 영화수정 페이지 이동 요청");
		ModelAndView mav = asvc.adminMovieView(mvcode);
		
		return mav;
	}
	
	@RequestMapping(value="/adminMovieModi")
	public ModelAndView adminMovieModi(MovieDto mvInfo) {
		System.out.println("영화정보 수정 요청");
		ModelAndView mav = asvc.adminMovieModi(mvInfo);
		return mav;
	}
	
	@RequestMapping(value="/adminMovieModiModal")
	public @ResponseBody int adminMovieModiModal(MovieDto mvInfo) {
		System.out.println("모달_영화정보 수정 요청");
		int updateResult = asvc.adminMovieModiModal(mvInfo);
		return updateResult;
	}
	
	@RequestMapping(value="/adminTheaterList")
	public ModelAndView adminTheaterList() {
		System.out.println("관리자 극장정보 페이지 이동 요청");
		ModelAndView mav = asvc.adminTheaterList();
		return mav;
	}
	
	@RequestMapping(value="/changeThstate")
	public @ResponseBody int changeThstate(String thcode, int thstate) {
		System.out.println("thstate 변경 요청");
		int updateThstate = asvc.changeThstate(thcode, thstate);
		return updateThstate;
	}
	
	@RequestMapping(value="/adminThaterModiModal")
	public @ResponseBody int adminThaterModiModal(TheaterDto thInfo) {
		System.out.println("모달_극장정보 수정요청");
		int updateResult = asvc.adminTheaterModi(thInfo);
		return updateResult;
	}
	
	@RequestMapping(value="/adminSchedulesList")
	public ModelAndView adminSchedulesRegister(boolean array) {
		System.out.println("관리자 스케줄 등록 페이지 이동 요청");
		ModelAndView mav = asvc.adminSchedulesList(array);
		return mav;
	}
	
	@RequestMapping(value="/adminSchedulesRegister")
	public ModelAndView adminSchedulesRegister(SchedulesDto schedule, RedirectAttributes ra) {
		System.out.println("스케줄 등록 요청");
		ModelAndView mav = asvc.adminSchedulesRegister(schedule, ra);
		return mav;
	}
	
	@RequestMapping(value="/selectScroomTime")
	public @ResponseBody String selectScroomTime(String scthcode, String scday) {
		System.out.println("중복 스케줄 조회 요청");
		String selResult = asvc.selectScroomTime(scthcode, scday);
		return selResult;
	}
	
	@RequestMapping(value="/adminSchedulesRegister_Array")
	public ModelAndView adminSchedulesRegister_Array(SchedulesDto schedule, RedirectAttributes ra) {
		System.out.println("스케줄 등록 요청");
		System.out.println(schedule);
		ModelAndView mav = asvc.adminSchedulesRegister_Array(schedule, ra);
		return mav;
	}
}
