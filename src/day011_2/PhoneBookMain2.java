package day011_2;

import java.util.Scanner;

public class PhoneBookMain2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		PhoneBook[] pbList = new PhoneBook[10];
		PhoneBook pb = null; // 여기서 생성자를 호출할 경우 동일한 pb 객체를 계속 쓰게 되는 것.
		boolean run = true;
		int count = 0; // pbList의 인덱스를 바꾸어주기 위한 변수
		
		while(run) {
			System.out.println("\n=============================");
			System.out.println("1.저장 | 2.목록 | 3.검색 | 4.종료");
			System.out.println("=============================");
			System.out.print("메뉴 선택 >> ");
			int menuSel = scan.nextInt();
			
			switch(menuSel) {
			case 1:
				System.out.println("[저장]");
				System.out.print("이름 입력 >> ");
				String name = scan.next();
				System.out.print("전화번호 입력 >> ");
				String tel = scan.next();
				pb = new PhoneBook(); // 1을 선택할 때 마다 pb라는 동일한 이름의 객체가 여러 개 생성되는 것.(주소지가 다름)
				pb.setName(name);
				pb.setTel(tel);
				pbList[count] = pb;
				count++;
				if (count == pbList.length) { // List 인덱스
					count = 0;
				}
				break;
				
			case 2:
				System.out.println("[출력]");
				for(int i = 0; i < pbList.length; i++) {
					if(pbList[i]!=null) { // pbList 배열에 값이 담겨있을 때만 출력되도록
						System.out.print((i+1) + "번 :");
						System.out.print(pbList[i].getName() + ", ");
						System.out.println(pbList[i].getTel());
					}
				}
				break;
				
			case 3:
				System.out.println("[검색]");
				System.out.print("검색할 이름 >> ");
				String searchName = scan.next();
				int index = -1; // 인덱스 번호를 저장할 변수. 인덱스값으로 불가능한 값을 입력.
				for(int i = 0; i < pbList.length; i++) {
					if (pbList[i] != null) {
						if (pbList[i].getName().equals(searchName)) {
							index = i;
							// equals를 통해 pbList[i]의 name필드값을 꺼내 serchName과 동일한지 비교하는 것
							// == 비교연산자는 데이터 주소지를 비교하기 때문에 문자열 비교 불가
						}				
					}
				}
				if (index > -1) {
					System.out.print(pbList[index].getName() + ", ");
					System.out.println(pbList[index].getTel());
				} else {
					System.out.println("찾을 수 없습니다.");
				}
				break;
				
			case 4:
				System.out.println("[종료]");
				run = false;
				break;
			
			}
			
		}
		
	}

}
