package persistance;

import java.util.ArrayList;

import bean.Account;

public interface AccountDao {

	ArrayList<Account> getAllAccount();
	Account getAccountByAccountNumber(String accNo);
	boolean addAccount(Account account);
	boolean deleteAccount(String account);
	boolean updateAccountByAccNo(String num,String name);
	boolean Transaction(int bal,String acc1,String acc2);

}
