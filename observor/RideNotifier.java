package observer;

import java.util.ArrayList;
import java.util.List;

public class RideNotifier implements Subject {
    private final List<Observer> drivers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) { drivers.add(o); }

    @Override
    public void removeObserver(Observer o) { drivers.remove(o); }

    @Override
    public void notifyObservers(String message) {
        for (Observer driver : drivers) driver.update(message);
    }

    public Driver assignRandomDriver() {
        int index = (int) (Math.random() * drivers.size());
        return (Driver) drivers.get(index);
    }
}

