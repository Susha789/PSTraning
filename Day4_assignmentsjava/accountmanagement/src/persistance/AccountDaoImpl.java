package persistance;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Account;

public class AccountDaoImpl implements AccountDao {

	@Override
	public ArrayList<Account> getAllAccount() {
		


        Connection connection = null;
        PreparedStatement preparedStatement;
        ArrayList<Account> accountList = new ArrayList<>();

        try {
//			1.1 Register Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
//			1.2 Connect to Database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//			2. Query
            preparedStatement = connection.prepareStatement("SELECT * FROM Account");

            ResultSet resultSet = preparedStatement.executeQuery();

//			3.Process Result
            while (resultSet.next()) {
                Account account = new Account(
                        resultSet.getString("AccountNumber"),
                        resultSet.getString("AccountName"),
                        resultSet.getString("AccountType"),
                        resultSet.getInt("Balance")
                );
                accountList.add(account);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try { 	// 4. Close
            	
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return accountList;

		
		
	}

	@Override
	public Account getAccountByAccountNumber(String accNo) {
		Connection connection = null;
        PreparedStatement preparedStatement;
        Account account = null;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

            preparedStatement = connection.prepareStatement("SELECT * FROM Account WHERE AccountNumber = ?");

            preparedStatement.setString(1, accNo);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                account = new Account(
                		 resultSet.getString("AccountNumber"),
                         resultSet.getString("AccountName"),
                         resultSet.getString("AccountType"),
                         resultSet.getInt("Balance")
                );

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return account;

	}

	@Override
	public boolean addAccount(Account account) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

            preparedStatement = connection.prepareStatement("INSERT INTO Account VALUES(?,?,?,?)");

            preparedStatement.setString(1, account.getAccNo());
            preparedStatement.setString(2, account.getAccName());
            preparedStatement.setString(3, account.getAccType());
            preparedStatement.setInt(4, account.getBalance());


            return preparedStatement.executeUpdate() == 1;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

		return false;
	}

	@Override
	public boolean deleteAccount(String accNo) {


        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

            preparedStatement = connection.prepareStatement("DELETE FROM Account WHERE AccountNumber = ?");

            preparedStatement.setString(1, accNo);

            return preparedStatement.executeUpdate()==1;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;

	}

	@Override
	public boolean updateAccountByAccNo(String num, String name) {

        Connection connection = null;
        PreparedStatement preparedStatement;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

            preparedStatement = connection.prepareStatement("UPDATE ACCOUNT SET Account = ? WHERE AccountNumber = ?");

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, num);

            return preparedStatement.executeUpdate()==1;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

       

		return false;
	}

	@Override
	public boolean Transaction(int balance, String accOne, String accTwo) {

        Connection connection = null;
        PreparedStatement preparedStatement;
        PreparedStatement preparedStatement2, preparedStatement3, preparedStatement4, preparedStatement5,preparedStatement6;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
            
            
            preparedStatement5 = connection.prepareStatement("SELECT Balance FROM Account WHERE AccountNumber = ?");
        	preparedStatement6 = connection.prepareStatement("SELECT Balance FROM Account WHERE AccountNumber = ?");
        	
        	preparedStatement5.setString(1, accOne);
        	preparedStatement6.setString(1, accTwo);
            
            ResultSet resultSet5 = preparedStatement5.executeQuery();
            ResultSet resultSet6 = preparedStatement6.executeQuery();
            
            System.out.println("----------Before Transaction---------\n");
            
            if (resultSet5.next()) {
                System.out.println(" Balance in account " + accOne + " is : " + resultSet5.getInt("Balance") + "\n");
                
            }
            
            if(resultSet6.next()) {
            	System.out.println(" Balance in account " + accTwo + " is : " + resultSet6.getInt("Balance"));
            }
            

            preparedStatement = connection.prepareStatement("UPDATE Account SET Balance = Balance - ? WHERE AccountNumber = ?");
            preparedStatement2 = connection.prepareStatement("UPDATE Account SET Balance = Balance + ? WHERE AccountNumber = ?");

            preparedStatement.setInt(1, balance);
            preparedStatement.setString(2, accOne);

            preparedStatement2.setInt(1, balance);
            preparedStatement2.setString(2, accTwo);
            
            if(preparedStatement.executeUpdate()==1 && preparedStatement2.executeUpdate() == 1) {
            	
            	preparedStatement3 = connection.prepareStatement("SELECT Balance FROM Account WHERE AccountNumber = ?");
            	preparedStatement4 = connection.prepareStatement("SELECT Balance FROM Account WHERE AccountNumber = ?");
            	
            	preparedStatement3.setString(1, accOne);
                preparedStatement4.setString(1, accTwo);
                
                ResultSet resultSet3 = preparedStatement3.executeQuery();
                ResultSet resultSet4 = preparedStatement4.executeQuery();
                
                System.out.println("----------After Transaction---------\n");
                
                if (resultSet3.next()) {
                    System.out.println("Updated balance in account " + accOne + " is : " + resultSet3.getInt("Balance") + "\n");
                    
                }
                
                if(resultSet4.next()) {
                	System.out.println("Updated balance in account " + accTwo + " is : " + resultSet4.getInt("Balance"));
                }
                
              
            	
            	return true;
            	
            } else {
            	
            	return false;
            	
            }
            
          

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    
	}

}