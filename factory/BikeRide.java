package factory;

public class BikeRide extends Ride {
    public BikeRide(String riderName, double distance) { super(riderName, distance); }

    @Override
    public double calculateFare() { return distance * 5; }

    @Override
    public String getType() { return "Bike"; }
}
