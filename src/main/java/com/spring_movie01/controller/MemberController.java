package com.spring_movie01.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_movie01.dto.MemberDto;
import com.spring_movie01.service.MemberService;

@Controller
public class MemberController {
	
	private ModelAndView mav;
	
	@Autowired
	private MemberService mscv;
	
	@RequestMapping(value="/memberJoinForm")
	public String memberJoinForm() {
		System.out.println("회원가입 페이지 이동요청");
		
		return "member/MemberJoinForm";
	}
	
	@RequestMapping(value="/memberJoin")
	public ModelAndView memberJoin(MemberDto member) throws IllegalStateException, IOException {
		// return값이 ModelAndView
		System.out.println("회원가입 요청");
		System.out.println(member);
		
		// 서비스에서 모든 데이터와 이동할 페이지까지 모두 담아 컨트롤러로 넘겨줌
		mav = mscv.memberJoin(member); // mfile.tranferTo에서 생기는 예외를 던진다.
		// 컨트롤러에서는 mav만 브라우저로 전송해주는 역할
		return mav;
	}
	
	@RequestMapping(value="/memberIdCheck")
	public @ResponseBody String memberIdCheck(String inputMid) {
		System.out.println("아이디 중복 확인 요청");
		System.out.println("입력한 아이디 : " + inputMid);
		String idCheckResult = mscv.memberIdCheck(inputMid);
		return idCheckResult;
	}
	
	@RequestMapping(value="/memberLoginForm")
	public String memberLoginForm() {
		System.out.println("로그인 페이지 이동 요청");
		return "member/MemberLoginForm";
	}
	
	@RequestMapping(value="/memberLogin")				 // redirect로 넘겨줄 떄 파라미터를 붙여서 넘겨주는 것
	public ModelAndView memberLogin(String mid, String mpw, RedirectAttributes ra) {
		System.out.println("로그인 요청");
		mav = mscv.memberLogin(mid, mpw, ra);
		return mav;
	}
	
	@RequestMapping(value="/memberLogout")
	public ModelAndView memberLogout(RedirectAttributes ra) {
		System.out.println("로그아웃 요청");
		mav = mscv.memberLogout(ra);
		return mav;
	}

	@RequestMapping(value="/memberInfoForm")
	public ModelAndView memberInfoForm() {
		System.out.println("회원정보 페이지 이동 요청");
		mav = mscv.memberInfoForm();
		return mav;
	}
	
	@RequestMapping(value="/memberWithdrow")
	public ModelAndView memberWithdrow(RedirectAttributes ra) {
		System.out.println("회원탈퇴 요청");
		mav = mscv.memberWithdrow(ra);
		return mav;
	}
	
	@RequestMapping(value="/modifyMember")
	public String modifyMember(MemberDto modiMember) throws IllegalStateException, IOException {
		System.out.println("회원정보 수정 요청");
		System.out.println(modiMember);
		int updateResult = mscv.modifyMember(modiMember);
		return "redirect:/memberInfoForm";
	}
	
}
