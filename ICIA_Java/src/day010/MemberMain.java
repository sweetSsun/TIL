package day010;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Member[] memberList = new Member[5];
		Member member = null;
		
		for(int i = 0; i < memberList.length; i++ ) {
			member = new Member();
			System.out.print("아이디 입력 >> ");
			String mid = scan.next();
			System.out.print("비밀번호 입력 >> ");
			String mpw = scan.next();
			member.mid = mid;
			member.mpw = mpw;
			memberList[i] = member;
		}
		
		System.out.print("로그인 아이디 >> ");
		String loginId = scan.next();
		System.out.print("로그인 비밀번호 >> ");
		String loginPw = scan.next();
		
		
		for(int i = 0; i < memberList.length; i++) {
			if(loginId.equals(memberList[i].mid) && loginPw.equals(memberList[i].mpw)) {
				System.out.println("로그인 되었습니다.");
			} else {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		
		}
		
	}

}
