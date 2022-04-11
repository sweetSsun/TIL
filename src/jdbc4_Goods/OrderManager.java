package jdbc4_Goods;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderManager {

	Scanner scan = new Scanner(System.in);
	private OrderDao oddao = new OrderDao();
	private GoodsDao gdao = new GoodsDao();
	String loginId = ""; //로그인 된 아이디를 저장할 변수
	/*
	 * 1.회원가입
	 * 2.로그인
	 * 3.내정보 확인
	 * 
	 * 4.상품목록 출력
	 * 5.주문
	 * 6.주문내역 확인
	 * 7.주문취소
	 */
	//메뉴 출력 기능
	public void showMenu() {
		if (loginId.equals("")) {
			System.out.println("\n=========================");
			System.out.println("1.회원가입 | 2.로그인 | 0.종료");
			System.out.println("=========================");
			System.out.print("메뉴 선택 >> ");
		} else {
			System.out.println("\n["+loginId+" 회원님]");
			System.out.println("===============================================");
			System.out.println("1.내정보 | 2.로그아웃 | 3.상품주문 | 4.주문내역 | 0.종료");
			System.out.println("===============================================");
			System.out.print("메뉴 선택 >> ");
		}
	}
	
	//회원가입 기능
	public void memberJoin() {
		System.out.println("[회원가입]");
		System.out.print("아이디 >> ");
		String mid = scan.next();
		System.out.print("비밀번호 >> ");
		String mpw = scan.next();
		System.out.print("이름 >> ");
		String mname = scan.next();
		System.out.print("생년월일(연/월/일) >> ");
		String mbirth = scan.next();
		System.out.print("성별(남|여) >> ");
		String mgender = scan.next();
		System.out.print("전화번호 >> ");
		String mtel = scan.next();
		System.out.print("주소 >> ");
		String maddr = scan.next();
		
		Members member = new Members();
		member.setMid(mid);
		member.setMpw(mpw);
		member.setMname(mname);
		member.setMbirth(mbirth);
		member.setMgender(mgender);
		member.setMtel(mtel);
		member.setMaddr(maddr);
		int insertResult = oddao.memberJoin(member);
		if (insertResult > 0) {
			System.out.println("회원가입 되었습니다.");
		} else {
			System.out.println("가입에 실패하였습니다.");
		}
	}
	
	//로그인 기능
	public void memberLogin() {
		System.out.println("[로그인]");
		System.out.print("아이디 >> ");
		String mid = scan.next();
		System.out.print("비밀번호 >> ");
		String mpw = scan.next();
		loginId = oddao.memberLogin(mid, mpw);
		if (loginId.equals("")) {
			System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
		} else {
			System.out.println("로그인 되었습니다.");
		}
	}
	
	//내정보 출력 기능
	public void myInfo() {
		System.out.println("[내정보]");
		Members member = new Members();
		member = oddao.getMyInfo(loginId);
		if(member != null) {
			System.out.print("[아이디] " + member.getMid());
			System.out.print("  [이름] " + member.getMname());
			System.out.print("  [생년월일] " + member.getMbirth());
			System.out.print("  [성별] " + member.getMgender());
			System.out.print("  [전화번호] " + member.getMtel());
			System.out.println("  [주소] " + member.getMaddr());
		}
	}
	
	//로그아웃 기능
	public void logout() {
		System.out.println("[로그아웃]");
		loginId = "";
		System.out.println("로그아웃 되었습니다.");
	}
	
	//상품주문 기능
	public void goodsOrder() {
		/*
		      현재 판매중인 상품목록 출력 (상품번호, 상품이름)
		 user >> 상품 선택 --ODGNUM
		      선택한 상품의 상세정보 출력 (상품이름, 상품가격, 재고)
		      주문하시겠습니까? (1.예 | 2.아니오) >>
		 user >> (1) > 주문수량입력 -- ODACCOUNT
		      주문처리
		      1. ORDERINFO 테이블에 INSERT (주문코드, 상품번호, 주문수량, 아이디, 주문일)
		         주문코드 : OD001부터 자동생성
		      2. GOODS 테이블에 UPDATE (상품수량)
		         주문한 상품의 재고를 수정
		        
		 */
		System.out.println("[상품주문]");
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		goodsList = oddao.saleGoodsList(); // 판매중인 상품 목록 조회
		System.out.println("상품 목록");
		
		if(goodsList.size() < 0) { // 상품목록이 없을 때는 주문 코드가 실행되지 않고 끝내기
			System.out.println("판매 중인 상품이 없습니다.");
			return;
		}
		
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.println("[" + goodsList.get(i).getGnum() + "]" + goodsList.get(i).getGname());
		}
		System.out.print("상품번호 선택 >> ");
		int selGnum = scan.nextInt();
		for (int i = 0; i < goodsList.size(); i++) {
			if (goodsList.get(i).getGnum() == selGnum) { // 출력된 상품번호 중에서 선택해야 진행
				Goods goodInfo = gdao.selectGoods(selGnum);
				System.out.print("[" + goodInfo.getGnum() + "]" + goodInfo.getGname() + " ");
				System.out.print(goodInfo.getGprice() + "원");
				System.out.println(" [현재 재고" + goodInfo.getGamount() + "개]");
				System.out.print("주문하시겠습니까? (1.예 | 2.아니오) >> ");
				int orderConfirm = scan.nextInt();
				if (orderConfirm == 1) { // 주문
					System.out.print("주문수량 >> ");
					int orderAmount = scan.nextInt();
					if (goodInfo.getGamount() >= orderAmount) { // 주문수량과 재고 비교
						// 주문코드 자동생성
						String maxOdcode = oddao.getMaxOdnum();
						maxOdcode = maxOdcode.substring(2);
						String odcode = "OD";
						int codeNum = Integer.parseInt(maxOdcode) + 1;
						if (codeNum < 10) {
							odcode = odcode + "00" + codeNum;
						} else if (codeNum < 100) {
							odcode = odcode + "0" + codeNum;
						} else {
							odcode = odcode + codeNum;
						}
						// ORDERINFO 테이블에 주문정보 저장
						OrderInfo odInfo = new OrderInfo();
						odInfo.setOdcode(odcode);
						odInfo.setOdgnum(selGnum);
						odInfo.setOdamount(orderAmount);
						odInfo.setOdmid(loginId);
						int insertResult = oddao.insertOrderInfo(odInfo);
						if (insertResult > 0) {
							// GOODS 테이블에 상품수량 수정
							oddao.updateGoodsAmount(odInfo);
							System.out.println(goodInfo.getGname() + ", " + orderAmount + "개 주문되었습니다.");
							System.out.println("총 가격은 " + (goodInfo.getGprice() * orderAmount) + "원 입니다.");
						} else {
							System.out.println("상품 주문에 실패하였습니다.");
						}
					} else {
						System.out.println("재고가 부족합니다.");
					}
				} else { // 주문취소
					System.out.println("주문이 취소되었습니다.");
				}
			}
		}
	}
	
	//상품주문 내역
	public void orderList() {
		System.out.println("[주문내역]");
		ArrayList<MyOrder> myOdList = oddao.getMyOrderList(loginId);
		if(myOdList.size() <= 0) {
			System.out.println("주문내역이 없습니다.");
		} else {
			for (int i = 0; i < myOdList.size(); i++) {
				System.out.print("[" + i + "]");
				System.out.print(" [주문코드]" + myOdList.get(i).getOdcode());
				System.out.print(" [상품명]" + myOdList.get(i).getGname());
				System.out.print(" [상품가격]" + myOdList.get(i).getGprice());
				System.out.print(" [주문수량]" + myOdList.get(i).getOdamount());
				System.out.println(" [주문일]" + myOdList.get(i).getOddate());
			}
			// 주문취소
			System.out.print("선택 >> ");
			int menuSel = scan.nextInt();
			
			System.out.println("선택한 주문코드 : " + myOdList.get(menuSel).getOdcode());
		}
	}
	
	
	

	
	
	
	
	
	
	
	
}
