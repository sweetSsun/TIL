package day013;

public class BankMain {

	public static void main(String[] args) {

		// BankInfo, BankManager, BankMain
		BankManager manager = new BankManager();
		boolean run = true;
		
		while(run) {
			// 메뉴 출력 기능 메소드 호출
			manager.showMenu();
			int menuSel = manager.scan.nextInt();
			
			switch(menuSel) {
			case 0:
				run = false;
				System.out.println("[프로그램 종료]");
				break;
				
			case 1:
				// 계좌 생성 기능 메소드 호출
				manager.createAccount();
				break;
				
			case 2:
				// 입금 기능 메소드 호출
				manager.depositAccount();
				break;
				
			case 3:
				// 출금 기능 메소드 호출
				manager.withdrowAccount();
				break;
				
			case 4:
				// 잔액조회 기능 메소드 호출
				manager.balanceCheck();
				break;
				
			case 5:
				// 이체 기능 메소드 호출
				manager.transferAccount();
				break;
				
			case 6:
				// 고객리스트 확인 기능 메소드 호출
				manager.checkClientList();
				break;
				
			
			}
			
			
		}
		
		
		
	}

}
