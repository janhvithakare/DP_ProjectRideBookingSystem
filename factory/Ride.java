package factory;

public abstract class Ride {
    protected String riderName;
    protected double distance;

    public Ride(String riderName, double distance) {
        this.riderName = riderName;
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getType();
}

