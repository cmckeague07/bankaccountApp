package bankAccountApp;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
		List<Account> accounts = new LinkedList<Account>();
		/*
		Checking chck1 = new Checking("Tom Wilson", "19N290DN0", 245991);
		Savings savacc1 = new Savings("Conor Moye", "942NNB23A", 100000);
		savacc1.showInfo();
		System.out.println("*******************************");
		chck1.showInfo();
		savacc1.compound();
		savacc1.deposit(200);
		savacc1.withdraw(222);
		savacc1.transfer(" Chekcing", 100);
		*/
		
		
		String path = "C:\\Users\\cmcke\\OneDrive\\Desktop\\testRun.csv";
		List<String[]> newAccountHolder = CSV.read(path);
		for(String[]accountHolder: newAccountHolder) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			System.out.println(name + " " + sSN + " " + accountType + " " + initDeposit);
			if(accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
			}else if(accountType.equals("Checking")){
				accounts.add(new Checking(name, sSN, initDeposit));
			}else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		for(Account acc: accounts) {
			System.out.println("\n**************");
			acc.showInfo();
		}
		
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line;
			while((line = br.readLine()) != null) {
				System.out.println("\n" + line);
			}
		}
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(path));
			lines.forEach(System.out::println);
		}catch(IOException e) {
			/** */
		}
		
		
		
	}

}
