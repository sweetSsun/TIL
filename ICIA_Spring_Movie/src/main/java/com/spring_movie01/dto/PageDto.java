package com.spring_movie01.dto;

import lombok.Data;

@Data
public class PageDto {
	
	private int page;
	private int maxPage;
	private int startPage;
	private int endPage;
}
