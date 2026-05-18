package proxy;

import factory.Ride;
import factory.RideFactory;

public class RealBookingService implements BookingService {
    @Override
    public boolean bookRide(String type, String riderName, double distance) {
        Ride ride = RideFactory.createRide(type, riderName, distance);
        System.out.println("✅ " + riderName + " booked a " + type + " ride. Fare: ₹" + ride.calculateFare());
        return true;  // Indicate booking success
    }
}
