package jdbc4_Goods;

import java.util.Scanner;

public class OrderManager {

	Scanner scan = new Scanner(System.in);
	private OrderDao oddao = new OrderDao();
	String loginId = ""; //로그인 된 아이디를 저장할 변수
	/*
	 * 1.회원가입
	 * 2.로그인
	 * 3.내정보 확인
	 * 
	 * 4.상품목록 출력
	 * 5.주문
	 * 6.주문내역 확인
	 * 7.주문취소
	 */
	//메뉴 출력 기능
	public void showMenu() {
		if (loginId.equals("")) {
			System.out.println("\n=========================");
			System.out.println("1.회원가입 | 2.로그인 | 0.종료");
			System.out.println("=========================");
			System.out.print("메뉴 선택 >> ");
		} else {
			System.out.println("\n["+loginId+" 회원님]");
			System.out.println("=========================");
			System.out.println("1.내정보 | 2.로그아웃 | 0.종료");
			System.out.println("=========================");
			System.out.print("메뉴 선택 >> ");
		}
	}
	
	//회원가입 기능
	public void memberJoin() {
		System.out.println("[회원가입]");
		System.out.print("아이디 >> ");
		String mid = scan.next();
		System.out.print("비밀번호 >> ");
		String mpw = scan.next();
		System.out.print("이름 >> ");
		String mname = scan.next();
		System.out.print("생년월일(연/월/일) >> ");
		String mbirth = scan.next();
		System.out.print("성별(남|여) >> ");
		String mgender = scan.next();
		System.out.print("전화번호 >> ");
		String mtel = scan.next();
		System.out.print("주소 >> ");
		String maddr = scan.next();
		
		Members member = new Members();
		member.setMid(mid);
		member.setMpw(mpw);
		member.setMname(mname);
		member.setMbirth(mbirth);
		member.setMgender(mgender);
		member.setMtel(mtel);
		member.setMaddr(maddr);
		int insertResult = oddao.memberJoin(member);
		if (insertResult > 0) {
			System.out.println("회원가입 되었습니다.");
		} else {
			System.out.println("가입에 실패하였습니다.");
		}
	}
	
	//로그인 기능
	public void memberLogin() {
		System.out.println("[로그인]");
		System.out.print("아이디 >> ");
		String mid = scan.next();
		System.out.print("비밀번호 >> ");
		String mpw = scan.next();
		loginId = oddao.memberLogin(mid, mpw);
		if (loginId.equals("")) {
			System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
		} else {
			System.out.println("로그인 되었습니다.");
		}
	}
	
	//내정보 출력 기능
	public void myInfo() {
		System.out.println("[내정보]");
		Members member = new Members();
		member = oddao.getMyInfo(loginId);
		if(member != null) {
			System.out.print("[아이디] " + member.getMid());
			System.out.print("  [이름] " + member.getMname());
			System.out.print("  [생년월일] " + member.getMbirth());
			System.out.print("  [성별] " + member.getMgender());
			System.out.print("  [전화번호] " + member.getMtel());
			System.out.println("  [주소] " + member.getMaddr());
		}
	}
	
	//로그아웃 기능
	public void logout() {
		System.out.println("[로그아웃]");
		loginId = "";
		System.out.println("로그아웃 되었습니다.");
	}

	
	
	
	
	
	
	
	
}
