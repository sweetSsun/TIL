package jdbc4_Goods;

public class OrderMain {

	public static void main(String[] args) {

		OrderManager manager = new OrderManager();
		boolean run = true;
		
		while(run) {
			//메뉴 출력 메소드 호출
			manager.showMenu();
			int menuSel = manager.scan.nextInt();
			
			switch(menuSel) {
			case 1:
				if (manager.loginId.equals("")) {
					manager.memberJoin();
				} else {
					manager.myInfo();
				}
				break;
				
			case 2:
				if (manager.loginId.equals("")) {
					manager.memberLogin();
				} else {
					manager.logout();
				}
				break;
				
			case 3:
				if (manager.loginId.equals("")) {
					
				} else {
					manager.goodsOrder();
				}
				break;
				
			case 4:
				if (manager.loginId.equals("")) {
					
				} else {
					manager.orderList();
				}
				break;
				
			case 0:
				run = false;
				break;
			}
		}
	}

}
