package presentation;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Account;
import service.AccountService;
import service.AccountServiceImpl;

public class AccountPresentationImpl implements AccountPresentation {


	private final AccountService accountService = new AccountServiceImpl();
	
	@Override
	public void showMenu() {
		
		System.out.println("Account Transaction");
		System.out.println("==================================");
		System.out.println("1. List All Account Details ");
		System.out.println("2. List Account Details By Account Number ");
		System.out.println("3. Add Account ");
		System.out.println("4. Delete Account ");
		System.out.println("5. Update Account ");
		System.out.println("6. Transfer Money ");
		System.out.println("7. Exit ");
		System.out.println("==================================");

		
	}

	@Override
	public void performMenu(int choice) {
		
		Scanner scanner=new Scanner(System.in);

		switch (choice) {
			case 1 : {
				ArrayList<Account> accountList = accountService.getAllAccount();
				for (Account acc : accountList) {
					System.out.println(acc);
				}
				break;
			}

			case 2 : {
				System.out.println("Enter Account Number to be searched for : ");
				String accNo = scanner.next();
				Account searchedAccount = accountService.getAccountByAccountNumber(accNo);
				if (searchedAccount != null)
					System.out.println(searchedAccount);
				else
					System.out.println("Account with Account Number " + accNo + " does not exist!");
				break;
			}

			case 3 : {
				System.out.println("Enter Account Number : ");
				String num = scanner.next();
				System.out.println("Enter Account Name : ");
				String name = scanner.next();
				System.out.println("Enter Account Type : ");
				String type = scanner.next();
				System.out.println("Enter Account Balance : ");
				int bal = scanner.nextInt();
				Account account = new Account(num, name, type, bal);
				if (accountService.insertAccount(account))
					System.out.println("Account created successfully!");
				else
					System.out.println("Account creation failed!");
				break;
			}

			case 4 : {
				System.out.println("Enter Account Number : ");
				String accNum = scanner.next();
				if (accountService.removeAccount(accNum))
					System.out.println("Account deleted successfully");
				else
					System.out.println("Account deletion failed!!");
				break;
			}

			case 5 : {
				System.out.println("Enter Account Number : ");
				String num1 = scanner.next();
				System.out.println("Enter Account Name : ");
				String name1 = scanner.next();
				if (accountService.updatingByAccNo(num1, name1))
					System.out.println("Updating account successful!");
				else
					System.out.println("Updating account failed!");
				break;
			}

			case 6 : {
				System.out.println("Enter Amount you want to transfer : ");
				int bal1 = scanner.nextInt();
				System.out.println("Enter From Account Number: ");
				String acc1 = scanner.next();
				System.out.println("Enter To Account Number: ");
				String acc2 = scanner.next();
				if (accountService.AccTransaction(bal1, acc1, acc2))
					System.out.println("Transaction Successful!");
				else
					System.out.println("Transaction Failed!");
			
				break;
				}

			case 7 : {
				System.out.println("Thanks for Using our System");
				System.exit(0);
				break;
			}

			default : System.out.println("Invalid Choice");
		}

	}

		
}

