package bankAccountApp; 

public class Savings extends Account{
	//List properties specific to savings account
	protected int safetyDepositBoxID;
	protected int safetyDepositBoxKey;
	
	//Constructor to initialize settings for the savgins properties
	public Savings(String name, String sSN, double initDeposit) {
	super(name, sSN, initDeposit);
	accountNumber = "1" + accountNumber;
	setSafetyDepositBox();
	}
	
	private void setSafetyDepositBox()	{
		safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int)(Math.random()*Math.pow(10, 4));
	}
	
	//List methods specific to savings account
	public void showInfo() {
		super.showInfo();
		System.out.println("ACCOUNT TYPE: SAVINGS" + 
						   "\n Safety Deposit Box ID: " + safetyDepositBoxID + 
						   "\n Safety Deposit Box Key: " + safetyDepositBoxKey);
	}

	@Override
	public void setRate() {
		// TODO Auto-generated method stub
		rate = getBaseRate() - .15;
	}
}
