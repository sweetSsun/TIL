package jdbc3_Bank;

import java.util.ArrayList;
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

//	이곳부터 오후 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// 고객리스트 출력 기능
	public void clientList() {
		System.out.println("[고객리스트]");
		ArrayList<BankInfo> clientList = bdao.selectClientList();
		for(int i = 0; i < clientList.size(); i++) {
			System.out.print("[고객번호]" + clientList.get(i).getClientNumber() );
			System.out.print(" [고객이름]" + clientList.get(i).getClientName());
			System.out.print(" [계좌번호]" + clientList.get(i).getAccountNumber());
			System.out.print(" [잔액]" + clientList.get(i).getBalance() + "\n");
		}
	}

	// 입금 기능
	public void deposit() {
		System.out.println("[입금]");
		// 입금 계좌번호 확인 - 있으면 금액 입력, 입금 처리 / 없으면 없는 계좌번호 안내 후 종료
		System.out.print("입금할 계좌번호 >>");
		String accountNumber = scan.next();
		BankInfo client = bdao.checkAccount(accountNumber); // 계좌번호 확인
		if (client != null) {
			System.out.print("입금할 금액 >> ");
			int deposit = scan.nextInt();
			// DAO >> UPDATE문 수행
			int depositResult = bdao.updateDeposit(client, deposit);
			System.out.println("입금되었습니다.");
			System.out.println("현재 잔액은 " + (client.getBalance() + deposit) + "원 입니다.");
		} else {
			System.out.println("없는 계좌번호입니다.");
		} 
	}

	// 출금 기능
	public void withdraw() {
		System.out.println("[출금]");
		System.out.print("출금할 계좌번호 >> ");
		String accountNumber = scan.next();
		BankInfo client = bdao.checkAccount(accountNumber); // 계좌번호 확인
		if (client != null) {
			System.out.print("출금할 금액 >> ");
			int withdraw = scan.nextInt();
			int balance = client.getBalance();
			if (balance >= withdraw) { // 출금액과 잔액 비교
				int withdrawResult = bdao.updateWithdraw(client, withdraw);
				balance = balance - withdraw;
				System.out.println("출금되었습니다.");
			} else {
				System.out.println("잔액이 부족합니다.");
			}
			System.out.println("현재 잔액은 " + balance + "원 입니다.");
		} else {
			System.out.println("없는 계좌번호입니다.");

		}
	}
	
	// 잔액 조회
	public void checkBalance() {
		System.out.println("[조회]");
		System.out.print("조회할 계좌번호 >> ");
		String accountNumber = scan.next();
		BankInfo client = bdao.checkAccount(accountNumber);
		if (client != null) {
			System.out.println("현재 잔액은 " + client.getBalance() + "원 입니다.");
		} else {
			System.out.println("없는 계좌번호입니다.");
		}
	}
	
	// 이체 기능
	public void transferAccount() {
		System.out.println("[이체]");
		System.out.print("이체할 계좌번호 >> ");
		String sendAccount = scan.next();
		BankInfo sendClient = bdao.checkAccount(sendAccount);
		System.out.print("이체받을 계좌번호 >> ");
		String receiveAccount = scan.next();
		BankInfo receiveClient = bdao.checkAccount(receiveAccount);
		if (sendClient != null && receiveClient != null) {
			System.out.print("이체할 금액 >> ");
			int money = scan.nextInt();
			int balance = sendClient.getBalance();
			if (balance >= money ) {
				int sendResult = bdao.updateWithdraw(sendClient, money);
				int receiveResult = bdao.updateDeposit(receiveClient, money);
				balance = balance - money;
				System.out.println("이체되었습니다.");
			} else {
				System.out.println("잔액이 부족합니다");
			}
			System.out.println("현재 잔액은 " + balance + "원 입니다.");
		} else {
			System.out.print("없는 계좌번호입니다.");
		}
	}
	
	
}
