package com.spring_movie01.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.servlet.ModelAndView;

import com.spring_movie01.dto.MemberDto;

public interface MemberDao {
	
	@Insert("INSERT INTO MEMBERS(MID,MPW,MNAME,MBIRTH,MEMAIL,MADDRESS,MPROFILE,MSTATE)" +
	  " VALUES(#{mid},#{mpw},#{mname},TO_DATE(#{mbirth},'YYYY-MM-DD'),#{memail},#{maddress},#{mprofile},0)") 
		// member 객체의 필드를 바로 명시 (?를 사용하지 않는다)
	int insertMember(MemberDto member);

	@Select("SELECT MID FROM MEMBERS WHERE MID=#{inputMid}")
	String memberIdCheck(String inputMid);

	@Select("SELECT MID FROM MEMBERS WHERE MID=#{inputMid} AND MPW=#{inputMpw}")
	String selectTest( @Param("inputMid") String inputMid, @Param("inputMpw") String inputMpw);
	// ﻿Dao에 여러 개의 파라미터를 넘겨줄 때는, @Param이라는 어노테이션과 변수명을 명시해주면서 변수를 받아야 함
	// 단순히 데이터타입과 변수명만 적으면, 똑같은 이름으로 받더라도 어떤 변수명을 어디에 써야하는지 인식하지 못함.

	@Select("SELECT MID,MPROFILE,MSTATE FROM MEMBERS WHERE MID=#{mid} AND MPW=#{mpw}")
	MemberDto memberLogin(@Param("mid") String mid, @Param("mpw") String mpw);

	@Select("SELECT MID,MPW,MNAME,TO_CHAR(MBIRTH,'YYYY-MM-DD') AS MBIRTH,MEMAIL,MADDRESS,MPROFILE,MSTATE"
			+ " FROM MEMBERS WHERE MID=#{loginId}")
	MemberDto selectMemberInfo(String loginId);

	@Update("UPDATE MEMBERS SET MSTATE=1 WHERE MID=#{withdrowId}")
	int wiithdrowMember(String withdrowId);

	@Update("UPDATE MEMBERS SET MPW=#{mpw},MNAME=#{mname},MBIRTH=TO_DATE(#{mbirth},'YYYY-MM-DD'),MEMAIL=#{memail},MADDRESS=#{maddress},MPROFILE=#{mprofile} WHERE MID=#{mid}")
	int updateMember(MemberDto modiMember);
	 
}
