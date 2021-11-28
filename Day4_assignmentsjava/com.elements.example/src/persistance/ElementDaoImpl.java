package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Element;

public class ElementDaoImpl implements ElementDao {
	
	
	@Override
	public ArrayList<Element> getAllElements() {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Element> elementList = new ArrayList<Element>();
		
		
		try {
			
//			1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
//			2. Query
			preparedStatement=connection.prepareStatement("SELECT * FROM ELEMENT");
			
			ResultSet resultSet= preparedStatement.executeQuery();

//			3.Process Result
			while(resultSet.next()) {
								
				Element element = new Element(
						resultSet.getInt("ATOMIC_NUMBER"),
						resultSet.getString("ATOMIC_WEIGHT"),
						resultSet.getString("NAME"),
						resultSet.getString("CHEMICAL_SYMBOL")
					);
				
				elementList.add(element);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
//				4. Close
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		return elementList;
	}

	@Override
	public Element getElementByAtomicNumber(int atomicNumber) {
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		Element element=null;
		try {
//			1. Connect
//			1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
//			2. Query
			preparedStatement=connection.prepareStatement("SELECT * FROM ELEMENT WHERE ATOMIC_NUMBER = ? ");
			
			preparedStatement.setInt(1, atomicNumber);
			
			ResultSet resultSet= preparedStatement.executeQuery();

//			3.Process Result
			
			if(resultSet.next()) {
				
				element = new Element(
						resultSet.getInt("ATOMIC_NUMBER"),
						resultSet.getString("ATOMIC_WEIGHT"),
						resultSet.getString("NAME"),
						resultSet.getString("CHEMICAL_SYMBOL")
					);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
//				4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return element;
	}

	@Override
	public boolean addElement(Element element) {

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
//			1. Connect
//			1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
//			2. Query
			preparedStatement=connection.prepareStatement("INSERT INTO ELEMENT VALUES(?,?,?,?)");
			
			preparedStatement.setInt(1, element.getAtomicNumber());
			preparedStatement.setString(2, element.getAtomicWeight());
			preparedStatement.setString(3, element.getName());
			preparedStatement.setString(4, element.getChemicalSymbol());
			
			
			int rows= preparedStatement.executeUpdate();

//			3.Process Result
			if(rows == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
//				4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean updateElementByAtomicNumber(int atomicNumber, String atomicWeight) {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
//			1. Connect
//			1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
//			2. Query
			preparedStatement=connection.prepareStatement("UPDATE ELEMENT SET ATOMIC_WEIGHT = ? WHERE ATOMIC_NUMBER = ?");
			
			preparedStatement.setString(1, atomicWeight);
			preparedStatement.setInt(1, atomicNumber);
			
			int rows= preparedStatement.executeUpdate();

//			3.Process Result
			if(rows == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
//				4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean removeElementByAtomicNumber(int atomicNumber) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
//			1. Connect
//			1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
//			2. Query
			preparedStatement=connection.prepareStatement("DELETE FROM ELEMENT WHERE ATOMIC_NUMBER = ?");
			
			preparedStatement.setInt(1, atomicNumber);

			int rows= preparedStatement.executeUpdate();

//			3.Process Result
			if(rows == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
//				4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
		
	}

}
