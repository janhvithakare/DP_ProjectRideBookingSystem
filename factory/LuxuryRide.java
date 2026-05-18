package factory;

public class LuxuryRide extends Ride {
    public LuxuryRide(String riderName, double distance) { super(riderName, distance); }

    @Override
    public double calculateFare() { return distance * 20; }

    @Override
    public String getType() { return "Luxury"; }
}
