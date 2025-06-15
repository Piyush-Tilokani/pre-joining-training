package packagesAndInterface.bike;

import packagesAndInterface.interfaces.Transport;

// Bike class implementing the Transport interface and providing its own implementation
public class Bike implements Transport {
    @Override
    public void start() {
        System.out.println("Bike started.");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped.");
    }

    @Override
    public int getPassengerCapacity() {
        return 2;
    }
}
