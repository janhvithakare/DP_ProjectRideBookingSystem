package observer;

public class Driver implements Observer {
    private final String name;

    public Driver(String name) { this.name = name; }

    @Override
    public void update(String message) {
        System.out.println("🚗 " + name + " received notification: " + message);
    }

    public String getName() { return name; }
}

