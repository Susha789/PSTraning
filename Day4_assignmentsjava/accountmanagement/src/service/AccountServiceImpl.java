package service;

import java.util.ArrayList;

import bean.Account;
import persistance.AccountDao;
import persistance.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {
	
	private final AccountDao accountDao = new AccountDaoImpl();

	@Override
	public ArrayList<Account> getAllAccount() {
		return accountDao.getAllAccount();
	}

	@Override
	public Account getAccountByAccountNumber(String AccNo) {
		
		return accountDao.getAccountByAccountNumber(AccNo);
	}

	@Override
	public boolean insertAccount(Account account) {
		
		return accountDao.addAccount(account);
	}

	@Override
	public boolean removeAccount(String AccNo) {
		
		return accountDao.deleteAccount(AccNo);
	}

	@Override
	public boolean updatingByAccNo(String AccNo, String Name) {
		
		return accountDao.updateAccountByAccNo(AccNo, Name);
	}

	@Override
	public boolean AccTransaction(int amount, String accOne, String accTwo) {
		
		return accountDao.Transaction(amount, accOne, accTwo);
	}

	
}