package com.spring_movie01.dto;

import lombok.Data;

@Data
public class MovieDto {
	
	private String mvcode;		//영화코드
	private String mvname;		//영화제목
	private String mvpd;		//영화감독
	private String mvactor; 	//배우
	private String mvgenre;		//장르
	private String mvage;		//관람연령
	private String mvtime;		//시간
	private String mvopen;		//개봉일
	
	private String mvposter;	//영화포스터
	
	private int recount; 		// 예매횟수
	private double rerate; 		// 예매율
}
