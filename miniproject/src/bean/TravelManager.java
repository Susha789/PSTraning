package bean;

public class TravelManager {
	
	private int id, CapCapacity;
    private String Source, Destination;

    public TravelManager(int id, int capCapacity, String source, String destination) {
        this.id = id;
        CapCapacity = capCapacity;
        Source = source;
        Destination = destination;
    }

    @Override
    public String toString() {
        return "Traveler{" +
                "id='" + id + '\'' +
                ", CapCapacity='" + CapCapacity + '\'' +
                ", Source='" + Source + '\'' +
                ", Destination='" + Destination + '\'' +
                '}';
    }

}
