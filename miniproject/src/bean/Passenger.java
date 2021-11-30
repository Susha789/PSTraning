package bean;

public class Passenger {
	
	private String Name, Source, Destination;
    private int BusId, Age, PassengerID;

    public Passenger(String name, String source, String destination, int busId, int age, int passengerID) {
        Name = name;
        Source = source;
        Destination = destination;
        BusId = busId;
        Age = age;
        PassengerID = passengerID;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public int getBusId() {
        return BusId;
    }

    public void setBusId(int busId) {
        BusId = busId;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getPassengerID() {
        return PassengerID;
    }

    public void setPassengerID(int passengerID) {
        PassengerID = passengerID;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "Name='" + Name + '\'' +
                ", Source='" + Source + '\'' +
                ", Destination='" + Destination + '\'' +
                ", BusId=" + BusId +
                ", Age=" + Age +
                ", PassengerID=" + PassengerID +
                '}';
    }

}
