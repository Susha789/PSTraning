package bankImpl;

import bank.CreditInterest;
import bank.DepositAcc;

public class FDAcc implements DepositAcc, CreditInterest {



    @Override
    public void addMonthlyInt() {
        System.out.println("Monthly interest is debited");
    }

    @Override
    public void addHalfYearlyInt() {
        System.out.println("Yearly interest is debited");
    }

    @Override
    public void addAnnualInt() {
        System.out.println("Annual interest is debited");
    }

    @Override
    public void withdraw(int Amount) {
        System.out.println("Amount: " + Amount + " Rs. is withdraw");
    }

    @Override
    public void deposit(int Amount) {
        System.out.println("Amount: " + Amount + " Rs. is deposited");
    }

    @Override
    public void getBalance() {
        System.out.println("Your current balance is 5000 Rs.");
    }

}
