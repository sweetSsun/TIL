package jdbc2_Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {

	Scanner scan = new Scanner(System.in);
	
	private MemberDao mdao = new MemberDao();
	private String loginId = ""; // 로그인 처리된 아이디
	Member mb;
	
	
    // 메뉴출력 메소드
	public void showMenu() {
		
		if(loginId.equals("")) {
			System.out.println("\n==========================");
			System.out.println("1.회원가입 | 2.로그인 | 0.종료");
			System.out.println("==========================");
			System.out.print("메뉴 선택 >> ");
		} else if(loginId.equals("admin")) {
			System.out.println("\n===============================");
			System.out.println("1.전체 회원정보 | 2.로그아웃 | 0.종료");
			System.out.println("===============================");
			System.out.print("메뉴 선택 >> ");
		} else {
			System.out.println("\n================================================");
			System.out.println("1.내 정보 | 2.로그아웃 | 3.정보수정 | 4.회원탈퇴 | 0.종료");
			System.out.println("================================================");
			System.out.print("메뉴 선택 >> ");
		}
	}
	
	
	public void selectMenuOne() {
		if(loginId.equals("")) { // 로그인 안된 상태
			memberJoin(); // 회원가입 메소드 호출
		} else if(loginId.equals("admin")) {
			memberInfo(); // 전체회원정보 메소드 호출
		} else {
			myInfo(); // 내정보 메소드 호출
		}
	}
	
	public void selectMenuTwo() {
		if(loginId.equals("")) {
			memberLogin();
		} else {
			memberLogout();
		}
	}
	

	// 회원가입 메소드
	public void memberJoin() {
		System.out.println("[회원가입]");
		mb = new Member();
		System.out.print("가입할 아이디 >> ");
		String mid = scan.next();
		System.out.print("가입할 비밀번호 >> ");
		String mpw = scan.next();
		System.out.print("가입할 이름 >> ");
		String mname = scan.next();
		System.out.print("가입할 이메일 주소 >> ");
		String memail = scan.next();
		
		mb.setMid(mid);
		mb.setMpw(mpw);
		mb.setMname(mname);
		mb.setMemail(memail);
		
		// dao에 전달 >> insert문 수행
		int joinResult = mdao.memberJoin(mb);
		System.out.println("insertResult : " + joinResult);
		System.out.println("회원가입 되었습니다.");
	}
	
	// 전체 회원정보 메소드
	public void memberInfo() {
		System.out.println("[전체 회원정보]");
		ArrayList<Member> mbList = mdao.memberInfo();
		mbList = mdao.memberInfo();
		for (int i = 0; i < mbList.size(); i++) {
			System.out.println("아이디 : " + mbList.get(i).getMid()
			+ ", 이름 : " + mbList.get(i).getMname()
			+ ", 이메일 : " + mbList.get(i).getMemail() );
		}
		
	}
	
	// 내정보 메소드
	public void myInfo() {
		System.out.println("[내정보]");
		mb = mdao.myInfo(loginId);
		System.out.println("아이디 : " + mb.getMid()
				+ ", 비밀번호 : " + mb.getMpw()
				+ ", 이름 : " + mb.getMname()
				+ ", 이메일 : " + mb.getMemail() );
	}
	
	// 로그인 메소드
	public void memberLogin() {
		System.out.println("[로그인]");
		System.out.print("아이디 >> ");
		String loginId = scan.next();
		System.out.print("비밀번호 >> ");
		String loginPw = scan.next();
		
		// dao에 전달 >> select문 수행
		String mid = mdao.memberLogin(loginId, loginPw);
		if (mid != null) {
			this.loginId = mid;
			System.out.println("로그인 되었습니다.");
		} else if(loginId.equals("admin") && loginPw.equals("admin")) {
			this.loginId = loginId;
			System.out.println("관리자 계정으로 로그인 되었습니다.");
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	}

	// 로그아웃 메소드
	public void memberLogout() {		
		this.loginId = "";
		System.out.println("로그아웃 되었습니다.");
	}

	// 정보수정 메소드
	public void updateMemberInfo() {
		System.out.println("[정보수정]");
		System.out.print("비밀번호 확인 >> ");
		String mpw = scan.next();
		System.out.print("새 이메일 입력 >> ");
		String newEmail = scan.next();

		int updateResult = mdao.updateMemail(loginId, mpw, newEmail);
		if (updateResult > 0) {
			System.out.println("이메일이 수정되었습니다.");
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}

	// 회원탈퇴 메소드
	public void deleteMember() {
		System.out.println("[회원탈퇴]");
		System.out.print("비밀번호 확인 >> ");
		String mpw = scan.next();
		
		int deleteResult = mdao.deleteMember(loginId, mpw);
		if (deleteResult > 0) {
			System.out.println("탈퇴 되었습니다.");
			loginId = "";
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}
	
}
