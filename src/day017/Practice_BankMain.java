package day017;

public class Practice_BankMain {

	public static void main(String[] args) {


		Practice_BankManager manager = new Practice_BankManager();
		boolean run = true;
		
		while(run) {
			int menuSel = manager.showMenu();
			
			switch(menuSel) {
			case 0:
				System.out.println("[프로그램 종료]");
				run = false;
				break;
			case 1:
				manager.createAccount();				
				break;
			case 2:
				manager.deposit();
				break;
			case 3:
				manager.withdraw();
				break;
			case 4:
				manager.checkBalance();
				break;
			case 5:
				manager.transferAccount();
				break;
			case 6:
				manager.showClientList();
				break;
			default:
				System.out.println("잘못 선택하셨습니다.");
				break;
			}
			
		}
		
		
		
		
		
		
	}

}
