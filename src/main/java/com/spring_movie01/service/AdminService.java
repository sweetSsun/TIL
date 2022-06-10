package com.spring_movie01.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring_movie01.dao.MemberDao;
import com.spring_movie01.dao.MovieDao;
import com.spring_movie01.dto.MovieDto;
import com.spring_movie01.dto.ReviewDto;

@Service
public class AdminService {

	@Autowired
	MovieDao mvdao;
	@Autowired
	MemberDao mdao;
	
	ModelAndView mav;
	
	public ModelAndView adminMovieList() {
		System.out.println("AdminService.adminMovieList() 호출");
		ModelAndView mav = new ModelAndView();
		// 1. 영화목록 조회
		ArrayList<MovieDto> mvList = mvdao.selectMovieList();
		System.out.println(mvList);
		
		int sumRecount = mvList.get(0).getSumrecount(); // 총 예매횟수
		for(int i = 0; i < mvList.size(); i++) {
			// 예매율 저장
			double rerate = (double)mvList.get(i).getRecount() / sumRecount * 100;
			rerate = Math.round(rerate*100)/100.0;
			mvList.get(i).setRerate(rerate);

			// 추천수 저장
			ArrayList<ReviewDto> totalRv = mvdao.getTotalReview(mvList.get(i).getMvcode());
			int badCount = 0;
			int goodCount = 0;
			for (int j = 0; j < totalRv.size(); j++) {
				if(totalRv.get(j).getRvrecommend()==0) {
					badCount++;
				} else {
					goodCount++;
				}
			}
			mvList.get(i).setRecommend0(badCount);
			mvList.get(i).setRecommend1(goodCount);
		}
		mav.addObject("mvList", mvList);
		// 2. 영화목록 페이지
		mav.setViewName("movie/AdminMovieList");
		return mav;
	}
}
