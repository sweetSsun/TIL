package com.spring_movie01.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spring_movie01.dto.MovieDto;


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
	
}
