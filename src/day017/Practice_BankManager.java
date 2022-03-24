package day017;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice_BankManager {

	Scanner scan = new Scanner(System.in);
	
	
	private ArrayList<Practice_BankInfo> clientList = new ArrayList<Practice_BankInfo>(10);
	int count = 0;
	
	
	//메뉴출력 및 선택
	public int showMenu() {
		System.out.println("\n===============================Menu===============================");
		System.out.println("1.계좌생성 | 2.입금 | 3.출금 | 4.잔액조회 | 5.계좌이체 | 6.고객리스트 | 0.종료");
		System.out.println("==================================================================");
		System.out.print("메뉴 선택 >> ");
		int menuSel = scan.nextInt();
		return menuSel;
	}
	
	//계좌번호 확인
	public int checkAccount() {
		int index = -1;
		String inputAccountNum = scan.next();
		for(int i = 0; i < clientList.size(); i++) {
			if ( inputAccountNum.equals(clientList.get(i).getAccountNum()) ){
				index = i;
			}
		}
		return index;
	}
	
	//잔액조회
	public void showBalance(int index) {
		System.out.println("잔액은 " + clientList.get(index).getBalance() + "원 입니다.");
	}
	
	//고객리스트 확인
	public void showClientList() {
		for ( int i = 0; i < clientList.size(); i++ ) {
			System.out.println( "고객명 : " + clientList.get(i).getClientName()
					+ ", 계좌번호 : " + clientList.get(i).getAccountNum()
					+ ", 잔액 : " + clientList.get(i).getBalance() );
		}
	}
	
	//계좌 생성
	public void createAccount() {
		System.out.println("[계좌생성]");
		Practice_BankInfo newAccount = new Practice_BankInfo();
		newAccount.setClientNum(count);
		count++;
		System.out.print("고객명 입력 >> ");
		String name = scan.next();
		newAccount.setClientName(name);
		System.out.print("계좌번호 입력 >> ");
		String accountNum = scan.next();
		newAccount.setAccountNum(accountNum);
		System.out.print("초기 입금액 >> ");
		int deposit = scan.nextInt();
		newAccount.setBalance(deposit);
		
		clientList.add(newAccount);
		System.out.println("신규계좌가 생성되었습니다.");
	}
	
	//입금
	public void deposit() {
		System.out.println("[입금]");
		System.out.print("입금할 계좌번호 >> ");
		int index = checkAccount();
		if(index > -1) {
			System.out.print("입금할 금액 >> ");
			int deposit = scan.nextInt();
			clientList.get(index).setBalance( clientList.get(index).getBalance() + deposit );
			System.out.println("입금되었습니다.");
			showBalance(index);
		} else {
			System.out.println("없는 계좌번호입니다.");
		}
	}
	
	// 출금
	public void withdraw() {
		System.out.println("[출금]");
		System.out.print("출금할 계좌번호 >> ");
		int index = checkAccount();
		if (index > -1) {
			System.out.print("출금할 금액 >> ");
			int withdraw = scan.nextInt();
			if (clientList.get(index).getBalance() >= withdraw) {
				clientList.get(index).setBalance(clientList.get(index).getBalance() - withdraw);
				System.out.println("출금되었습니다.");
			} else {
				System.out.println("잔액이 부족합니다.");
			}
			showBalance(index);
		} else {
			System.out.println("없는 계좌번호입니다.");
		}
	}
	
	//잔액조회
	public void checkBalance() {
		System.out.println("[잔액조회]");
		System.out.print("조회할 계좌번호 >> ");
		int index = checkAccount();
		if (index > -1) {
			showBalance(index);
		} else {
			System.out.println("없는 계좌번호입니다.");
		}
	}
	
	//계좌이체
	public void transferAccount() {
		System.out.println("[계좌이체]");
		System.out.print("보내는 계좌번호 >> ");
		int sendIndex = checkAccount();
		System.out.print("받는 계좌번호 >> ");
		int receiveIndex = checkAccount();
		if (sendIndex > -1 && receiveIndex > -1) {
			System.out.print("이체할 금액 >> ");
			int money = scan.nextInt();
			if (clientList.get(sendIndex).getBalance() >= money) {
				clientList.get(sendIndex).setBalance(clientList.get(sendIndex).getBalance() - money);
				clientList.get(receiveIndex).setBalance(clientList.get(receiveIndex).getBalance() + money);
				System.out.println("이체 되었습니다.");
			} else {
				System.out.println("잔액이 부족합니다.");
			}
			showBalance(sendIndex);
		} else {
			System.out.println("없는 계좌번호입니다.");
		}
	}
	
	

}
