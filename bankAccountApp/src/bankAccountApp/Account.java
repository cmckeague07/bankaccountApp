package bankAccountApp;

public abstract class Account implements IRate {

	//List common properties for Savings and Checking Accounts
	private String name;
	private String sSN;
	protected double balance;
	
	static int index = 10000;
	protected String accountNumber; 
	protected double rate; 
	
	//Constructor to set base properties and intialize account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit; 
		
		
		//Set account number
		index++;
		this.accountNumber = setAccountNumber();
		setRate();
	
	}
	
	public abstract void setRate();
	//List common methods
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
		}
	
	public void deposit(double amount) {
		 balance = balance + amount;
		 System.out.println("Depositing $" + amount);
		 printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing " + amount);
		 printBalance();
	}
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("TRANSFERING " + amount + " to" + toWhere);
		 printBalance();
	}
	public void printBalance() {
		System.out.println("Your balance is now : $" + balance);
		
	}
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
	public void showInfo() {
		System.out.println(
				"NAME: " + name + 
				"\nACCOUNT NUMBER: " + accountNumber + 
				"\nBALANCE: " + balance + "\nRATE: " + rate + "%"
				);
	}
}
