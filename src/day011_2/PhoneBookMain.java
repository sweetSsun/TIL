package day011_2;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// pb 객체 :: 연락처 (이름, 전화번호)
		PhoneBook pb = null;
		
		PhoneBook[] pbList = new PhoneBook[3];
		
		// 전화번호부 생성 프로그램 :: 연락처들의 모임
		
		// 0번 연락처 생성
		System.out.print("이름 >> ");
		String name = scan.next();
		System.out.print("전화번호 >> ");
		String tel = scan.next();
		
		pb = new PhoneBook();
		pb.setName(name);
		pb.setTel(tel);
		// 연락처(pb)를 전화번호부(pbList)에 저장
		pbList[0] = pb;
		
		// 1번 연락처 생성
		System.out.print("이름 >> ");
		name = scan.next();
		System.out.print("전화번호 >> ");
		tel = scan.next();
		pb = new PhoneBook();
		pb.setName(name);
		pb.setTel(tel);
		pbList[1] = pb;
		
		// 2번 연락처 생성
		System.out.print("이름 >> ");
		name = scan.next();
		System.out.print("전화번호 >> ");
		tel = scan.next();
		pb = new PhoneBook();
		pb.setName(name);
		pb.setTel(tel);
		pbList[2] = pb;
		
		// pbList >> | pb | pb | pb |
		
		// 1. 전체목록 출력
		for(int i = 0; i < pbList.length; i++) {
//			System.out.println(pbList[i]); //toString이 있기 때문에 가능한 코드
			System.out.println("이름 : " + pbList[i].getName());
			System.out.println("번호 : " + pbList[i].getTel());
		}
	}

}
