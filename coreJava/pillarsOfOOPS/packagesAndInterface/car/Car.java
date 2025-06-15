package packagesAndInterface.car;

import packagesAndInterface.interfaces.Transport;

// Car class implementing the Transport interface and providing its own implementation
public class Car implements Transport {
    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }

    @Override
    public int getPassengerCapacity() {
        return 5;
    }
}
