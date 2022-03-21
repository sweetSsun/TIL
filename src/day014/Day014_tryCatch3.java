package day014;

import java.util.Scanner;

public class Day014_tryCatch3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.입력 | 2.출력 | 3.종료");
			System.out.print("메뉴 선택 >> ");
			String menu = scan.next();
			int menuSel;
			
			try {
				menuSel = Integer.parseInt(menu);
			} catch (Exception e) {
				System.out.println("숫자를 입력해야합니다.");
				continue;
			}
			
			System.out.println("선택한 메뉴 : " + menuSel);
		}
	}

}
