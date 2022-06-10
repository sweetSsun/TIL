package com.spring_movie01.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.spring_movie01.dao.MovieDao;
import com.spring_movie01.dto.MovieDto;
import com.spring_movie01.dto.PageDto;
import com.spring_movie01.dto.ReservationDto;
import com.spring_movie01.dto.ReviewDto;
import com.spring_movie01.dto.SchedulesDto;
import com.spring_movie01.dto.TheaterDto;

@Service
public class MovieService {

	@Autowired
	MovieDao mvdao;
	
	@Autowired
	private HttpSession session;

	public ModelAndView movieList() {
		System.out.println("MovieService.movieList() 호출");
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
		mav.setViewName("movie/MovieList");
		return mav;
	}

	public ModelAndView movieInfoView(String mvcode) {
		System.out.println("MovieService.movieInfoView() 호출");
		ModelAndView mav = new ModelAndView();
		System.out.println("영화코드 : " + mvcode);
		// 영화정보
		MovieDto movieInfo = mvdao.selectMovieInfo(mvcode);
		// 예매율 저장
		int sumRecount = movieInfo.getSumrecount();
		double rerate = (double) movieInfo.getRecount() / sumRecount * 100;
		rerate = Math.round(rerate*100)/100.0;
		movieInfo.setRerate(rerate);
		
		// 댓글정보
		ArrayList<ReviewDto> totalRv = mvdao.getTotalReview(mvcode);
		// 추천수 저장
		int badCount = 0;
		int goodCount = 0;
		for(int i = 0; i < totalRv.size(); i++) {
			if (totalRv.get(i).getRvrecommend() == 0) {
				badCount++;
			} else {
				goodCount++;
			}
		}
		movieInfo.setRecommend0(badCount);
		movieInfo.setRecommend1(goodCount);
		
		// 개행문자 변환
		ArrayList<ReviewDto> rvList = mvdao.getReviewPagingList(mvcode, 1, 6);
		for(int i = 0; i < rvList.size(); i++) {
			System.out.println("mstate : " + rvList.get(i).getMstate());
			String rvcomment = rvList.get(i).getRvcomment();
			rvcomment = rvcomment.replace(" ", "&nbsp;");
			rvcomment = rvcomment.replace("\r\n", "<br>");
			totalRv.get(i).setRvcomment(rvcomment);
		}
		mav.addObject("rvList", rvList);
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
		String recode = "RE";
		int RecodeNum = Integer.parseInt(getMaxRecode.substring(2)) + 1;
		if (RecodeNum < 10) {
			recode += "00" + RecodeNum;
		} else if (RecodeNum < 100) {
			recode += "0" + RecodeNum;
		} else {
			recode += RecodeNum;
		}
		System.out.println("예매코드 : " + recode);
		redto.setRecode(recode);
		// 예매 테이블 INSERT
		int insertResult = mvdao.insertReservation(redto);
		// 예매 정보 SELECT
		ReservationDto ReInfo = mvdao.reservationInfo(recode);
		ra.addFlashAttribute("ReInfo", ReInfo);

		// 관람예정 예매정보 업데이트
		int recendRecount = (int) session.getAttribute("recentReCount");
		session.setAttribute("recentReCount", recendRecount+1);
		
//		mav.setViewName("redirect:/reservationInfo?recode=" + recode);
		mav.setViewName("redirect:/");
		return mav;
	}
	
	public ModelAndView reservationInfo(String recode) {
		System.out.println("MovieService.reservationInfo() 호출");
		ModelAndView mav = new ModelAndView();
		// 예매 정보 조회
		ReservationDto redto = mvdao.reservationInfo(recode);
		mav.addObject("redto", redto);
		mav.setViewName("movie/ReservationInfo");
		return mav;
	}

	public ModelAndView reservationList() {
		System.out.println("MovieService.reservationList() 호출");
		ModelAndView mav = new ModelAndView();
		String loginId = (String) session.getAttribute("loginId");
		if(loginId == null) {
			loginId = "";
		}
		ArrayList<ReservationDto> reList =  mvdao.reservationList(loginId);
		System.out.println(reList);
		mav.addObject("reList", reList);
		mav.setViewName("movie/ReservationList");
		return mav;
	}

	public ModelAndView deleteReservation(String recode, RedirectAttributes ra) {
		System.out.println("MovieService.deleteReservation() 호출");
		ModelAndView mav = new ModelAndView();
		mvdao.deleteReservation(recode);
		
		ra.addFlashAttribute("msg", "예매취소 되었습니다.");
		mav.setViewName("redirect:/reservationList");
		return mav;
	}

	public ModelAndView insertReview(ReviewDto rvdto, RedirectAttributes ra) {
		System.out.println("MovieService.insertReview() 호출");
		ModelAndView mav = new ModelAndView();
		mvdao.insertReview(rvdto);
		System.out.println("insertReview 영화코드 " + rvdto.getRvmvcode());
		
		ra.addFlashAttribute("msg", "관람평이 작성되었습니다.");
		mav.setViewName("redirect:/movieView?mvcode="+rvdto.getRvmvcode());
		return mav;
	}

	public String getReview(String rvrecode) {
		System.out.println("MovieService.getReview() 호출");
		ReviewDto rvInfo = mvdao.getMyReview(rvrecode);
		Gson gson = new Gson();
		String rvInfo_json = gson.toJson(rvInfo);
		System.out.println("내 관람평 : " + rvInfo_json);
		return rvInfo_json;
	}

	public ModelAndView modifyReview(ReviewDto rvdto, RedirectAttributes ra) {
		System.out.println("MovieService.modifyReview() 호출");
		ModelAndView mav = new ModelAndView();
		mvdao.updateReview(rvdto);
		ra.addFlashAttribute("msg", "관람평이 수정되었습니다.");
		mav.setViewName("redirect:/movieView?mvcode="+rvdto.getRvmvcode());
		return mav;
	}

	public String pagingReview(String mvcode, int requestPage) {
		System.out.println("MovieService.pagingReview() 호출");
		Gson gson = new Gson();
		
		int page;
		if(requestPage > 0) {
			page = requestPage;
		} else {
			page = 1;
		}
		System.out.println("페이지 번호 : " + page);
		
		// 관람평 총 갯수
		int viewCount = 6;
		int startRow = (page-1)*viewCount+1;
		int endRow = page*viewCount;
		
		ArrayList<ReviewDto> reviewPagingList = mvdao.getReviewPagingList(mvcode, startRow, endRow);
		String pagingReviewList_json = gson.toJson(reviewPagingList);
		return pagingReviewList_json;
	}

	public String pagingNumber(String mvcode, int requestPage) {
		System.out.println("MovieService.pagingNumber() 호출");
		Gson gson = new Gson();
		int page;
		if(requestPage > 0) {
			page = requestPage;
		} else {
			page = 1;
		}
		System.out.println("페이지 번호 : " + page);
		
		// 관람평 총 갯수
		int reviewTotalCount = mvdao.getReviewTotalCount(mvcode);
		int viewCount = 6;
		int pageNumCount = 5;
		
		// 페이지번호 최대값
		int maxPage = (int) (Math.ceil((double)reviewTotalCount/viewCount));
		// 출력페이지 번호 시작값
		int startPage = (int) ( (Math.ceil((double)page/pageNumCount) -1) ) * pageNumCount +1;
		// 출력페이지 번호 마지막값
		int endPage = startPage + pageNumCount - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		PageDto pagedto = new PageDto();
		pagedto.setPage(page);
		pagedto.setMaxPage(maxPage);
		pagedto.setStartPage(startPage);
		pagedto.setEndPage(endPage);
		String pagedto_json = gson.toJson(pagedto);
		System.out.println(pagedto_json);
		return pagedto_json;
	}

	public ModelAndView getSearchMovie(String searchText) {
		System.out.println("MovieService.getSearchMovie() 호출");
		ModelAndView mav = new ModelAndView();
		System.out.println("검색할 단어 : " + searchText);
		ArrayList<MovieDto> searchAllMvList = mvdao.getSearchMvList(searchText, "movie");
		System.out.println( "모든 영화 검색 : " + searchAllMvList);
		
		ArrayList<MovieDto> searchScMvList = mvdao.getSearchMvList(searchText, "schedule");
		System.out.println("상영중인 영화 검색 : " + searchScMvList );
		
		int sumRecount = searchScMvList.get(0).getSumrecount(); // 총 예매횟수
		for(int i = 0; i < searchScMvList.size(); i++) {
			// 예매율 저장
			double rerate = (double)searchScMvList.get(i).getRecount() / sumRecount * 100;
			rerate = Math.round(rerate*100)/100.0;
			searchScMvList.get(i).setRerate(rerate);
		}
		mav.addObject("searchAllMvList", searchAllMvList);
		mav.addObject("searchScMvList", searchScMvList);
		mav.setViewName("movie/SearchMovieList");
		return mav;
	}

	public String getRecentReserve(String loginId) {
		System.out.println("MovieService.getRecentReserve() 호출");
		Gson gson = new Gson();
		ArrayList<ReservationDto> recentRvList = mvdao.getRecentReserve(loginId);
		String recentRvList_json = gson.toJson(recentRvList);
		return recentRvList_json;
	}
	
	

	
}
