package factory;

public class RideFactory {
    public static Ride createRide(String type, String riderName, double distance) {
        return switch (type.toLowerCase()) {
            case "bike" -> new BikeRide(riderName, distance);
            case "car" -> new CarRide(riderName, distance);
            case "luxury" -> new LuxuryRide(riderName, distance);
            default -> throw new IllegalArgumentException("Invalid ride type");
        };
    }
}

