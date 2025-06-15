package packagesAndInterface.bus;

import packagesAndInterface.interfaces.Transport;

// Bus class implementing the Transport interface and providing its own implementation
public class Bus implements Transport {
    @Override
    public void start() {
        System.out.println("Bus started.");
    }

    @Override
    public void stop() {
        System.out.println("Bus stopped.");
    }

    @Override
    public int getPassengerCapacity() {
        return 50;
    }
}
