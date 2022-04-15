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
			System.out.println("==============================================================");
			System.out.println("1.영화 | 2.극장 | 3.예매 | 4.예매내역 | 5.예매취소 | 6.영화검색 | 0.로그아웃");
			System.out.println("==============================================================");
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
		ArrayList<Movies> mvList = rdao.getMoviesList2();
		int totalCount = 0;
		for (int i = 0; i < mvList.size(); i++) {
			// 각 영화의 예매횟수 (count)를 모두 더하여 총 예매횟수 저장
			totalCount = totalCount + mvList.get(i).getReservationCount();
		}
		for (int i = 0; i < mvList.size(); i++) {
			// 소수점 없애고 int로 바꾼 예매율
			int reRate = (int) ((double) mvList.get(i).getReservationCount() / totalCount * 100 ) ;
			/* 소수점을 반올림한 예매율 */
			double reRate2 =(double) mvList.get(i).getReservationCount() / totalCount * 100 ; //27.272727
			double result =  Math.round(reRate2); //27.0
			/* 소수점 첫째자리까지 나타나는 예매율 */
			double result2 =  Math.round(reRate2*10)/10; //27.2
			/* 소수점 둘째자리까지 나타나는 예매율 */
			double result3 =  Math.round(reRate2*100)/100; //27.27
			
			mvList.get(i).setReservationRate(reRate);
			// split : 매개변수를 기준으로 분리 (모두 같은 형식이어야 for문으로 돌릴 수 있음)
			String mvopen = mvList.get(i).getMvopen(); // "2022/03/30"
			String[] mvopen_split = mvopen.split("/"); // [0]="2022", [1]="03", [2]="30"
			
			System.out.print("[" + (i+1) + "]");
			System.out.print(mvList.get(i).getMvname());
			System.out.print(" [개봉일]" + mvopen_split[0] + "년" + mvopen_split[1] + "월" + mvopen_split[2] + "일");
			System.out.print(" [예매율]" + reRate + "%");
			System.out.println(" [추천수]" + mvList.get(i).getRecommendCount());
		}
		System.out.print("선택 >> ");
		int menuSel = scan.nextInt();
		int mvNum = menuSel - 1;
		if (mvNum >= 0 && mvNum < mvList.size()) {
			System.out.println(mvList.get(mvNum).getMvname());
			System.out.print("[감독]" + mvList.get(mvNum).getMvpd());
			System.out.print(" [배우]" + mvList.get(mvNum).getMvactor());
			System.out.print(" [장르]" + mvList.get(mvNum).getMvgenre());
			System.out.print(" [등급]" + mvList.get(mvNum).getMvage() + "세 이상, " + mvList.get(mvNum).getMvtime() + "분");
			System.out.print(" [개봉일]" + mvList.get(mvNum).getMvopen());
			System.out.print("  [예매율]" + mvList.get(mvNum).getReservationRate() + "%");
			System.out.println("  [추천수]" + mvList.get(mvNum).getRecommendCount());
		} else {
			System.out.println("잘못 선택하였습니다.");
		}
		
		// 아래는 쿼리문 하나로 예매율까지 받아와서 실행한 코드
		/*
		ArrayList<Movies> mvList = rdao.getMoviesList();
		for(int i = 0; i < mvList.size(); i++) {
			// split : 매개변수를 기준으로 분리 (모두 같은 형식이어야 for문으로 돌릴 수 있음)
			String mvopen = mvList.get(i).getMvopen(); // "2022/03/30"
			String[] mvopen_split = mvopen.split("/"); // [0]="2022", [1]="03", [2]="30"
			
			System.out.print("[" + (i+1) + "]");
			System.out.print(mvList.get(i).getMvname());
			System.out.print(" [개봉일]" + mvopen_split[0] + "년" + mvopen_split[1] + "월" + mvopen_split[2] + "일");
			System.out.println(" [예매율]" + mvList.get(i).getReservationRate() + "%");
		}
		// 영화 상세정보
		System.out.print("선택 >> ");
		int menuSel = scan.nextInt();
		int mvNum = menuSel - 1;
		if (mvNum >= 0 && mvNum < mvList.size()) {
			System.out.println(mvList.get(mvNum).getMvname());
			System.out.print("[감독]" + mvList.get(mvNum).getMvpd());
			System.out.print(" [배우]" + mvList.get(mvNum).getMvactor());
			System.out.print(" [장르]" + mvList.get(mvNum).getMvgenre());
			System.out.print(" [등급]" + mvList.get(mvNum).getMvage() + "세 이상, " + mvList.get(mvNum).getMvtime() + "분");
			System.out.print(" [개봉일]" + mvList.get(mvNum).getMvopen());
			System.out.println("  [예매율]" + mvList.get(mvNum).getReservationRate() + "%");
		} else {
			System.out.println("잘못 선택하였습니다.");
		}
		*/
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
			System.out.print(" [개봉일]" + mvList.get(i).getMvopen());
			System.out.println(" [추천수]" + mvList.get(i).getRecommendCount());
		}
	}

	// 영화 예매
	public void reservationMovie() {
		/*
		 Reservation 테이블 - Insert
		 예매코드 : 'RE01'~ 자동생성
		 예매자 아이디 : loginId
		 극장코드, 상영관, 날짜 및 시간 : 사용자 선택
		 예매 인원 : scan 사용자입력
		 */
		System.out.println("[예매]");
		// 영화 선택
		String mvcode = selectMovie();
		if (mvcode == null) {
			return;
		}
		// 극장 선택
		String thcode = selectTheater(mvcode);
		if (thcode == null) {
			return;
		}
		// 날짜, 시간, 상영관 선택
		Schedules sc = selectDate(mvcode, thcode);
		if (sc == null) {
			return;
		}
		// 예매 인원
		System.out.print("예매인원 >> ");
		int reamount = scan.nextInt();
		// 예매코드 자동생성
		String maxRecode = rdao.getMaxRecode();
		String recode = "RE";
		int recodeNum = Integer.parseInt(maxRecode.substring(2)) + 1;
		if (recodeNum < 10) {
			recode = recode + "0" + recodeNum;
		} else {
			recode = recode + recodeNum;
		}
		// Reservation 테이블에 예매정보 INSERT
		Reservation reservation = new Reservation();
		reservation.setRecode(recode);
		reservation.setRemid(loginId);
		reservation.setRescthcode(thcode);
		reservation.setRescroom(sc.getScroom());
		reservation.setRescdate(sc.getScdate());
		reservation.setReamount(reamount);
		int insertResult = rdao.insertReservaiton(reservation);
		if (insertResult > 0) {
			System.out.println("[선택한 예매정보]");
			System.out.println(reservation.getRecode() + " " + reservation.getRemid() + " "
						+ reservation.getRescthcode() + " " + reservation.getRescroom() + " "
						+ reservation.getRescdate() + " " + reservation.getReamount() + "명");
			System.out.println("예매가 완료되었습니다.");
		} else {
			System.out.println("예매에 실패했습니다.");
		}
	}
	
	// 예매내역
	public void myReservation() {
		System.out.println("[예매내역]");
		ArrayList<Reservation> myReList = rdao.getMyRreservation(loginId);
		if (myReList.size() == 0) {
			System.out.println("예매내역이 없습니다.");
		} else {
			for (int i = 0; i < myReList.size(); i++) {
				System.out.print("\n[" + i + "] " 
								+ myReList.get(i).getMvname() + ", "
								+ myReList.get(i).getThname() + ", "
								+ myReList.get(i).getRescroom() + ", "
								+ myReList.get(i).getRescdate() + ", "
								+ myReList.get(i).getReamount() + "명");
				// 추천유무 출력
				int checkResult = rdao.checkRecommend(myReList.get(i).getRecode());
				/* reservation 클래스에 rccheck라는 변수를 새로 선언하여
				 * myReList.get(i).setRccheck() 값을 입력해주어도 됨
				 * 이렇게 진행하면 변수에 추천유무가 담기기 때문에 아래에서 checkRecommend 메소드를 다시 안써도 진행 가능
				 */
				if (checkResult > 0) {
					System.out.print(" [추천]");
				}
			}
			
			System.out.print("\n추천할 예매정보 선택 >> ");
			int mvSel = scan.nextInt();
			if (mvSel >= 0 && mvSel < myReList.size() ) { // 제대로 된 인덱스값 선택했는지 확인
				System.out.println("[" + myReList.get(mvSel).getMvname() + "]");
				String recode = myReList.get(mvSel).getRecode();
				// 추천하려고 선택한 영화가 RECOMMEND 테이블에 없는 예매코드인지 확인
				int checkResult = rdao.checkRecommend(recode);
				if (checkResult > 0) { // SELECT 결과 추천한 예매코드임을 확인
					System.out.println("이미 추천한 예매정보입니다.");
					System.out.print("추천을 취소하시겠습니까? (1.예 | 2.아니오) >> ");
					int recommendConfirm = scan.nextInt();
					if(recommendConfirm == 1) {
						int deleteResult = rdao.deleteRecommend(recode);
						if (deleteResult > 0) {
							System.out.println("추천이 취소되었습니다.");
						}
					}
				} else { // SELECT 결과 추천하지 않았던 예매코드임을 확인
					System.out.print("선택한 영화를 추천하시겠습니까? (1.예 | 2.아니오) >> ");
					int recommendConfirm = scan.nextInt();
					if (recommendConfirm == 1) { // RECOMMEND 테이블에 INSERT
						Recommend recommend = new Recommend();
						recommend.setRcrecode(recode);
						recommend.setRcmvcode(myReList.get(mvSel).getMvcode());
						recommend.setRcmid(loginId);
						int insertResult = rdao.insertRecommend(recommend);
						if (insertResult > 0) {
							System.out.println("추천되었습니다.");
						}
					}
				}
			}
		}
	}
	
	// 예매취소
	public void cancelReservation() {
		System.out.println("[예매취소]");
		ArrayList<Reservation> myReList = rdao.getMyRreservation(loginId);
		if (myReList.size() == 0) {
			System.out.println("예매내역이 없습니다.");
		} else {
			for (int i = 0; i < myReList.size(); i++) {
				System.out.println( "[" + i + "] "
								+ myReList.get(i).getMvname() + ", "
								+ myReList.get(i).getThname() + ", "
								+ myReList.get(i).getRescroom() + ", "
								+ myReList.get(i).getRescdate() + ", "
								+ myReList.get(i).getReamount() + "명");
			}
			System.out.print("취소할 예매번호 >> ");
			int cancelSel = scan.nextInt();
			if (cancelSel >= 0 && cancelSel < myReList.size()) {
				System.out.println( "[" + cancelSel + "] "
						+ myReList.get(cancelSel).getMvname() + ", "
						+ myReList.get(cancelSel).getThname() + ", "
						+ myReList.get(cancelSel).getRescroom() + ", "
						+ myReList.get(cancelSel).getRescdate() + ", "
						+ myReList.get(cancelSel).getReamount() + "명");
				System.out.print("선택한 예매를 취소하시겠습니까? (1.예 | 2.아니오) >> ");
				int cancelConfirm = scan.nextInt();
				if (cancelConfirm == 1) {
					// Recommend 테이블에서 먼저 데이터 삭제
					int deleteResult = rdao.deleteRecommend(myReList.get(cancelSel).getRecode());
					// Reservation 테이블에서 데이터 삭제
					String cancelRecode = myReList.get(cancelSel).getRecode();
					deleteResult = rdao.cancelReservation(cancelRecode);
					if (deleteResult > 0) {
						System.out.println("예매가 취소되었습니다.");
					}
				}
			}
		}
	}	
	
	/* Reservation Movie에 필요한 Method */
	private String selectMovie() {
		// 영화목록 출력
		System.out.println("[영화목록]");
		ArrayList<Movies> scmvList = rdao.getScmvList();
		for (int i = 0; i < scmvList.size(); i++) {
			System.out.print("[" + i + "]");
			System.out.println(scmvList.get(i).getMvname() + ", " + scmvList.get(i).getMvage() + "세 이상");
		}
		System.out.print("영화 선택 >> ");
		int mvSel = scan.nextInt();
		String mvcode = null; // 선택한 영화코드를 저장할 변수
		if (mvSel >= 0 && mvSel < scmvList.size()) {
			System.out.println("[선택한 영화]" + scmvList.get(mvSel).getMvname());
			mvcode = scmvList.get(mvSel).getMvcode(); // 선택한 영화코드 저장
		} else {
			System.out.println("잘못 선택하였습니다.");
		}
		return mvcode;
	}
	
	private String selectTheater(String mvcode) {
		// 상영극장 출력
		
		String thcode = null; // 선택한 극장코드를 저장할 변수
		ArrayList<Theaters> scthList = rdao.getScthList(mvcode);
		while(true) {
			System.out.println("[극장목록]");
			for (int i = 0; i < scthList.size(); i++) {
				System.out.print("[" + i + "]");
				System.out.println(scthList.get(i).getThname());
			}
			System.out.print("극장 선택 >> ");
			int thSel = scan.nextInt();
			if (thSel >= 0 && thSel < scthList.size()) {
				System.out.println("[선택한 극장]" + scthList.get(thSel).getThname());
				thcode = scthList.get(thSel).getThcode(); // 선택한 극장코드 저장
				break;
			} else {
				System.out.println("잘못 선택하였습니다.");
			}
			
		}
		return thcode;
	}
	
	private Schedules selectDate(String mvcode, String thcode) {
		// 상영일 출력
		Schedules sc = null;	// return하기 위한 객체
		String scdate = "";		// 날짜 및 시간 저장하기 위한 변수
		System.out.println("[예매가능 날짜 목록]");
		ArrayList<Schedules> scdateList = rdao.getScdate(mvcode, thcode);
		for (int i = 0; i < scdateList.size(); i++) {
			System.out.print("[" + i + "]");
			System.out.println(scdateList.get(i).getScdate());
		}
		System.out.print("날짜 선택 >> ");
		int dateSel = scan.nextInt();
		if (dateSel >= 0 && dateSel < scdateList.size()) {
			// 상영관, 상영시간 출력
			scdate = scdateList.get(dateSel).getScdate(); // 날짜 저장
			System.out.println("[시간표]");
			ArrayList<Schedules> sctimeList = rdao.getSctime(mvcode, thcode, scdate);
			for (int i = 0; i < sctimeList.size(); i++) {
				System.out.print("[" + i + "]");
				System.out.println(sctimeList.get(i).getScroom() + " " + sctimeList.get(i).getScdate());
			}
			System.out.print("시간 선택 >> ");
			int timeSel = scan.nextInt();
			if (timeSel >= 0 && timeSel < sctimeList.size()) {
				scdate = scdate + " " + sctimeList.get(timeSel).getScdate(); // 시간 저장
				String scroom = sctimeList.get(timeSel).getScroom();
				System.out.print("[상영일 및 시간]" + scdate);
				System.out.println(" [상영관]" + scroom);
				sc = new Schedules();	// 선택한 날짜 및 시간, 상영관을 저장할 객체
				sc.setScdate(scdate);	// 날짜 및 시간 저장
				sc.setScroom(scroom);	// 상영관 저장
			} else {
				System.out.println("잘못 선택하였습니다.");
			}
		}
		else {
			System.out.println("잘못 선택하였습니다.");
		}
		return sc;
	}
	
	
	
}
