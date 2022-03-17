package day012;

public class MemberMain {

	public static void main(String[] args) {

		MemberManager manager = new MemberManager();
		boolean run = true;
		String loginId = ""; // 로그인 처리가 되었음을 확인할 변수
		

		while (run) {
			manager.showMenu(loginId);

			int menuSel = manager.userIntInput();

			switch (menuSel) {
			case 0:
				run = false;
				System.out.println("프로그램 종료");
				break;
			case 1:
				if (loginId.equals("")) { // 로그인 안된 상태
					// 회원가입 기능 호출
					manager.memberJoin(loginId);

				} else if (loginId.equals("admin")) { // 관리자모드로 모든 회원의 정보 출력
					// 전체 회원정보 출력 기능 호출
					manager.memberList(loginId);
				
				} else { // 로그인 된 해당 회원의 정보 출력
					// 회원정보 출력 기능 호출
					manager.myInfo(loginId);
					
				}
				break;

			case 2:
				if(loginId.equals("")) {
					// 로그인 기능 호출
					loginId = manager.login(loginId);
					
				} else {
					// 로그아웃 기능 호출
					loginId = manager.logout(loginId);
				
				}
				break;
				
			case 3:				
				if(loginId.equals("")) {
					System.out.println("로그인되지 않았습니다.");
				} else {
					// 정보수정 기능 호출
					manager.changeInfo();
					
				}
				break;
			}
		}

	}

}
