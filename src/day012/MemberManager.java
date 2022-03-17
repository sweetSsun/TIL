package day012;

import java.util.Scanner;

public class MemberManager {

	Scanner scan = new Scanner(System.in);
	
	Member[] mbList = new Member[5]; // 객체를 담을 배열
	int count = 0; // mbList 배열의 인덱스 값을 변경할 변수
	int index = -1; // 로그인 처리된 아이디의 인덱스 값을 저장할 변수

	// 숫자 입력 기능
	public int userIntInput() {
		return scan.nextInt();
	}
	// 문자 입력 기능
	public String userStringInput() {
		return scan.next();
	}
	
	// 메뉴 출력 기능
	public void showMenu(String loginId) {
		if (loginId.equals("")) { // 로그인이 되지 않았을 경우의 메뉴 출력
			System.out.println("\n=========================");
			System.out.println("1.회원가입 | 2.로그인 | 0.종료");
			System.out.println("=========================");
		} else if (loginId.equals("admin")) { // 관리자 모드에서의 메뉴 출력
			System.out.println("\n=========================");
			System.out.println("1.전체회원 | 2.로그아웃 | 0.종료");
			System.out.println("==========================");
		} else { // 로그인 된 상태에서의 메뉴 출력
			System.out.println("\n==================================");
			System.out.println("1.내 정보 | 2.로그아웃 | 3.정보수정 | 0.종료");
			System.out.println("====================================");
		}
		System.out.print("메뉴 선택 >> ");
	}
	
	// 회원가입 기능
	public void memberJoin(String loginId) {		
		// 아이디~이메일 회원정보를 입력 받고
		// mbList 배열에 저장
		Member mb = new Member();
		if (count < mbList.length) {
			System.out.println("[회원가입]");
			
			boolean overlap = true; // 중복 아이디 확인을 위한 변수
			while (overlap) {
				System.out.print("아이디 >> ");
				String id = userStringInput();
				for (int i = 0; i < mbList.length; i++) {
					if (mbList[i] != null) {
						if (id.equals(mbList[i].getMid())) {
							System.out.println("중복된 아이디입니다.");
							break;
						}
					} else {
						System.out.println("가입 가능한 아이디입니다.");
						overlap = false;
						mb.setMid(id);
						break;
					}
				}
			}
			
			boolean check = true; // 비밀번호 재확인을 위한 변수
			while (check) {
				System.out.print("비밀번호 >> ");
				String pw = userStringInput();
				// 가입시 비밀번호 재확인
				System.out.print("비밀번호 재확인 >> ");
				String rpw = userStringInput();
				if (pw.equals(rpw)) {
					mb.setMpw(pw);
					System.out.print("이름 >> ");
					String name = userStringInput();
					mb.setMname(name);
					System.out.print("이메일 >> ");
					String mail = userStringInput();
					mb.setMemail(mail);
					mbList[count] = mb;
					System.out.println("회원가입 되었습니다.");
					count++;
					check = false;
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
					System.out.println("비밀번호를 다시 입력해주십시오.");
				}
			}
		} else {
			System.out.println("더이상 회원가입이 불가능합니다.");
		}
	}
	
	// 관리자모드 전체 회원정보 출력 기능
	public void memberList(String loginId) {
		for (int i = 0; i < mbList.length; i++) {
			if (mbList[i] != null) {
				System.out.println("\n[" + (i + 1) + "번 회원의 정보]");
				mbList[i].showInfo();
			}
		}
	}
	
	// 회원정보 출력 기능
	public void myInfo(String loginId) {
		System.out.println("[" + loginId + "님의 정보]");
//		loginId로 출력
//		for (int i = 0; i < mbList.length; i++ ) {
//			if(mbList[i] != null) {
//				if(mbList[i].getMid().equals(loginId)) {
//					System.out.println("이름 : " + mbList[i].getMname());
//					System.out.println("이메일 : " + mbList[i].getMemail());
//					
//				}
//			}
//		}			

//		index로 출력(DB를 사용하게 될 경우 로그인 된 해당 객체를 받아오게 되기 때문에 index에 더 가까움)
		System.out.println("이름 : " + mbList[index].getMname());
		System.out.println("이메일 : " + mbList[index].getMemail());
	}
	
	// 로그인 기능
	public String login(String loginId) {
		// 아이디, 비밀번호를 입력받고 memberList 확인
		// 일치하는 회원정보가 있으면 '로그인 되었습니다.'
		// 없으면 '아이디 또는 비밀번호가 일치하지 않습니다.'
		System.out.println("[로그인]");
		System.out.print("아이디 >> ");
		String id = userStringInput();
		System.out.print("비밀번호 >> ");
		String pw = userStringInput();
		
		if(id.equals("admin") && pw.equals("admin")) { // 관리자 로그인
			System.out.println("관리자로 로그인 되었습니다.");
			loginId = "admin";
		} else { // 일반회원 로그인
			for (int i = 0; i < mbList.length; i++) {
				if (mbList[i] != null) {
					if (id.equals(mbList[i].getMid()) && pw.equals(mbList[i].getMpw())) {
						index = i;
					}
				}
			}
			if (index > -1) { // 인덱스값이 변경되었다는건 일치하는 회원정보를 찾았다는 것
				System.out.println("로그인 되었습니다.");
				loginId = mbList[index].getMid();
			} else { // 인덱스값이 -1이라면 일치하는 회원정보를 찾지 못한 것
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		}
		return loginId;
	}
	
	// 로그아웃 기능
	public String logout(String loginId) {
		loginId = ""; // 로그아웃된 상태로 변경
		index = -1; // 로그아웃과 동시에 index값도 다시 -1로 초기화
		System.out.println("로그아웃 되었습니다.");
		return loginId;
	}
	
	// 정보수정 기능
	public void changeInfo() {
		System.out.println("[정보수정]");
		boolean check = true; // 재확인한 비밀번호와 일치하는지 확인하기 위한 변수
		while(check) {
			System.out.print("변경할 비밀번호 >> ");
			String newPw = userStringInput();
			System.out.print("변경할 비밀번호 재확인 >> ");
			String rNewPw = userStringInput();
			if (newPw.equals(rNewPw)) {
				mbList[index].setMpw(newPw);
				System.out.print("변경할 이메일 >> ");
				String newEmail = userStringInput();
				mbList[index].setMemail(newEmail);
				System.out.println("정보가 수정되었습니다.");
				check = false;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
	}
}
