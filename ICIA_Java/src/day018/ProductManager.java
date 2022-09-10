package day018;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {

	Scanner scan = new Scanner(System.in);
	ArrayList<ProductInfo> productsList = new ArrayList<ProductInfo>(10);
	int count = 1; // 상품번호를 저장할 변수
	
	
	// 메뉴출력
	public void showMenu() {
		System.out.println("\n=========================================================================");
		System.out.println("1.상품 등록 | 2.상품명 검색 | 3. 상품종류 검색 | 4.상품 정보수정 | 5.전상품 조회 | 0.종료");
		System.out.println("=========================================================================");
		System.out.print("메뉴 선택 >> ");
	}
	
	
	// 상품등록
	public void registerProduct() {
		System.out.println("[상품 등록]");
		ProductInfo product = new ProductInfo();
				
		product.setProductNum(count); // 상품번호 저장
		count++;
		System.out.print("상품명 입력 >> ");
		String productname = scan.next();
		product.setProductName(productname); // 상품명 저장
		System.out.print("상품 가격 입력 >> ");
		int productprice = scan.nextInt();
		product.setProductPrice(productprice); // 상품가격 저장
		System.out.print("상품 수량 입력 >> ");
		int productStock = scan.nextInt();
		product.setProductStock(productStock); // 상품수량 저장
		System.out.print("상품 종류 입력 >> ");
		String productCategory = scan.next();
		product.setProductCategory(productCategory); // 상품종류 저장
		
		productsList.add(product);
		System.out.println("상품이 등록되었습니다.");
	}
	
	
	// 상품명 검색
	public void searchProductName() {
		int index = -1; // 검색하고자 하는 상품의 인덱스를 담을 변수
		System.out.println("[상품명 검색]");
		System.out.print("검색할 상품명 >> ");
		String productName = scan.next();
		for (int i = 0; i < productsList.size(); i++) {
			if (productsList.get(i).getProductName().equals(productName)) {
				index = i;
			}
		}
		if (index > -1) {
			System.out.println("[상품명 : " +  productsList.get(index).getProductName()
					+ ", 상품가격 : " + productsList.get(index).getProductPrice()
					+ ", 상품수량 : " + productsList.get(index).getProductStock()
					+ ", 상품종류 : " + productsList.get(index).getProductCategory() + "]");
		} else {
			System.out.println("상품을 찾을 수 없습니다.");
		}
	}
	
	
	// 상품종류 검색
	public void searchProductCategory() {
		int index = -1; // 검색하고자 하는 상품의 인덱스를 담을 변수
		System.out.println("[상품종류 검색]");
		System.out.print("검색할 상품종류 >> ");
		String productCategory = scan.next();
		for (int i = 0; i < productsList.size(); i++) {
			if (productsList.get(i).getProductCategory().equals(productCategory)) {
				System.out.println("[상품명 : " + productsList.get(i).getProductName()
						+ ", 상품가격 : " 	+productsList.get(i).getProductPrice() + "]");
				index = i; // if문이 실행되었다면 index값은 변경됨
			}
		}
		if(index == -1) {
			System.out.println("상품을 찾을 수 없습니다.");
		}
	}
	
	
	// 상품정보 수정
	public void modifyProduct() {
		boolean check = true; // 수정하고자 하는 상품명을 찾았는지 확인할 변수
		System.out.println("[상품정보 수정]");
		System.out.print("수정할 상품 이름 >> ");
		String productName = scan.next();
		for (int i = 0; i < productsList.size(); i++) {
			if (productsList.get(i).getProductName().equals(productName)) {
				System.out.print("수정할 목록 | 1.상품가격 | 2.상품수량 | >> ");
				int modifySel = scan.nextInt();
				switch(modifySel) {
				case 1:
					System.out.print("수정할 가격 입력 >> ");
					int modifyPrice = scan.nextInt();
					if (modifyPrice >= 0) {
						productsList.get(i).setProductPrice(modifyPrice);
					} else {
						productsList.get(i).setProductPrice(0);
					}
					System.out.println("수정되었습니다.");
					break;
				case 2:
					System.out.print("수정할 수량 입력 >> ");
					int modifyStock = scan.nextInt();
					if (modifyStock >= 0) {
						productsList.get(i).setProductStock(modifyStock);
					} else {
						productsList.get(i).setProductStock(0);
					}
					System.out.println("수정되었습니다.");
					break;
				default:
					System.out.println("잘못 입력하였습니다.");
				}
				check = false; // if문이 한 번이라도 실행되었다면 수정완료
			}
		}
		if (check) {
			System.out.println("상품을 찾을 수 없습니다.");
		}
	}
	
	
	// 전상품 조회
	public void showProduct() {
		System.out.println("[전상품 조회]");
		
		for (int i = 0; i < productsList.size(); i++) {
			System.out.println(productsList.get(i).toString());
		}
	}

	
}
