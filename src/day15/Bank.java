package day15;

public class Bank {









	private String clientNumber; // °í°´ ¹øÈ£ 
	private String name;         // °í°´¸í
	private String accountNumber; // °èÁÂ¹øÈ£
	private int balance;          // ÀÜ°í 

public Bank(String clientNumber, String name, String accountNumber, int balance) {
		super();
		this.clientNumber = clientNumber;
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}



Bank(){
	
}

//Bank(String clientNumber,String name,
//String accountNumber,int balance){
//	this.clientNumber=clientNumber;
//	this.name=name;
//	this.accountNumber=accountNumber;
//	this.balance=balance;




public String getClientNumber() {
	return clientNumber;
}

public void setClientNumber(String clientNumber) {
	this.clientNumber = clientNumber;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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
	return "Bank [clientNumber=" + clientNumber + ", name=" + name + ", accountNumber=" + accountNumber + ", balance="
			+ balance + "]";
}


 












}

