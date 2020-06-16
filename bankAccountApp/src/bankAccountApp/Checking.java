package bankAccountApp;

public class Checking extends  Account {

	//List properties specific to a checking account
	protected int debitCardNumber;
	protected int debitCardPin;
	
	//Constructor to initialize checking account properties
	public Checking(String name, String sSN, double initDeposit) {
		
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	
	}
	
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random()*Math.pow(10, 12));
		debitCardPin = (int) (Math.random()*Math.pow(10, 4));
	
	}
	//List any methdsp specific to checking account
	public void showInfo() {
		super.showInfo();
		System.out.println("ACCOUNT TYPE: CHECKING" + 
		 "\nDEBIT CARD NUMBER:  " + debitCardNumber + 
		 "\nDEBIT CARD PIN: " + debitCardPin);
	}

	@Override
	public void setRate() {
		// TODO Auto-generated method stub
		rate = getBaseRate() * .15;
	}
}
