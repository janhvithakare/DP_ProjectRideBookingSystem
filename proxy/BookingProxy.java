package proxy;

public class BookingProxy implements BookingService {
    private final RealBookingService realService;
    private final boolean isPremiumUser;

    public BookingProxy(boolean isPremiumUser) {
        this.realService = new RealBookingService();
        this.isPremiumUser = isPremiumUser;
    }

    @Override
    public boolean bookRide(String type, String riderName, double distance) {
        if (type.equalsIgnoreCase("luxury") && !isPremiumUser) {
            System.out.println("❌ Access Denied: Only premium users can book luxury rides.");
            return false;  // Deny booking
        }
        return realService.bookRide(type, riderName, distance);
    }
}
