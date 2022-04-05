package jdbc2_Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {

	Scanner scan = new Scanner(System.in);
	
	private MemberDao mdao = new MemberDao();
	private String loginId = ""; // 로그인 처리된 아이디
	private ArrayList<Member> mbList;
	Member mb;
	
	
    // 메뉴출력 메소드
	public void showMenu() {
		
		if(loginId.equals("")) {
			System.out.println("\n==========================");
			System.out.println("1.회원가입 | 2.로그인 | 0.종료");
			System.out.println("==========================");
			System.out.print("메뉴 선택 >> ");
		} else {
			System.out.println("\n==========================");
			System.out.println("1.내 정보 | 2.로그아웃 | 0.종료");
			System.out.println("==========================");
			System.out.print("메뉴 선택 >> ");
		}
	}
	
	
	public void selectMenuOne() {
		if(loginId.equals("")) { // 로그인 안된 상태
			memberJoin(); // 회원가입 메소드 호출
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
	
	// 내정보 메소드
	public void myInfo() {
		System.out.println("[내정보]");
		int index = -1;
		for ( int i = 0; i < mbList.size(); i++ ) {
			if ( mbList.get(i).getMid().equals(loginId) ) {
				index = i;
			}
		}
		System.out.println("아이디 : " + mbList.get(index).getMid()
				+ ", 이름 : " + mbList.get(index).getMname()
				+ ", 이메일 : " + mbList.get(index).getMemail());
	}

	
	// 로그인 메소드
	public void memberLogin() {
		System.out.println("[로그인]");
		System.out.print("아이디 >> ");
		String loginId = scan.next();
		System.out.print("비밀번호 >> ");
		String loginPw = scan.next();
		
		mbList = mdao.memberLogin(loginId, loginPw);
//		int index = -1;
//		for (int i = 0; i < mbList.size(); i++) {
//			index = i;
//		}
		
		if (mbList.size() > 0) {			
			System.out.println("로그인 되었습니다.");
			this.loginId = loginId;
//			System.out.println(mbList.get(index).getMid() + "로 로그인 되었습니다.");
//			this.loginId = mbList.get(index).getMid();
		} else {
			System.out.println("아이디나 비밀번호를 찾을 수 없습니다.");
		}
	}

	// 로그아웃 메소드
	public void memberLogout() {		
		this.loginId = "";
		System.out.println("로그아웃 되었습니다.");
	}
	
	
	
	
	
	
	
}
