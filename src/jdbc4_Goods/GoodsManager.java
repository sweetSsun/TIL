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
		System.out.println("\n===========================================================");
		System.out.println("1.상품등록 | 2.상품목록 | 3.상품수정 | 4.상품삭제 | 5.고객관리 | 0.종료");
		System.out.println("===========================================================");
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
		
		// Goods 테이블의 gtyp 컬럼의 데이터 목록에서 선택
		ArrayList<String> gtypeList = gdao.selectGtypeList();
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
		ArrayList<Goods> goodsList = gdao.selectGoodsList();
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.print("[상품번호] " + goodsList.get(i).getGnum());
			System.out.print(" [상품이름] " + goodsList.get(i).getGname());
			System.out.print(" [상품가격] " + goodsList.get(i).getGprice());
			System.out.print(" [상품수량] " + goodsList.get(i).getGamount());
			System.out.println(" [상품종류] " + goodsList.get(i).getGtype());
		}
	}
	
	
	
	
	
}
