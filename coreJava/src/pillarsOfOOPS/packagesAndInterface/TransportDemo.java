package pillarsofOOPS.packagesandinterface;

import pillarsofOOPS.packagesandinterface.bike.Bike;
import pillarsofOOPS.packagesandinterface.bus.Bus;
import pillarsofOOPS.packagesandinterface.car.Car;
import pillarsofOOPS.packagesandinterface.interfaces.Transport;

public class TransportDemo {
    public static void main(String[] args) {
        Transport bike = new Bike(); // Using the Bike class from the bike package
        Transport car = new Car(); // Using the Car class from the car package
        Transport bus = new Bus(); // Using the Bus class from the bus package

        // implementation details of each vehicle are hidden from the user using the Transport interface
        showTransportInfo("Bike", bike);
        showTransportInfo("Car", car);
        showTransportInfo("Bus", bus);
    }

    // Method to display transport information
    static void showTransportInfo(String vehicleType, Transport vehicle) {
        System.out.println("\n--- " + vehicleType + " Info ---");
        vehicle.start();
        System.out.println("Passenger Capacity: " + vehicle.getPassengerCapacity());
        vehicle.stop();
    }
}
