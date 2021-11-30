package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Passenger;
import bean.TravelManager;

public class TravelManagerDaoImpl implements TravelManagerDao {


    /*CREATE TABLE PASSENGER(
    PASSENGER_ID INT PRIMARY KEY,
    SEAT_NUMBER NUMBER(20),
    AGE NUMBER(10),
    NAME VARCHAR(25),
    SOURCE VARCHAR(25),
    DESTINATION VARCHAR(25));

    CREATE TABLE BUS(
    BUS_ID INT PRIMARY KEY,
    CAPACITY NUMBER(10),
    SOURCE VARCHAR(25),
    DESTINATION VARCHAR(25));*/



    Connection connection = null;
    PreparedStatement preparedStatement2 = null;
    PreparedStatement preparedStatement = null;
    PreparedStatement preparedStatement3 = null;
    PreparedStatement preparedStatement4 = null;
    PreparedStatement preparedStatement5 = null;
    
    
    public void connectToDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
    }

    public void closeConnectionToDatabase() throws SQLException {
        connection.close();
    }

    public ArrayList<Passenger> listAllPassenger() {
        ArrayList<Passenger> pasList = new ArrayList<>();

        try {
            connectToDatabase();

            preparedStatement = connection.prepareStatement("SELECT * FROM PASSENGER");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int busId = resultSet.getInt("SEAT_NUMBER");
                String src = resultSet.getString("SOURCE");
                String dest = resultSet.getString("DESTINATION");
                int pid = resultSet.getInt("PASSENGER_ID");
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                Passenger pes = new Passenger(name, src, dest, busId, age, pid);
                pasList.add(pes);
            }

        } catch (ClassNotFoundException | SQLException c) {
            c.printStackTrace();
        } finally {
            try {
                closeConnectionToDatabase();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return pasList;
    }

    @Override
    public ArrayList<TravelManager> listAllBus() {

        ArrayList<TravelManager> busList = new ArrayList<>();

        try {
            connectToDatabase();

            preparedStatement = connection.prepareStatement("SELECT * FROM BUS");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                TravelManager bus = new TravelManager(
                        resultSet.getInt("BUS_ID"),
                        resultSet.getInt("CAPACITY"),
                        resultSet.getString("SOURCE"),
                        resultSet.getString("DESTINATION")

                );
                busList.add(bus);
            }
        } catch (ClassNotFoundException | SQLException c) {
            c.printStackTrace();
        } finally {
            try {
                closeConnectionToDatabase();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return busList;
    }

    @Override
    public boolean checkAvailability(String source, String destination) {
        ArrayList<String> src1 = new ArrayList<>();
        ArrayList<String> dest1 = new ArrayList<>();
        try {
            boolean src2 = false;
            boolean dest2 = false;

            connectToDatabase();

            preparedStatement = connection.prepareStatement("SELECT SOURCE, DESTINATION FROM BUS");
            preparedStatement2 = connection.prepareStatement("SELECT CAPACITY FROM BUS WHERE SOURCE = ? AND DESTINATION = ?");
            preparedStatement2.setString(2, destination);
            preparedStatement2.setString(1, source);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String src = resultSet.getString("SOURCE");
                String dest = resultSet.getString("DESTINATION");
                dest1.add(dest);
                src1.add(src);
            }

            for (String s : src1) {
                String s1 = s.toLowerCase();
                String s2 = source.toLowerCase();
                boolean n = s1.matches(s2);
                if (n) {
                    src2 = true;
                    break;
                }

            }
            for (String d : dest1) {
                String s1 = d.toLowerCase();
                String s2 = destination.toLowerCase();
                boolean n = s1.matches(s2);
                if (n) {
                    dest2 = true;
                    break;
                }
            }

            int cap1 = 0;
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            if (src2 && dest2) {

                if (resultSet2.next()) {
                    cap1 = resultSet2.getInt("CAPACITY");
                }
            }
            if (cap1 > 0)
                return true;
        } catch (ClassNotFoundException | SQLException c) {
            c.printStackTrace();
        } finally {
            try {
                closeConnectionToDatabase();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public int addPassenger(Passenger passenger) {
        try {
            connectToDatabase();
            preparedStatement = connection.prepareStatement("INSERT INTO PASSENGER VALUES(?,?,?,?,?,?)");
            preparedStatement.setInt(1, passenger.getPassengerID());
            preparedStatement.setString(5, passenger.getSource());
            preparedStatement.setString(6, passenger.getDestination());
            preparedStatement.setInt(3, passenger.getAge());
            preparedStatement.setString(4, passenger.getName());
           
           
            preparedStatement3 = connection.prepareStatement("SELECT BUS_ID FROM BUS WHERE SOURCE = ? AND DESTINATION = ?");
            preparedStatement3.setString(1,passenger.getSource());
            preparedStatement3.setString(2,passenger.getDestination());
            ResultSet resultSet3 = preparedStatement3.executeQuery();
            
           int bus_id = 0;
            
            if (resultSet3.next()) {
            	bus_id = resultSet3.getInt("BUS_ID");
            }
            
            preparedStatement.setInt(2, bus_id);
            int rows = preparedStatement.executeUpdate();
            
            
            preparedStatement2 = connection.prepareStatement("SELECT CAPACITY FROM BUS WHERE BUS_ID = ?");
            preparedStatement2.setInt(1, bus_id);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            
           
            int capacity = 0;
            
            if (resultSet2.next()) {
                capacity = resultSet2.getInt("CAPACITY");
            }
            
            capacity = capacity - 1;
            
            System.out.println("Updated avaliable seats : " + capacity + " in the bus with the id : "+ bus_id);

            preparedStatement5 = connection.prepareStatement("UPDATE BUS SET CAPACITY = ? WHERE BUS_ID = ?");
            preparedStatement5.setInt(1, capacity);
            preparedStatement5.setInt(2, bus_id);

            return preparedStatement5.executeUpdate();


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int getBusId(String src, String dest) {
        int busId = 0;
        try {
            connectToDatabase();
            preparedStatement4 = connection.prepareStatement("SELECT BUS_ID FROM BUS WHERE SOURCE = ? AND DESTINATION=?");
            preparedStatement4.setString(1, src);
            preparedStatement4.setString(2, dest);
            ResultSet resultSet = preparedStatement4.executeQuery();
            if (resultSet.next()) {
                busId = resultSet.getInt("BUS_ID");
            }
            return busId;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}