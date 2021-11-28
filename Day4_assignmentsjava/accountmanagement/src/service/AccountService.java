package service;

import java.util.ArrayList;

import bean.Account;

public interface AccountService {

	ArrayList<Account> getAllAccount();

    Account getAccountByAccountNumber(String accNo);

    boolean insertAccount(Account account);

    boolean removeAccount(String AccNo);

    boolean updatingByAccNo(String AccNo, String Name);

    boolean AccTransaction(int amount, String accOne, String accTwo);

}
