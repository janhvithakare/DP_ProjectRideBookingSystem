package factory;

public class CarRide extends Ride {
    public CarRide(String riderName, double distance) { super(riderName, distance); }

    @Override
    public double calculateFare() { return distance * 10; }

    @Override
    public String getType() { return "Car"; }
}
