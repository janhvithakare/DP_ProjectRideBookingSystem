import factory.*;
import proxy.*;
import observer.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Initialize drivers
        List<Driver> allDrivers = Arrays.asList(
                new Driver("Amit"),
                new Driver("Priya"),
                new Driver("Rahul")
        );

        // List of available drivers
        List<Driver> availableDrivers = new ArrayList<>(allDrivers);

        RideNotifier notifier = new RideNotifier();
        allDrivers.forEach(notifier::addObserver); // all drivers can receive ride requests

        System.out.println("=== 🚖 Ride Booking Simulation ===");

        while (true) {
            System.out.print("\nEnter rider name (or 'exit' to quit): ");
            String riderName = scanner.nextLine();
            if (riderName.equalsIgnoreCase("exit")) break;

            System.out.print("Are you a premium user? (yes/no): ");
            boolean isPremium = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.print("Enter ride type (bike/car/luxury): ");
            String type = scanner.nextLine();

            // Check if luxury ride is allowed before asking for distance
            if (type.equalsIgnoreCase("luxury") && !isPremium) {
                System.out.println("❌ Access Denied: Only premium users can book luxury rides.");
                continue; // skip to next loop
            }

            System.out.print("Enter distance (km): ");
            double distance = Double.parseDouble(scanner.nextLine());

            // Proxy handles booking
            BookingService bookingService = new BookingProxy(isPremium);
            boolean success = bookingService.bookRide(type, riderName, distance);

            if (!success) continue; // if proxy denies, skip further steps

            if (availableDrivers.isEmpty()) {
                System.out.println("No drivers available at the moment. Please wait...");
                continue;
            }

            // Step 1: Notify all available drivers of new ride request
            notifier.notifyObservers("New " + type + " ride request by " + riderName);

            // Step 2: Simulate asynchronous driver acceptance
            Thread.sleep(1500); // simulate delay for driver to accept

            // Pick a random available driver
            int index = new Random().nextInt(availableDrivers.size());
            Driver assignedDriver = availableDrivers.get(index);
            availableDrivers.remove(index);

            // Step 3: Assigned driver receives assignment notification
            assignedDriver.update("You have been assigned to pick up " + riderName + " for a " + type + " ride.");

            Thread.sleep(1000); // simulate ride start
            System.out.println("✅ Ride confirmed! " + assignedDriver.getName() + " is on the way to pick up " + riderName + ".");

            Thread.sleep(1000); // simulate ride completion
            System.out.println("🏁 Ride completed by " + assignedDriver.getName() + ".");

            // Return driver to available pool
            availableDrivers.add(assignedDriver);
        }

        System.out.println("\nExiting Ryder. Goodbye! See you next time!");
        scanner.close();
    }
}
