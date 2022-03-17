package day011_2;

import java.util.Scanner;

public class Practice_PhoneBookMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Practice_PhoneBook pb = null;
		Practice_PhoneBook[] pbList = new Practice_PhoneBook[3];
		boolean run = true;
		int count = 0;
		
		
		while(run) {
			System.out.println("=============================");
			System.out.println("1.저장 | 2.목록 | 3.검색 | 4.종료");
			System.out.println("=============================");
			System.out.print("메뉴선택 >> ");
			int menuSel = scan.nextInt();
			
			switch(menuSel) {
			case 1:
				if (count < pbList.length) {
					System.out.print("이름 입력 >> ");
					String name = scan.next();
					System.out.print("전화번호 입력 >> ");
					String tel = scan.next();
					pb = new Practice_PhoneBook();
					pb.setName(name);
					pb.setTel(tel);
					pbList[count] = pb;
					count++;
				} else {
					System.out.println("저장 목록을 초과하였습니다.");
				}
				break;
				
			case 2:
				for (int i = 0; i < pbList.length; i++) {
					if (pbList[i]!=null) {
						System.out.println(pbList[i].getName() + ", " + pbList[i].getTel());
					}
				}
				break;
				
			case 3:
				int index = -1;
				System.out.print("검색할 이름 >> ");
				String searchName = scan.next();
				for(int i = 0; i < pbList.length; i++) {
					if(pbList[i]!=null) {
						if(pbList[i].getName().equals(searchName)) {
							index = i;
						}
					}
				}
				if (index > -1) { // 전화번호 수정 기능 입력하기
					System.out.println(pbList[index].getName());
					System.out.println(pbList[index].getTel());
					System.out.print("수정하시겠습니까? >> 1.예 2.아니오");
					int modify = scan.nextInt();
					if(modify == 1) {
						System.out.print("수정할 전화번호를 입력 >> ");
						String tel = scan.next();
						pbList[index].setTel(tel);
					}
				} else {
					System.out.println("찾을 수 없습니다.");
				}
				
				break;
				
			case 4:
				System.out.println("프로그램 종료");
				run = false;
				break;
			}
			
		}
		
		
		
	}

}
