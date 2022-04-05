package jdbc2_Member;

public class MemberMain {

	public static void main(String[] args) {

		MemberManager manager = new MemberManager();
		boolean run = true;
		
		while(run) {
			// 메뉴출력 메소드 호출
			manager.showMenu();
			int menuSel = manager.scan.nextInt();
			
			switch(menuSel) {
			case 1:
				manager.selectMenuOne();
				break;
				
			case 2:
				manager.selectMenuTwo();
				break;
				
			case 3:
				manager.updateMemberInfo();
				break;
				
			case 4:
				manager.deleteMember();
				break;
			
			case 0:
				System.out.println("[종료]");
				run = false;
				break;
			}
			
		}
		
	}

}
