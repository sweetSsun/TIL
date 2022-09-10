package jdbc3_Bank;

public class BankInfo {

	private int clientNumber;
	private String clientName;
	private String accountNumber;
	private int balance;
	
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
		return "고객번호 : " + clientNumber + ", 고객이름 : " + clientName + ", 계좌번호 : "
				+ accountNumber + ", 잔액 : " + balance + "]";
	}
	
	
	
	
	
}
