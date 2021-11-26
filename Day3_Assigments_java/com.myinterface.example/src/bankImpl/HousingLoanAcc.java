package bankImpl;

import bank.DebitInterest;
import bank.LoanAcc;

public class HousingLoanAcc implements LoanAcc, DebitInterest{

	@Override
    public void deductMonthlyInt() {
        System.out.println("Monthly interest is deducted");
    }

    @Override
    public void deductHalfYearlyInt() {
        System.out.println("Yearly interest is deducted");
    }

    @Override
    public void deductAnnualInt() {
        System.out.println("Annual interest is deducted");
    }

    @Override
    public void repayPrincipal() {
        System.out.println("Principle is payed");
    }

    @Override
    public void payInterest() {
        System.out.println("Interest is payed");
    }

    @Override
    public void payPartialPrincipal() {
        System.out.println("Partial interest is payed");
    }


}
