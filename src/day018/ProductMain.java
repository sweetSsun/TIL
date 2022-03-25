package day018;

public class ProductMain {

	public static void main(String[] args) {

		ProductManager manager = new ProductManager();
		boolean run = true;
		
		while(run){
			manager.showMenu();
			int menuSel = manager.scan.nextInt();
			
			switch(menuSel) {
			case 0:
				System.out.println("[프로그램 종료]");
				run = false;
				break;
			case 1:
				manager.registerProduct();
				break;
			case 2:
				manager.searchProductName();
				break;
			case 3:
				manager.searchProductCategory();
				break;
			case 4:
				manager.modifyProduct();
				break;
			case 5:
				manager.showProduct();
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}
		
		
		
		
	}

}
