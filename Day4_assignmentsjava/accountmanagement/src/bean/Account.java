package bean;

public class Account {

	private final String AccNo;
    private final String AccName;
    private final String AccType;
    private final int Balance;
	
    public Account(String accNo, String accName, String accType, int balance) {
		super();
		AccNo = accNo;
		AccName = accName;
		AccType = accType;
		Balance = balance;
	}

	public String getAccNo() {
		return AccNo;
	}

	public String getAccName() {
		return AccName;
	}

	public String getAccType() {
		return AccType;
	}

	public int getBalance() {
		return Balance;
	}

	@Override
	public String toString() {
		return "Account [AccNo=" + AccNo + ", AccName=" + AccName + ", AccType=" + AccType + ", Balance=" + Balance
				+ "]";
	}

    
    
	
	
}
