package com.spring_movie01.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberDto {

	private String mid;
	private String mpw;
	private String mname;
	private String mbirth;
	
	private String memail;
	private String maddress;	// 전체주소
	
	private String mpostcode;	// 우편번호
	private String maddr;		// 주소
	private String mdetailAddr;	// 상세주소
	private String mextraAddr;	// 참고항목
	
	private MultipartFile mfile; // 프로필 파일
	private String mprofile; 	 // 프로필 파일 이름

	private int mstate;
	
}
