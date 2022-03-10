package day005;

import java.util.Scanner;

public class Practice_login {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String id = "sun";
		String pass = "1234";
		System.out.println(id + " " + pass);
		
		boolean run = true;
		
		while(run) {
			System.out.print("id를 입력하시오 >>");
			String inputId = scan.next();
			System.out.print("pass를 입력하시오 >>");
			String inputPass = scan.next();
			if (id.equals(inputId) && pass.equals(inputPass)) {
				System.out.println("로그인 되었습니다.");
				run = false;
			} else if (id.equals(inputId)) {
				System.out.println("비밀번호가 틀렸습니다.");
				
			} else {
				System.out.println("아이디가 틀렸습니다.");
			}
		}
		
		
		
		
		
	}

}
