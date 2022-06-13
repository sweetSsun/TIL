package com.spring_movie01.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring_movie01.dto.MovieDto;

public interface AdminDao {

	@Select("SELECT COUNT(*) FROM MOVIES WHERE MVNAME=#{mvname} AND TO_CHAR(MVOPEN,'YYYY.MM.DD')=#{mvopen}")
	int selectMvCheck(@Param("mvname") String mvname, @Param("mvopen") String mvopen);
	
	@Select("SELECT NVL(MAX(MVCODE),'MV001') FROM MOVIES")
	String getMaxMvcode();
	
	@Insert("INSERT INTO MOVIES(MVCODE,MVNAME,MVPD,MVACTOR,MVGENRE,MVAGE,MVTIME,MVOPEN,MVPOSTER)"
			+ " VALUES (#{mvcode},#{mvname},#{mvpd},#{mvactor},#{mvgenre},#{mvage},#{mvtime},TO_DATE(#{mvopen},'YYYY.MM.DD'),#{mvposter})")
	void insertMovieInfo(MovieDto mdto);

	@Update("UPDATE MOVIES SET MVSTATE=${mvstate} WHERE MVCODE=#{mvcode}")
	void changeMvstate(@Param("mvcode")String mvcode, @Param("mvstate") int mvstate);
	
	@Select("SELECT MVSTATE FROM MOVIES WHERE MVCODE=#{mvcode}")
	int getMvstate(String mvcode);

	int updateMovieInfo(MovieDto mvInfo);

}
