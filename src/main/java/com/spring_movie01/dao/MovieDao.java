package com.spring_movie01.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring_movie01.dto.MovieDto;
import com.spring_movie01.dto.ReservationDto;
import com.spring_movie01.dto.ReviewDto;
import com.spring_movie01.dto.SchedulesDto;
import com.spring_movie01.dto.TheaterDto;


public interface MovieDao {

	@Select("SELECT COUNT(*) FROM MOVIES WHERE MVNAME=#{mvname} AND TO_CHAR(MVOPEN,'YYYY.MM.DD')=#{mvopen}")
	int selectMvCheck(@Param("mvname") String mvname, @Param("mvopen") String mvopen);
	
	@Select("SELECT NVL(MAX(MVCODE),'MV001') FROM MOVIES")
	String getMaxMvcode();
	
	@Insert("INSERT INTO MOVIES(MVCODE,MVNAME,MVPD,MVACTOR,MVGENRE,MVAGE,MVTIME,MVOPEN,MVPOSTER)"
			+ " VALUES (#{mvcode},#{mvname},#{mvpd},#{mvactor},#{mvgenre},#{mvage},#{mvtime},TO_DATE(#{mvopen},'YYYY.MM.DD'),#{mvposter})")
	void insertMovieInfo(MovieDto mdto);

	ArrayList<MovieDto> selectMovieList();

	MovieDto selectMovieInfo(String mvcode);

	ArrayList<MovieDto> selectReserveMvList();

	ArrayList<TheaterDto> selectReservThList(String mvcode);

	ArrayList<SchedulesDto> getScDay(@Param("mvcode") String mvcode, @Param("thcode") String thcode);

	ArrayList<SchedulesDto> getScTime(@Param("mvcode") String mvcode, @Param("thcode") String thcode, @Param("scday") String scday);

	@Select("SELECT NVL(MAX(RECODE),'RE000') FROM RESERVATION")
	String getMaxRecode();

	int insertReservation(ReservationDto redto);

	ArrayList<ReservationDto> getRecentReserve(String mid);

	ReservationDto reservationInfo(String recode);

	ArrayList<ReservationDto> reservationList(String loginId);
	
	@Delete("DELETE FROM RESERVATION WHERE RECODE=#{recode}")
	void deleteReservation(String recode);

	@Insert("INSERT INTO REVIEW VALUES(#{rvrecode}, #{rvmid}, #{rvmvcode}, #{rvcomment}, SYSDATE, #{rvrecommend})")
	void insertReview(ReviewDto rvdto);

	ArrayList<ReviewDto> getTotalReview(String mvcode);

	@Select("SELECT RVRECODE,RVMID,RVMVCODE,RVCOMMENT,TO_CHAR(RVDATE,'YYYY.MM.DD HH24:MI') AS RVDATE,RVRECOMMEND FROM REVIEW WHERE RVRECODE=#{rvrecode}")
	ReviewDto getMyReview(String rvrecode);

	@Update("UPDATE REVIEW SET RVCOMMENT=#{rvcomment}, RVRECOMMEND=#{rvrecommend} WHERE RVRECODE=#{rvrecode}")
	void updateReview(ReviewDto rvdto);

	@Select("SELECT COUNT(*) FROM REVIEW WHERE RVMVCODE=#{mvcode}")
	int getReviewTotalCount(String mvcode);

	ArrayList<ReviewDto> getReviewPagingList(@Param("mvcode")String mvcode, @Param("startRow") int startRow, @Param("endRow") int endRow);

	ArrayList<MovieDto> getSearchMvList(@Param("searchText") String searchText, @Param("checkWhere") String checkWhere);
	
}
