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
import com.spring_movie01.dao.MovieDao;
import com.spring_movie01.dto.MovieDto;
import com.spring_movie01.dto.ReservationDto;
import com.spring_movie01.dto.SchedulesDto;
import com.spring_movie01.dto.TheaterDto;

@Service
public class MovieService {

	@Autowired
	MovieDao mvdao;

	public ModelAndView getCgvMovieList() throws IOException {
		System.out.println("MovieService.getCgvMovieList() 호출");
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
			int mvCheck = mvdao.selectMvCheck(cgvMvList.get(i).getMvname(), cgvMvList.get(i).getMvopen());
			if(mvCheck == 0) {
				// 1. 영화코드 생성 (select)
				String maxMvcode = mvdao.getMaxMvcode();
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
				mvdao.insertMovieInfo(cgvMvList.get(i));
				insertCount++;
			}
		}
		System.out.println("insertCount : " + insertCount);
		mav.setViewName("redirect:/");
		return mav;
	}

	public ModelAndView movieList() {
		System.out.println("MovieService.movieList() 호출");
		ModelAndView mav = new ModelAndView();
		// 1. 영화목록 조회
		ArrayList<MovieDto> mvList = mvdao.selectMovieList();
		System.out.println(mvList);
		mav.addObject("mvList", mvList);
		
		// 2. 영화목록 페이지
		mav.setViewName("movie/MovieList");
		return mav;
	}

	public ModelAndView movieInfoView(String mvcode) {
		System.out.println("MovieService.movieInfoView() 호출");
		ModelAndView mav = new ModelAndView();
		System.out.println("영화코드 : " + mvcode);
		MovieDto movieInfo = mvdao.selectMovieInfo(mvcode);
		mav.addObject("movieInfo", movieInfo);
		mav.setViewName("movie/MovieView");
		return mav;
	}

	public ModelAndView movieReservationPage() {
		System.out.println("MovieService.movieReservationPage() 호출");
		ModelAndView mav = new ModelAndView();
		// 1. 영화목록 조회 (예매가능한 영화)
		ArrayList<MovieDto> reMvList = mvdao.selectReserveMvList();
		System.out.println(reMvList);
			
		mav.addObject("reMvList", reMvList);
		mav.setViewName("movie/MovieReservationPage");
		return mav;
	}

	public String getThList(String mvcode) {
		System.out.println("MovieService.getThList() 호출");
		System.out.println("선택한 영화 코드 : " + mvcode);
		
		ArrayList<TheaterDto> thList = mvdao.selectReservThList(mvcode);
		Gson gson = new Gson();
		String thList_json = gson.toJson(thList);
		System.out.println(thList_json);
		return thList_json;
	}

	public String getScDay(String mvcode, String thcode) {
		System.out.println("MovieService.getScDay() 호출");
		System.out.println("영화코드 : " + mvcode + " / 극장코드 : " + thcode);
		ArrayList<SchedulesDto> dayList = mvdao.getScDay(mvcode, thcode);
		Gson gson = new Gson();
		String dayList_json = gson.toJson(dayList);
		return dayList_json;
	}

	public String getScTime(String mvcode, String thcode, String scday) {
		System.out.println("MovieService.getScTime() 호출");
		System.out.println("영화코드 : " + mvcode + " / 극장코드 : " + thcode + " / 날짜 : " + scday);
		ArrayList<SchedulesDto> timeList = mvdao.getScTime(mvcode, thcode, scday);
		Gson gson = new Gson();
		String timeList_json = gson.toJson(timeList);
		return timeList_json;
	}

	public ModelAndView movieReservation(ReservationDto redto, RedirectAttributes ra) {
		System.out.println("MovieService.movieReservation() 호출");
		ModelAndView mav = new ModelAndView();
		// 상영 날짜 및 시간 합치기
		String rescdate = redto.getRescday() + " " + redto.getResctime();
		redto.setRescdate(rescdate);
		System.out.println(redto);
		// 예매코드 생성
		String getMaxRecode = mvdao.getMaxRecode();
		String Recode = "RE";
		int RecodeNum = Integer.parseInt(getMaxRecode.substring(2)) + 1;
		if (RecodeNum < 10) {
			Recode += "00" + RecodeNum;
		} else if (RecodeNum < 100) {
			Recode += "0" + RecodeNum;
		} else {
			Recode += RecodeNum;
		}
		System.out.println("예매코드 : " + Recode);
		redto.setRecode(Recode);
		// 예매 테이블 INSERT
		int insertResult = mvdao.insertReservation(redto);
		System.out.println(insertResult);
		if (insertResult > 0) {
			mav.setViewName("movie/ReservationInfo");
		} else {
			ra.addFlashAttribute("msg", "예매에 실패했습니다.");
			mav.setViewName("redirect:/movieReservationPage");
		}
		return mav;
	}

}
