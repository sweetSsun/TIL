package jdbc4_Goods;

public class GoodsMain {

	public static void main(String[] args) {

		GoodsManager manager = new GoodsManager();
		boolean run = true;
		
		while(run) {
			// 메뉴출력 메소드 호출
			manager.showMenu();
			int menuSel = manager.scan.nextInt();
			
			switch(menuSel) {
			case 1: //상품등록
				manager.registGoods();
				break;
			
			case 2: //상품목록
				manager.showGoodsList();
				break;
				
			case 3: //상품수정
				break;
				
			case 4: //상품삭제
				break;
				
			case 5: //고객관리
				break;
				
			case 0: //종료
				run = false;
				break;
			}
			
		}
		
		
		
	}

}
