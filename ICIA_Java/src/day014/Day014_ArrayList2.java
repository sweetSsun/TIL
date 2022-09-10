package day014;

import java.util.ArrayList;
import java.util.Scanner;

import day012.Member;

public class Day014_ArrayList2 {

	public static void main(String[] args) {

		// String 타입의 ArrayList 선언
		// "월요일"~"금요일" 저장
		
		ArrayList<String> dayList = new ArrayList<String>(5);
		dayList.add("월요일");
		dayList.add("화요일");
		dayList.add("수요일");
		dayList.add("목요일");
		dayList.add("금요일");
		
		// dayList 모든 값을 출력, for문으로 구성
		System.out.println("===for문===");
		for ( int i = 0; i < dayList.size(); i++ ) {
			System.out.println( dayList.get(i) );
		}
		
		System.out.println("===일반 출력===");
		System.out.println(dayList);
		
		
		
		System.out.println();
		ArrayList<Member> memberList = new ArrayList<Member>();
		Member member = null;
		
		member= new Member("AAAA", "1111", "AA", "AA@AA");
		memberList.add(member);
		
		member = new Member();
		member.setMid("BBBB");
		member.setMpw("1111");
		member.setMname("BB");
		member.setMemail("BB@BB");
		memberList.add(member);
		
		for ( int i = 0; i < memberList.size(); i++ ) {
			System.out.println( memberList.get(i).getMid() );
			System.out.println( memberList.get(i).getMpw() );
			System.out.println( memberList.get(i).getMname() );
			System.out.println( memberList.get(i).getMemail() );
		}
		
		
		System.out.println( memberList.get(0).getMid() );
		System.out.println( memberList.get(0).getMpw() );
		
		System.out.println( memberList.get(1).getMid());
		System.out.println( memberList.get(1).getMpw() );
		
		System.out.println("로그인");
		Scanner scan = new Scanner(System.in);
		System.out.print("로그인 할 아이디 >> ");
		String userInputId = scan.next();
		System.out.print("로그인 할 비밀번호 >> ");
		String userInputPw = scan.next();
		
		int index = -1;
		for ( int i = 0; i < memberList.size(); i++ ) {
			if ( memberList.get(i).getMid().equals(userInputId)
					&& memberList.get(i).getMpw().equals(userInputPw)) {
				index = i;
			}
		}
		if ( index > -1 ) {
			System.out.println("로그인 되었습니다.");
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
			
		
		
		
		
		
		
	}

}
