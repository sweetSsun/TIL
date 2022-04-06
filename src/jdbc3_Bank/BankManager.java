package jdbc3_Bank;

import java.util.Scanner;

public class BankManager {

	Scanner scan = new Scanner(System.in);
	BankDao bdao = new BankDao();
	
	// 메뉴 출력 기능
	public void showMenu() {
		System.out.println("\n===========================================================");
		System.out.println("1.계좌생성 | 2.입금 | 3.출금 | 4.조회 | 5.이체 | 6.고객리스트 | 0.종료");
		System.out.println("===========================================================");
		System.out.print("메뉴 선택 >> ");
	}

	// 계좌생성 기능
	public void createAccount() {
		System.out.println("[계좌생성]");
		BankInfo newAccount = new BankInfo();
		
		//고객번호 자동 생성
		int maxClientNumber = bdao.getMaxClientNumber();
		int clientNumber = maxClientNumber + 1;
		System.out.println("고객번호 : " + clientNumber);
		
		//계좌번호 자동 생성
		// '01-003' >> "01-", "003" 분리 >> "003" 숫자 3으로 변환 >> 1증가 4 >> "004" 문자로 변환
		// 1. 현재 등록된 계좌번호의 최대값을 조회
		String maxAccountNumber = bdao.getMaxAccountNumber();
		// 2. 고정번호 제외하고 나머지 문자열 분리
		// String ' 0 1 - 0 0 3 '
		// index    0 1 2 3 4 5
		maxAccountNumber = maxAccountNumber.substring(3); // "003"
		// 3. 분리된 문자열을 숫자로 변환하여 +1
		int accountNum = Integer.parseInt(maxAccountNumber) + 1; // 숫자 4
		// 4. 새로 만들어진 번호를 고정번호와 합쳐 문자로 변환
		String accountNumber = "01-";
		if (accountNum < 10) {
			accountNumber = accountNumber + "00" + accountNum;
		} else if (accountNum < 100 ) {
			accountNumber = accountNumber + "0" + accountNum;
		} else {
			accountNumber = accountNumber + accountNum;
		}
		System.out.println("계좌번호 : " + accountNumber); // "01-004"
						
//		System.out.print("계좌번호 입력 >> ");
//		String accountNumber = scan.next();
		//나머지 고객정보 입력
		System.out.print("고객이름 입력 >> ");
		String cleintName = scan.next();
		System.out.print("초기입금액 입력 >> ");
		int balance = scan.nextInt();
		
		newAccount.setClientNumber(clientNumber);
		newAccount.setClientName(cleintName);
		newAccount.setAccountNumber(accountNumber);
		newAccount.setBalance(balance);
		
		//DAO >> INSERT문 수행
		int insertResult = bdao.createAccount(newAccount);
		if (insertResult > 0) {
			System.out.println("신규 계좌가 생성되었습니다.");
		} else {
			System.out.println("계좌 생성에 실패했습니다.");
		}
		
	}
	
	
	
	
	
}
