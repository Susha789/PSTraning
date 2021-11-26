package bankImpl;

public class MyAccount {
	
	public static void main(String[] args)
    {
        SavingsAcc savingsAcc = new SavingsAcc();
        PersonalLoanAcc personalLoanAcc = new PersonalLoanAcc();
        FDAcc fdAcc = new FDAcc();
        HousingLoanAcc housingLoanAcc = new HousingLoanAcc();

        System.out.println("========= SAVING ========\n");
        savingsAcc.deposit(10000);
        savingsAcc.addMonthlyInt();
        savingsAcc.addHalfYearlyInt();
        savingsAcc.addAnnualInt();
        savingsAcc.withdraw(5000);
        savingsAcc.withdraw(5000);
        savingsAcc.getBalance();

        System.out.println("\n========= PERSONAL LOAN ACCOUNT ========\n");
        personalLoanAcc.payInterest();
        personalLoanAcc.deductMonthlyInt();
        personalLoanAcc.deductHalfYearlyInt();
        personalLoanAcc.deductAnnualInt();
        personalLoanAcc.payPartialPrincipal();
        personalLoanAcc.repayPrincipal();

        System.out.println("\n========= FD ACCOUNT ========\n");
        fdAcc.deposit(10000);
        fdAcc.addMonthlyInt();
        fdAcc.addHalfYearlyInt();
        fdAcc.addAnnualInt();
        fdAcc.withdraw(5000);
        fdAcc.withdraw(5000);
        fdAcc.getBalance();

        System.out.println("\n========= PERSONAL LOAN ACCOUNT ========\n");
        housingLoanAcc.payInterest();
        housingLoanAcc.deductMonthlyInt();
        housingLoanAcc.deductHalfYearlyInt();
        housingLoanAcc.deductAnnualInt();
        housingLoanAcc.payPartialPrincipal();
        housingLoanAcc.repayPrincipal();

    }



}
