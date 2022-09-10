package jdbc3_Bank;

public class BankMain {

	public static void main(String[] args) {

		BankManager manager = new BankManager();
		boolean run = true;
		
		while(run) {
			//메뉴 출력 메소드 호출
			manager.showMenu();
			int menuSel = manager.scan.nextInt();
			
			switch(menuSel) {
			case 1: //계좌생성
				manager.createAccount();
				break;
				
			case 2: //입금
				manager.deposit();
				break;
				
			case 3: //출금
				manager.withdraw();
				break;
				
			case 4: //조회
				manager.checkBalance();
				break;
				
			case 5: //이체
				manager.transferAccount();
				break;
				
			case 6: //고객리스트
				manager.clientList();
				break;
				
			case 0: //종료
				run = false;
				break;
			}
		}
	}
}
