package com.spring_movie01.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_movie01.dao.MemberDao;
import com.spring_movie01.dao.MovieDao;
import com.spring_movie01.dto.MemberDto;
import com.spring_movie01.dto.ReservationDto;

@Service
public class MemberService {     

	private ModelAndView mav;
	
	@Autowired
	private MemberDao mdao;
	
	@Autowired
	private MovieDao mvdao;
	
	@Autowired // 세션은 별다른 설정을 하지 않아도 autowired 사용 가능
	private HttpSession session;
	
	// 2. 저장경로 설정
	private String savePath = "D:\\Spring_Workspace\\spring_movie01\\src\\main\\webapp\\resources\\mprofileUpload";
		
	// 회원가입
	public ModelAndView memberJoin(MemberDto member) throws IllegalStateException, IOException {
		System.out.println("MemberService.memberJoin() 호출");
		mav = new ModelAndView();
		MultipartFile mfile = member.getMfile();
		// MyBatis 사용 시 null값일 경우의 설정이 필요하기 때문에 길이가 0인 문자로 고정
		String mprofile = ""; 	 // 첨부파일이 없었으면 ""로 저장		
		
		// mfile.isEmpty() :: 비어있으면 true / 비어있지 않으면 false 반환
		if(!mfile.isEmpty()) { // 첨부파일이 있을 때만 파일처리를 하도록
			System.out.println("첨부파일 있음");
			// 32자리의 랜덤코드가 생성되는 메소드
			UUID uuid = UUID.randomUUID();
			// 1. 파일명 생성
			mprofile = uuid.toString() + "_" + mfile.getOriginalFilename();
			// 3. 프로필 이미지 파일 저장
		// mfile에 있는 내용을 변환하여 // 이름만 있는 비어있는 파일에 저장한다
			mfile.transferTo( new File(savePath, mprofile) ); // 발생하는 예외는 throws로 던진다
		}
		System.out.println("mprofile : " + mprofile);
		member.setMprofile(mprofile);
		
		// 주소 처리
		member.setMaddress(member.getMpostcode()+"_"+member.getMaddr()
							+"_"+member.getMdetailAddr()+"_"+member.getMextraAddr());
		
		// 회원가입 처리 (dao - insert문)
		int joinResult = mdao.insertMember(member);
		
		
		// 페이지 저장
//		mav.setViewName("Main"); // O :: 페이지명 직접 지정. Main.jsp
//		mav.setViewName("/Board/boardView"); // X :: url을 작성해도 Board 폴더의 boardView.jsp를 찾아감
		
		// redirect 형식으로 넘기는 방법
		mav.setViewName("redirect:/"); // O :: jsp 파일을 찾는게 아니고 url 형식으로 인식
		
		return mav;
	}

	// 아이디 중복 확인
	public String memberIdCheck(String inputMid) {
		System.out.println("MemberService.memberIdCheck() 호출");
		String idCheckResult = mdao.memberIdCheck(inputMid);
		System.out.println(idCheckResult);
		return idCheckResult;
	}

	// 로그인 처리
	// loginId, profileImg를 받아서 반환
	public ModelAndView memberLogin(String mid, String mpw, RedirectAttributes ra) {
		System.out.println("MemberService.memberLogin() 호출");
		mav = new ModelAndView();
		MemberDto loginmember = mdao.memberLogin(mid, mpw);
		if (loginmember != null) { // 로그인 성공
			if (loginmember.getMstate() == 1) {
				ra.addFlashAttribute("msg",	"탈퇴한 계정입니다.");
				mav.setViewName("redirect:/memberLoginForm");
			} else {
				// 기한이 남은 예매정보 조회
				ArrayList<ReservationDto> recentReList = mvdao.getRecentReserve(mid);
				int recentReCount = recentReList.size();
				System.out.println("볼 예정인 예매정보갯수 : " + recentReCount);
				System.out.println("예매정보 : " + recentReList);
				session.setAttribute("recentReCount", recentReCount);
				session.setAttribute("loginId", loginmember.getMid());
				session.setAttribute("mprofile", loginmember.getMprofile());
				session.setAttribute("mstate", loginmember.getMstate());
				mav.setViewName("redirect:/");
			}
		} else { // 로그인 실패
			ra.addFlashAttribute("msg",	"아이디 또는 비밀번호가 일치하지 않습니다.");
			// redirect 형식으로 넘어갈 때만 사용 가능.
			// 일회용. 휘발성 attribute이기 때문에 한 번 사용한 후에는 사라져버린다.
			mav.setViewName("redirect:/memberLoginForm");
			
			/*
			mav.addObject("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			mav.setViewName("member/MemberLoginForm");
			 */
			// mav 사용해서 request 영역에 담아 dispatcher 방식으로 보내면, request 영역에 살아있는 동안은 계속해서 사용하게 됨.
		}
		return mav;
	}
	
	public ModelAndView memberLogout(RedirectAttributes ra) {
		System.out.println("MemberService.memberLogout() 호출");
		mav = new ModelAndView();
		session.invalidate();
		ra.addFlashAttribute("msg", "로그아웃 되었습니다.");
		mav.setViewName("redirect:/");
		return mav;
	}

	public ModelAndView memberInfoForm() {
		System.out.println("MembeService.memberInfoForm() 호출");
		mav = new ModelAndView();
		String loginId = (String) session.getAttribute("loginId");
		MemberDto member = mdao.selectMemberInfo(loginId);
		if (member.getMaddress()!=null) {
			String addressSplit[] = member.getMaddress().split("_");
			for(int i = 0; i < addressSplit.length; i++) {
				if (addressSplit[i].equals("null")) {
					addressSplit[i] = "";
				}
			}
			member.setMpostcode(addressSplit[0]);
			member.setMaddr(addressSplit[1]);
			member.setMdetailAddr(addressSplit[2]);
			member.setMextraAddr(addressSplit[3]);
		}
		mav.addObject("member", member);
		mav.setViewName("member/MemberInfoForm");
		System.out.println(mav);
		return mav;
	}

	public ModelAndView memberWithdrow(RedirectAttributes ra) {
		System.out.println("MemberService.memberWithdrow() 호출");
		mav = new ModelAndView();
		String withdrowId = (String) session.getAttribute("loginId");
		int withdrowResult = mdao.wiithdrowMember(withdrowId);
		if (withdrowResult > 0) {
			ra.addFlashAttribute("msg", "회원탈퇴 하였습니다.");
			session.invalidate();
		} else {
			ra.addFlashAttribute("msg", "회원탈퇴에 실패하였습니다.");
		}
		mav.setViewName("redirect:/");
		return mav;
	}

	public int modifyMember(MemberDto modiMember) throws IllegalStateException, IOException {
		System.out.println("MemberService.modifyMember() 호출");
		
		MultipartFile mfile = modiMember.getMfile();
		String mprofile = ""; 	 // 첨부파일이 없었으면 ""로 저장		
		String orgMprofile = (String) session.getAttribute("mprofile");
		System.out.println("원본프로필 : " + orgMprofile);
		if(!mfile.isEmpty()) { // 기존프로필 삭제 / 새 프로필 저장
			UUID uuid = UUID.randomUUID();
			mprofile = uuid.toString() + "_" + mfile.getOriginalFilename();
			mfile.transferTo( new File(savePath, mprofile) ); // 발생하는 예외는 throws로 던진다
			modiMember.setMprofile(mprofile);
			System.out.println("변경프로필 : " + mprofile);
		} else {
			if( orgMprofile != null) { // 기존프로필 이름 입력
				modiMember.setMprofile(orgMprofile);
			} else { // "" 입력
				modiMember.setMprofile(mprofile);
			}
		}
		
		System.out.println("최종프로필 : " + modiMember.getMprofile());
		
		modiMember.setMaddress(modiMember.getMpostcode()+"_"+modiMember.getMaddr()
		+"_"+modiMember.getMdetailAddr()+"_"+modiMember.getMextraAddr());
		System.out.println("서비스에서 modiMember : " + modiMember);
		
		int updateResult = mdao.updateMember(modiMember);
		System.out.println(updateResult);
		if (updateResult > 0) {
			if( !mfile.isEmpty() && orgMprofile != null) {
				System.out.println("기존파일 삭제");
				File delFile = new File(savePath, orgMprofile);
				delFile.delete();
			}
			session.setAttribute("mprofile", modiMember.getMprofile());
		}
		return updateResult;
	}

	public ModelAndView kakaoLogin(MemberDto member, RedirectAttributes ra) {
		System.out.println("MemberService.kakaoLogin() 호출");
		mav = new ModelAndView();
		
		String mid = mdao.memberIdCheck(member.getMid());
		if (mid == null) {
			int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 10;
		    Random random = new Random();
		    String randomPw = random.ints(leftLimit, rightLimit + 1)
		                                   .limit(targetStringLength)
		                                   .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		                                   .toString();
		    System.out.println("randomPw : " + randomPw);
		    member.setMpw(randomPw);
			
		    ra.addFlashAttribute("msg", "카카오계정으로 회원가입 되었습니다.");
		    mdao.insertKakaoMember(member);
		    mav.setViewName(randomPw);
		}
		session.setAttribute("loginId", member.getMid());
		session.setAttribute("mprofile", member.getMprofile());
		session.setAttribute("mstate", 2);
		mav.setViewName("redirect:/");
		return mav;
	}
	
	
	
}
