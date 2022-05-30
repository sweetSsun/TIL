package com.spring_movie01.service;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring_movie01.dao.MovieDao;
import com.spring_movie01.dto.MovieDto;

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

}
