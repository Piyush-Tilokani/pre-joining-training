package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TicketCounter {
    private int availableTickets = 5;  // Shared resource

    public volatile boolean bookingOpen = true;  // Shared flag with visibility guarantee

    // Synchronized method (Method-level locking)
    public synchronized boolean bookTickets(String name, int count) {
        if (!bookingOpen) {
            System.out.println(name + " - Booking closed.");
            return false;
        }

        if (count <= availableTickets) {
            System.out.println(name + " booked " + count + " ticket(s).");
            availableTickets -= count;

            // Synchronized block to update status of available tickets
            // This ensures that the print statement is thread-safe
            synchronized (this) {
                System.out.println("Tickets left: " + availableTickets);
            }

            if (availableTickets == 0) {
                bookingOpen = false;
            }

            return true;
        } else {
            System.out.println(name + " tried booking " + count + " ticket(s), but only " + availableTickets + " left. Booking failed.");
            return false;
        }
    }
}

class CustomerTask implements Runnable {
    private final TicketCounter counter;
    private final String customerName;
    private final int ticketsToBook;

    public CustomerTask(TicketCounter counter, String customerName, int ticketsToBook) {
        this.counter = counter;
        this.customerName = customerName;
        this.ticketsToBook = ticketsToBook;
    }

    @Override
    public void run() {
        // Local variable (Thread-safe)
        boolean success = counter.bookTickets(customerName, ticketsToBook);
        if (!success) {
            System.out.println(customerName + " could not complete the booking.");
        }
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter(); // Shared instance

        // Thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Simulating customer requests
        executor.execute(new CustomerTask(counter, "Piyush", 2));
        executor.execute(new CustomerTask(counter, "Shashwat", 1));
        executor.execute(new CustomerTask(counter, "Atharva", 2));
        executor.execute(new CustomerTask(counter, "Ajinkya", 1)); 

        executor.shutdown(); // Close the executor after use
    }
}