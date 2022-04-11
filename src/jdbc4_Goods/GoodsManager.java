package jdbc4_Goods;

import java.util.ArrayList;
import java.util.Scanner;

public class GoodsManager {

	Scanner scan = new Scanner(System.in);
	private GoodsDao gdao = new GoodsDao();

	public void showMenu() {
		/*
		상품 관리 프로그램
		1. 상품등록
		2. 전체 상품목록
		3. 상품수정
		4. 상품삭제
		5. 고객관리
		 */
		System.out.println("\n=====================================================================");
		System.out.println("1.상품등록 | 2.상품목록 | 3.상품수정 | 4.판매관리 | 5.고객관리1 | 6.고객관리2 | 0.종료");
		System.out.println("=====================================================================");
		System.out.print("메뉴선택 >> ");
	}

	public void registGoods() {
		/*
		상품등록 기능
	 	 1. 상품번호 : 등록되는 순서대로 자동 생성
		 2. 이름~종류 : 사용자에게 입력받기 (종류는 있는 것 중에서 선택)
		 3. Goods 테이블에 insert
		 */
		System.out.println("[상품등록]");
		int gnum = gdao.maxGnum() + 1 ; // 상품번호 자동생성
		System.out.println("상품번호 : " + gnum);
		System.out.print("상품이름 >> ");
		String gname = scan.next();
		System.out.print("상품가격 >> ");
		int gprice = scan.nextInt();
		System.out.print("상품수량 >> ");
		int gamount = scan.nextInt();
		
		// Goods 테이블의 gtype 컬럼의 데이터 목록에서 선택
		ArrayList<String> gtypeList = gdao.getGtypeList();
		System.out.println("상품 종류 목록");
		for(int i = 0; i < gtypeList.size(); i++ ) {
			System.out.println("[" + i + "]" + gtypeList.get(i) + " ");
		}
		System.out.print("선택 >> ");
		int typeSel = scan.nextInt();
		String gtype = "";
		
		if(typeSel >= 1 && typeSel < gtypeList.size()) {
			gtype = gtypeList.get(typeSel);
		} else if(typeSel == 0) { // 원하는 종류가 없을 때 직접 입력
			System.out.print("상품종류 >> ");
			gtype = scan.next();
		} else {
			gtype = "기타";
		}
		System.out.println("상품종류 : " + gtype);
				
		// 객체에 담고 DAO에서 INSERT문 수행
		Goods goods = new Goods();
		goods.setGnum(gnum);
		goods.setGname(gname);
		goods.setGprice(gprice);
		goods.setGamount(gamount);
		goods.setGtype(gtype);
		int registResult = gdao.registGoods(goods);
		if(registResult > 0) {
			System.out.println("신규 상품이 등록되었습니다.");
		} else {
			System.out.println("상품등록에 실패했습니다.");
		}
		
	}
	
	public void showGoodsList() {
		/*
		전체 상품목록 출력 기능
		[상품번호] [상품이름] [상품가격] [상품수량] [상품종류]
		 */
		System.out.println("[상품목록]");
		ArrayList<Goods> goodsList = gdao.getGoodsList();
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.print("[상품번호] " + goodsList.get(i).getGnum());
			System.out.print(" [상품이름] " + goodsList.get(i).getGname());
			System.out.print(" [상품가격] " + goodsList.get(i).getGprice());
			System.out.print(" [상품수량] " + goodsList.get(i).getGamount());
			System.out.print(" [상품종류] " + goodsList.get(i).getGtype());
			System.out.println(" [판매상태] " + goodsList.get(i).getGstate());
		}
	}
	
	public void modifyGoods() {
		/*
	 	 상품 수정
	 	 1.수정할 상품 조회
	 	 2.세부 메뉴 출력 >> 1.가격수정 | 2.재고수정
		 */
		System.out.println("[상품수정]");
		ArrayList<Goods> goodsList = gdao.getGoodsList();
		for (int i = 0; i < goodsList.size(); i++) { // 상품목록 출력
			System.out.println("[" + goodsList.get(i).getGnum() + "]" + goodsList.get(i).getGname());
		}
		System.out.print("수정할 상품번호 선택 >> ");
		int gnum = scan.nextInt();
		
		Goods goods = gdao.selectGoods(gnum); //상품 상세정보 조회
		if (goods != null) {
			System.out.println("[" + goods.getGnum() + "]" + goods.getGname());
			System.out.println("가격 : " + goods.getGprice() + ", 수량 : " + goods.getGamount()); 
			System.out.print("1.가격수정 | 2.재고수정 >> ");
			int menuSel = scan.nextInt();
			switch (menuSel) {
			case 1:
				System.out.print("수정할 가격 >> ");
				int modifyPrice = scan.nextInt();
				goods.setGprice(modifyPrice);
				break;
			case 2:
				System.out.print("수정할 수량 >> ");
				int modifyAmount = scan.nextInt();
				goods.setGamount(modifyAmount);
				break;
			default :
				System.out.println("잘못 선택하였습니다.");
				return;
			}
			int modifyResult = gdao.updateGoodsInfo(goods);
			if(modifyResult > 0) {
				System.out.println("수정되었습니다.");
			} else {
				System.out.println("상품 수정에 실패했습니다.");
			}
		} else {
			System.out.println("없는 상품 번호입니다.");
		}
	}

	public void modifyGstate() {
		/*
		 상품상태 변경 판매/중지
		 1. 변경할 상품 조회
		 2. 변경할 상품 선택 > 자동 변경
		 */
		System.out.println("[판매관리]");
		ArrayList<Goods> goodsList = gdao.getGoodsList();
		for (int i = 0; i < goodsList.size(); i++) { // 상품목록 출력
			System.out.print("[" + goodsList.get(i).getGnum() + "]" + goodsList.get(i).getGname()
					+ "  ");
			if (goodsList.get(i).getGstate() == 1) {
				System.out.println("[상태]판매가능");
			} else {
				System.out.println("[상태]판매중지");
			}
		}		
		System.out.print("판매상태 변경할 상품선택 >> ");
		int gnum = scan.nextInt();
		Goods goods = gdao.selectGoods(gnum);
		if (goods != null) {
			int stateResult = gdao.modifyGstate(goods.getGnum(), goods.getGstate());
			if (stateResult > 0) {
				System.out.print(goods.getGname() + "의 판매상태가 ");
				if(goods.getGstate() == 1) {
					System.out.println("판매중지로 변경되었습니다.");
				} else {
					System.out.println("판매가능으로 변경되었습니다.");
				}
			} else {
				System.out.println("상태 변경에 실패했습니다.");
			}
		} else {
			System.out.println("없는 상품 번호입니다.");
		}
	}
	
	/*
	 아이디 : AAA, 비밀번호 : 1111, 이름 : aaa.... 주문수 : 1, 주문총액 : 1300000원
	 */
	public void memberList1() {
		/*
		 고객관리1 (간단한 쿼리문, 복잡한 코드)
		 1. Members 테이블에서 회원정보를 조회 - ArrayList<Memebers> memberList
		 
		 */
		System.out.println("[고객관리1]");
		ArrayList<Members> memberList = gdao.getMembers();
		for (int i = 0; i < memberList.size(); i++) {
			// memberList 조회
			System.out.print("[아이디]" + memberList.get(i).getMid());
			System.out.print(" [비밀번호]" + memberList.get(i).getMpw());
			System.out.print(" [이름]" + memberList.get(i).getMname());
			System.out.print(" [생년월일]" + memberList.get(i).getMbirth());
			System.out.print(" [성별]" + memberList.get(i).getMgender());
			System.out.print(" [전화번호]" + memberList.get(i).getMtel());
			System.out.print(" [주소]" + memberList.get(i).getMaddr());
			
			String mid = memberList.get(i).getMid();
			// 주문정보 조회
			int odcount = gdao.getOrderCount(mid);
			System.out.print(" [주문수]" + odcount);
			int totalPrice = gdao.getTotalPrice(mid);
			System.out.println(" [주문총액]" + totalPrice);
		}
	}
	
	// 최적화를 위해서는 복잡한 쿼리문으로 DB에 한번만 접근하는게 좋음
	
	
	
	
	
	
	
	
	
}
