package com.spring_movie01.dto;

import lombok.Data;

@Data
public class SchedulesDto {

	private String scroom;
	private String scdate;
	
	private String scday;
	private String sctime;
	
	private String scthcode;
	private String scmvcode;
	
	private String confirmTime;
	private String[] scroomTime;
	private String mvname;
}
