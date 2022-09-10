package day014_1;

import java.util.ArrayList;
import java.util.Scanner;

public class BankManager_ArrayList {
	// 기능 클래스
	Scanner scan = new Scanner(System.in);
	
	// 등록된 계좌목록
//	private BankInfo[] clientList = new BankInfo[100];
	private ArrayList<BankInfo> clientArrayList = new ArrayList<BankInfo>();
	
	private int clientNumber = 1; // 고객번호 변경 변수
//	private int count = 0; // 배열의 인덱스값 변경 변수
	
	// 메뉴 출력 기능
	public void showMenu() {
		System.out.println("\n============================================================");
		System.out.println("1.계좌생성 | 2.입금 | 3.출금 | 4.잔액 | 5.이체 | 6.고객리스트 | 0.종료");
		System.out.println("============================================================");
		System.out.print("메뉴선택 >> ");
	}
	
	// 계좌 생성 기능
	public void createAccount() {
		System.out.println("[계좌생성]");
		BankInfo newAccount = new BankInfo();
		// 고객번호, 고객이름, 계좌번호, 잔액
		newAccount.setClientNumber(clientNumber);
		clientNumber++;
		System.out.print("고객이름 >> ");
		String inputClientName = scan.next();
		System.out.print("계좌번호 >> ");
		String inputAccountNumber = scan.next();
		System.out.print("초기입금액 >> ");
		int inputBalance = scan.nextInt();
		
		newAccount.setClientName(inputClientName);
		newAccount.setAccountNumber(inputAccountNumber);
		newAccount.setBalance(inputBalance);
		
//		clientList[count] = newAccount;
//		count++;
//		if(count == clientList.length) {
//			count = 0;
//		}
		clientArrayList.add(newAccount);
		System.out.println("신규 계좌가 생성되었습니다.");
	}

	// 계좌확인 메소드
	public int searchAccount(String menu) {
		int index = -1;
		System.out.print(menu + "할 계좌번호 >> ");
		String accountNumber = scan.next();
//		for(int i = 0; i < clientList.length; i++) {
//			if(clientList[i] != null) {
//				if(clientList[i].getAccountNumber().equals(accountNumber) ) {
//					index = i;
//				}
//			}
//		}
		for ( int i = 0; i < clientArrayList.size(); i++ ) {
			if (clientArrayList.get(i).getAccountNumber().equals(accountNumber) ) {
				index = i;
			}
		}
		return index;
	}
	
	// 입금 기능
	public void depositAccount() {
		System.out.println("[입금]");
		int index = searchAccount("입금"); // 계좌확인 메소드 호출
		if(index > -1) {
			System.out.print("입금할 금액 >> ");
			int deposit = scan.nextInt();
//			int balance = clientList[index].getBalance() + deposit; // 잔액 증가
			int balance = clientArrayList.get(index).getBalance() + deposit;
			
//			clientList[index].setBalance(balance);
			clientArrayList.get(index).setBalance(balance);
			System.out.println("입금되었습니다.");
//			System.out.println("잔액은 " + clientList[index].getBalance() + "원 입니다.");
			System.out.println("잔액은 " + clientArrayList.get(index).getBalance() + "원 입니다.");
		} else {
			System.out.println("없는 계좌번호입니다.");
		}
	}
	
	// 출금 기능
	public void withdrowAccount() {
		System.out.println("[출금]");
		int index = searchAccount("출금"); // 계좌확인 메소드 호출
		if(index > -1) {
			System.out.print("출금할 금액 >> ");
			int withdraw = scan.nextInt();
//			if (clientList[index].getBalance() >= withdraw) { // 출금계좌 잔액 확인
//				int balance = clientList[index].getBalance() - withdraw; // 잔액 차감
//				clientList[index].setBalance(balance);
			if ( clientArrayList.get(index).getBalance() >= withdraw ) {
				int balance = clientArrayList.get(index).getBalance() - withdraw;
				clientArrayList.get(index).setBalance(balance);					
				System.out.println("출금되었습니다.");
			} else {
				System.out.println("잔액이 부족합니다.");
			}
//			System.out.println("잔액은 " + clientList[index].getBalance() + "원 입니다.");
			System.out.println("잔액은 " + clientArrayList.get(index).getBalance() + "원 입니다.");
		} else {
			System.out.println("없는 계좌번호입니다.");
		}
	}
	
	// 잔액조회 기능
	public void balanceCheck() {
		System.out.println("[잔액]");
		int index = searchAccount("잔액조회"); // 계좌확인 메소드 호출
		if ( index > -1 ) {
//			System.out.println("현재 잔액은 " + clientList[index].getBalance() + "원 입니다.");
			System.out.println("현재 잔액은 " + clientArrayList.get(index).getBalance() + "원 입니다.");
		} else {
			System.out.println("없는 계좌번호입니다.");
		}
	}
	
	// 이체 기능
	public void transferAccount() {
		System.out.println("[이체]");
//		int sendIndex = searchAccount("계좌이체");
//		if (sendIndex > -1) {
//			int receiveIndex = searchAccount("입금");
//			if (receiveIndex > -1) {
//				System.out.print("이체할 금액 >> ");
//				int money = scan.nextInt();
//				if(clientList[sendIndex].getBalance() >= money) {
//					int sendBalance = clientList[sendIndex].getBalance() - money; // 출금처리
//					clientList[sendIndex].setBalance(sendBalance);
//					int receiveBalance = clientList[receiveIndex].getBalance() + money; // 입금처리
//					clientList[receiveIndex].setBalance(receiveBalance);
//					System.out.println("보내는 계좌 : " + clientList[sendIndex].getAccountNumber());
//					System.out.println("받는 계좌 : " + clientList[receiveIndex].getAccountNumber());
//					System.out.println("이체 금액 : " + money);
//					System.out.println("이체되었습니다.");
//				} else {
//					System.out.println("잔액이 부족합니다.");
//				}
//				System.out.println("잔액은 " + clientList[sendIndex].getBalance() + "원 입니다.");
//			} else {
//				System.out.println("입금받을 계좌번호가 잘못되었습니다.");
//			}
//		} else {
//			System.out.println("출금할 계좌번호가 잘못되었습니다.");
//		}
		int sendIndex = searchAccount("출금");
		int receiveIndex = searchAccount("이체");
		if ( sendIndex > -1 && receiveIndex > -1 ) {
			System.out.print("이체할 금액 >> ");
			int money = scan.nextInt();
			if ( money <= clientArrayList.get(sendIndex).getBalance()) {
				int sendBalance = clientArrayList.get(sendIndex).getBalance() - money;
				int receiveBalance = clientArrayList.get(receiveIndex).getBalance() + money;
				clientArrayList.get(sendIndex).setBalance(sendBalance);
				clientArrayList.get(receiveIndex).setBalance(receiveBalance);
				System.out.println("보내는 계좌 : " + clientArrayList.get(sendIndex).getAccountNumber());
				System.out.println("받는 계좌 : " + clientArrayList.get(receiveIndex).getAccountNumber());
				System.out.println("이체 금액 : " + money);
				System.out.println("이체되었습니다.");
			} else {
				System.out.println("잔액이 부족합니다.");
			}
			System.out.println("잔액은 " + clientArrayList.get(sendIndex).getBalance() + "원 입니다.");
		} else {
			System.out.println("없는 계좌번호입니다.");
		}
	}
	
	// 고객리스트 출력 기능
	public void checkClientList() {
		System.out.println("[고객리스트]");
//		for(int i = 0; i < clientList.length; i++) {
//			if (clientList[i] != null) {
//				System.out.println(clientList[i].toString());
//			}
//		}
		for ( int i = 0; i < clientArrayList.size(); i++ ) {
			System.out.println( clientArrayList.get(i).toString() );
		}
	}
	
	
}
