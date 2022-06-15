package com.spring_movie01.service;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.spring_movie01.dao.AdminDao;
import com.spring_movie01.dao.MovieDao;
import com.spring_movie01.dto.MovieDto;
import com.spring_movie01.dto.SchedulesDto;
import com.spring_movie01.dto.TheaterDto;

@Service
public class AdminService {

	@Autowired
	MovieDao mvdao;
	@Autowired
	AdminDao adao;
	
	ModelAndView mav;
	
	public ModelAndView getCgvMovieList(RedirectAttributes ra) throws IOException {
		System.out.println("AdminService.getCgvMovieList() 호출");
		ModelAndView mav = new ModelAndView();
		
		String cgvMovieUrl = "http://www.cgv.co.kr/movies/?lt=1&ft=0";

		Document doc = Jsoup.connect(cgvMovieUrl).get();
		
		Elements movieList_div = doc.select("div.sect-movie-chart");
		Elements movieList_ol = movieList_div.eq(0).select("ol");
		
		ArrayList<MovieDto> cgvMvList = new ArrayList<MovieDto>();

		// 각 영화 상세페이지에 들어가서 정보 받아오기
		for(int i = 0; i < movieList_ol.select("li").size(); i++) {
			MovieDto mv = new MovieDto();
			String detailUrl = "http://www.cgv.co.kr" + movieList_ol.select("li").eq(i).select("div.box-image a").eq(0).attr("href");
			
			Document detailDoc = Jsoup.connect(detailUrl).get();
			Elements baseMovie = detailDoc.select("div.sect-base-movie");
			
			String movieTitle = baseMovie.select("div.box-contents div.title strong").text();
//			System.out.println(" movieTitle : " + movieTitle);
			mv.setMvname(movieTitle);
			
			String posterUrl = baseMovie.select("div.box-image span.thumb-image img").attr("src");
//			System.out.println(" posterUrl : " + posterUrl);
			mv.setMvposter(posterUrl);
			
			String movieDirector = baseMovie.select("div.box-contents div.spec dd").eq(0).text();
//			System.out.println(" movieDirector : " + movieDirector);
			mv.setMvpd(movieDirector);

			String movieActors = baseMovie.select("div.box-contents div.spec dd.on").eq(0).text();
//			System.out.println(" movieActors : " + movieActors);
			mv.setMvactor(movieActors);
			
			String movieGenre = baseMovie.select("div.box-contents div.spec dd.on").eq(0).next().text().replace("장르 :", "").replaceFirst(" ", "");
//			System.out.println(" movieGenre : " + movieGenre);
			mv.setMvgenre(movieGenre);
			
			String movieGrade =  baseMovie.select("div.box-contents div.spec dd.on").eq(1).text().split(", ")[0];
//			System.out.println(" movieGrade : " + movieGrade);
			mv.setMvage(movieGrade);
			
			String movieTime = baseMovie.select("div.box-contents div.spec dd.on").eq(1).text().split(", ")[1].replaceFirst(",", "");
//			System.out.println(" movieTime : " + movieTime);
			mv.setMvtime(movieTime);
			
			String movieOpen = baseMovie.select("div.box-contents div.spec dd.on").eq(2).text();
//			System.out.println(" movieOpen : " + movieOpen);
			mv.setMvopen(movieOpen);
			
			cgvMvList.add(mv);
		}
		
		int insertCount = 0;
		for(int i = 0; i < cgvMvList.size(); i++) {
			// 중복값이 없는지 확인 후 INSERT
			int mvCheck = adao.selectMvCheck(cgvMvList.get(i).getMvname(), cgvMvList.get(i).getMvopen());
			if(mvCheck == 0) {
				// 1. 영화코드 생성 (select)
				String maxMvcode = adao.getMaxMvcode();
//				int mvcodeNum = Integer.parseInt(maxMvcode.split("MV")[1]) + 1;
				int mvcodeNum = Integer.parseInt(maxMvcode.substring(2)) + 1;
				String mvcode = "MV";
				if (mvcodeNum < 10) {
					mvcode = mvcode + "00" + mvcodeNum;
				} else  if (mvcodeNum < 100) {
					mvcode = mvcode + "0" + mvcodeNum;
				} else {
					mvcode = mvcode + mvcodeNum;
				}			
				cgvMvList.get(i).setMvcode(mvcode);
				
				// 2. 영화정보 insert
				System.out.println(cgvMvList.get(i));
				adao.insertMovieInfo(cgvMvList.get(i));
				insertCount++;
			}
		}
		System.out.println("insertCount : " + insertCount);
		ra.addFlashAttribute("msg", insertCount+"개의 영화가 신규등록 되었습니다.");
		mav.setViewName("redirect:/adminMovieList");
		return mav;
	}

	public ModelAndView adminMovieList() {
		System.out.println("AdminService.adminMovieList() 호출");
		ModelAndView mav = new ModelAndView();
		// 1. 영화목록 조회
		ArrayList<MovieDto> mvList = mvdao.selectMovieList("mvopen");
		System.out.println(mvList);
		
		mav.addObject("mvList", mvList);
		// 2. 영화목록 페이지
		mav.setViewName("admin/AdminMovieList");
		return mav;
	}

	public int changeMvstate(String mvcode, int mvstate) {
		System.out.println("AdminService.changeMvstate() 호출");
		adao.changeMvstate(mvcode, mvstate);
		int selectMvstate = adao.getMvstate(mvcode);
		return selectMvstate;
	}

	public ModelAndView adminMovieView(String mvcode) {
		System.out.println("AdminService.adminMovieView() 호출");
		ModelAndView mav = new ModelAndView();
		System.out.println("영화코드 : " + mvcode);
		// 영화정보
		MovieDto movieInfo = mvdao.selectMovieInfo(mvcode);
		// 예매율 저장
		int sumRecount = movieInfo.getSumrecount();
		double rerate = (double) movieInfo.getRecount() / sumRecount * 100;
		rerate = Math.round(rerate*100)/100.0;
		movieInfo.setRerate(rerate);
		mav.addObject("movieInfo", movieInfo);
		mav.setViewName("admin/AdminMovieView");
		return mav;
	}

	public ModelAndView adminMovieModi(MovieDto mvInfo) {
		System.out.println("AdminService.adminMovieView() 호출");
		ModelAndView mav = new ModelAndView();
		System.out.println("수정할 영화 정보 : " + mvInfo);
		int updateResult = adao.updateMovieInfo(mvInfo);
		System.out.println("업데이트 결과 : " + updateResult);
		
		mav.setViewName("redirect:/adminMovieView?mvcode="+mvInfo.getMvcode());
		return mav;
	}

	public int adminMovieModiModal(MovieDto mvInfo) {
		System.out.println("AdminService.adminMovieModiModal() 호출");
		ModelAndView mav = new ModelAndView();
		System.out.println("수정할 영화 정보 : " + mvInfo);
		int updateResult = adao.updateMovieInfo(mvInfo);
		return updateResult;
	}
	
	public ModelAndView adminTheaterList() {
		System.out.println("AdminService.adminTheaterList() 호출");
		ModelAndView mav = new ModelAndView();
		ArrayList<TheaterDto> thList = adao.getTheaterList();
		System.out.println("극장목록 : " + thList);
		mav.addObject("thList", thList);
		mav.setViewName("admin/AdminTheaterList");
		return mav;
	}

	public int changeThstate(String thcode, int thstate) {
		System.out.println("AdminService.changeThstate() 호출");
		System.out.println("변경할 영화코드 : " + thcode);
		System.out.println("변경할 활성 상태 : " + thstate);
		int updateThstate = adao.changeThstate(thcode, thstate);
		return updateThstate;
	}

	public int adminTheaterModi(TheaterDto thInfo) {
		System.out.println("AdminService.adminTheaterModi() 호출");
		System.out.println("수정할 극장정보 : " + thInfo);
		int updateResult = adao.updateTheaterInfo(thInfo);
		return updateResult;
	}

	public ModelAndView adminSchedulesList(boolean array) {
		System.out.println("AdminService.adminSchedulesList() 호출");
		ModelAndView mav = new ModelAndView();
		ArrayList<MovieDto> mvList = adao.getMvList();
		mav.addObject("mvList", mvList);
		ArrayList<TheaterDto> thList = adao.getTheaterList();
		mav.addObject("thList", thList);
		if (array) {
			mav.setViewName("admin/AdminSchedules_Array");
		} else {
			mav.setViewName("admin/AdminSchedules");
		}
		return mav;
	}

	public ModelAndView adminSchedulesRegister(SchedulesDto schedule, RedirectAttributes ra) {
		System.out.println("AdminService.adminSchedulesRegister() 호출");
		System.out.println("등록 요청 스케줄 : " + schedule);
		ModelAndView mav = new ModelAndView();
		
		// 극장, 상영관, 시간이 겹치지 않는지 확인
		int selectResult = adao.confirmScdate(schedule);
		if (selectResult == 0) {
			int insertResult = adao.insertSchedule(schedule);
			if(insertResult == 1) {
				ra.addFlashAttribute("msg", "스케줄이 등록되었습니다.");
			} else {
				ra.addFlashAttribute("msg", "스케줄 등록에 실패했습니다.");
			}
		} else {
			ra.addFlashAttribute("msg", "해당 상영관의 상영 시간이 중복됩니다.");
		}
		
		
		mav.setViewName("redirect:/adminSchedulesList");
		return mav;
	}

	public ModelAndView adminSchedulesRegister_Array(SchedulesDto schedule, RedirectAttributes ra) {
		System.out.println("AdminService.adminSchedulesRegister_Array() 호출");
		ModelAndView mav = new ModelAndView();
		schedule.setScday(schedule.getScdate());
		int count = 0;
		for(int i = 0; i < schedule.getScroomTime().length; i ++) {
			String[] scroomTime_split = schedule.getScroomTime()[i].split(" ");
			schedule.setScroom(scroomTime_split[0]);
			schedule.setScdate(schedule.getScday() + " " + scroomTime_split[1]);
			System.out.println("등록 요청 스케줄 : " + schedule);
			int insertResult = adao.insertSchedule(schedule);
			if(insertResult > 0) {
				count++;
			}
		}
		ra.addFlashAttribute("msg", count+"개의 상영스케줄이 등록되었습니다.");
		mav.setViewName("redirect:/adminSchedulesList?array=true");
		return mav;
	}

	
	
	
}
