package jdbc5_Movies;

import java.util.ArrayList;
import java.util.Scanner;

public class ReservationManager {

	Scanner scan = new Scanner(System.in);
	private ReservationDao rdao = new ReservationDao();
	String loginId = "";
	/*
	 1. 회원기능
	  - 회원가입, 로그인
	 2. 영화 목록 - Movies 테이블 select > 예매율 기준으로 정렬 출력
	 3. 극장 목록 - Theaters 테이블 select
	 4. 예매 기능 - Reservation 테이블 insert
	 5. 예매내역 확인 - Reservation 테이블 select (Join)
	 6. 예매 취소 - Reservation 테이블 delete
	 7. 영화검색 기능 - Movies 테이블 select (like 와일드문자)
	 */
	
	// 메뉴 출력
	public void showMenu() {
		if (loginId.equals("")) {
			System.out.println("\n========================");
			System.out.println("1.회원가입 | 2.로그인 | 0.종료");
			System.out.println("========================");
			System.out.print("메뉴 선택 >> ");
		} else {
			System.out.println("\n[loginId : " + loginId + "]");
			System.out.println("===============================================================");
			System.out.println("1.영화 | 2.극장 | 3.예매 | 4.예매내역 | 5.예매취소 | 6.영화검색 | 0.로그아웃");
			System.out.println("=============================================================");
			System.out.print("메뉴 선택 >> ");
		}
	}
	
	// 회원가입
	public void memberJoin() {
		System.out.println("[회원가입]");
		System.out.print("아이디 >> ");
		String mid = scan.next();
		String checkId = rdao.overlapCheck(mid);
		if (checkId != null) {
			System.out.println("존재하는 아이디입니다.");
		} else {
			System.out.println("가입 가능한 아이디입니다.");
			System.out.print("비밀번호 >> ");
			String mpw = scan.next();
			System.out.print("이름 >> ");
			String mname = scan.next();
			System.out.print("생년월일(YYYY/MM/DD) >> ");
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
			
			int insertResult = rdao.memberJoin(member);
			if (insertResult > 0) {
				System.out.println("회원가입 되었습니다.");
			} else {
				System.out.println("가입에 실패했습니다.");
			}
		}
		
	}
	
	// 로그인
	public void memberLogin() {
		System.out.println("[로그인]");
		System.out.print("아이디 >> ");
		String mid = scan.next();
		System.out.print("비밀번호 >> ");
		String mpw = scan.next();
		loginId = rdao.memberLogin(mid, mpw);
		if (loginId.equals("")) {
			System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
		} else {
			System.out.println("로그인 되었습니다.");
		}
	}
	
	// 로그아웃
	public void memberLogout() {
		loginId = "";
		System.out.println("로그아웃 되었습니다.");
	}
	
	// 영화 목록
	public void moviesList() {
		// 포스터(생략), 영화이름, 예매율(나중), 개봉일
		// 출력 결과 : [인덱스] 영화이름, 개봉일
		System.out.println("[영화]");
		ArrayList<Movies> mvList = rdao.getMoviesList();
		for(int i = 0; i < mvList.size(); i++) {
			// split : 매개변수를 기준으로 분리 (모두 같은 형식이어야 for문으로 돌릴 수 있음)
			String mvopen = mvList.get(i).getMvopen(); // "2022/03/30"
			String[] mvopen_split = mvopen.split("/"); // [0]="2022", [1]="03", [2]="30"
			
			System.out.print("[" + (i+1) + "]");
			System.out.print(mvList.get(i).getMvname());
			System.out.println(" (" + mvopen_split[0] + "년" + mvopen_split[1] + "월" + mvopen_split[2] + "일" + ")");
		}
		// 영화 상세정보
		System.out.print("선택 >> ");
		int menuSel = scan.nextInt();
		int mvNum = menuSel - 1;
		if (mvNum >= 0 && mvNum < mvList.size()) {
//			System.out.println("[영화코드]" + mvList.get(mvNum).getMvcode());
			System.out.println(mvList.get(mvNum).getMvname());
			System.out.print("[감독]" + mvList.get(mvNum).getMvpd());
			System.out.print(" [배우]" + mvList.get(mvNum).getMvactor());
			System.out.print(" [장르]" + mvList.get(mvNum).getMvgenre());
			System.out.print(" [등급]" + mvList.get(mvNum).getMvage() + "세 이상, " + mvList.get(mvNum).getMvtime() + "분");
			System.out.println(" [개봉일]" + mvList.get(mvNum).getMvopen());
		} else {
			System.out.println("잘못 선택하였습니다.");
		}
	}
	
	// 극장 목록
	public void theatersList() {
		// 출력 결과 : 극장이름
		System.out.println("[극장]");
		ArrayList<Theaters> thList = rdao.getTheatersList();
		for(int i = 0; i < thList.size(); i++) {
			System.out.println("[" + i + "]" + thList.get(i).getThname());
		}
		// 극장 상세정보
		System.out.print("선택 >> ");
		int menuSel = scan.nextInt();
		if (menuSel >= 0 && menuSel < thList.size()) {
			System.out.print(thList.get(menuSel).getThname());
			System.out.print(" [주소]" + thList.get(menuSel).getThaddr());
			System.out.println(" [전화번호]" + thList.get(menuSel).getThtel());
		} else {
			System.out.println("잘못 선택하였습니다.");
		}
				
		
	}

	// 영화 검색
	public void searchMovie() {
		System.out.println("[영화검색]");
		System.out.print("검색할 영화 제목 >> ");
		String mvname = scan.next();
		ArrayList<Movies> mvList = rdao.searchMovie(mvname);
		for(int i = 0; i < mvList.size(); i++) {
			System.out.println(mvList.get(i).getMvname());
			System.out.print("[감독]" + mvList.get(i).getMvpd());
			System.out.print(" [배우]" + mvList.get(i).getMvactor());
			System.out.print(" [장르]" + mvList.get(i).getMvgenre());
			System.out.print(" [등급]" + mvList.get(i).getMvage() + "세 이상, " + mvList.get(i).getMvtime() + "분");
			System.out.println(" [개봉일]" + mvList.get(i).getMvopen());
			
		}
	}
	
	
	
	
	
	
}
