package day014_1;

public class BankInfo {

	private int clientNumber; 		// 고객번호
	private String clientName; 		// 고객이름
	private String accountNumber;	// 계좌번호
	private int balance;			// 잔액
	
	public int getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankInfo [고객번호=" + clientNumber + ", 고객명=" + clientName + ", 계좌번호="
				+ accountNumber + ", 잔액=" + balance + "]";
	}
	
	
}
