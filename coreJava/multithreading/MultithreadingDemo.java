import java.util.concurrent.*;

// Shared class to demonstrate synchronization and volatile
class Counter {
    private int count = 0;
    private final Object lock = new Object();

    // Method-level synchronization
    public synchronized void increment() {
        count++;
    }

    // Block-level synchronization
    public void decrement() {
        synchronized (lock) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}

// Volatile example: Visibility of changes across threads
class VolatileExample implements Runnable {
    private volatile boolean running = true;

    public void run() {
        System.out.println("Volatile thread started");
        while (running) {
            // do nothing
        }
        System.out.println("Volatile thread stopped");
    }

    public void stop() {
        running = false;
    }
}

// Runnable task for thread pool
class PrintTask implements Runnable {
    private final int number;

    public PrintTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Task #" + number + " executed by " + Thread.currentThread().getName());
    }
}

// Demonstrate thread safety (local vs. instance variable)
class ThreadSafeExample implements Runnable {
    private int instanceCounter = 0;

    @Override
    public void run() {
        // Local variable is thread-safe
        int localCounter = 0;
        for (int i = 0; i < 5; i++) {
            localCounter++;        // thread-safe
            instanceCounter++;     // NOT thread-safe
        }
        System.out.println(Thread.currentThread().getName() + " - Local: " + localCounter + ", Instance: " + instanceCounter);
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Basic Thread Creation ===");
        Thread t1 = new Thread(() -> System.out.println("Thread using lambda: " + Thread.currentThread().getName()));
        t1.start(); // start the thread
        t1.join(); // wait for the thread to finish

        System.out.println("\n=== Volatile Example ===");
        VolatileExample ve = new VolatileExample();
        Thread vt = new Thread(ve);
        vt.start();
        Thread.sleep(1000);  // simulate delay
        ve.stop();
        vt.join();

        System.out.println("\n=== Synchronized Counter Example ===");
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) counter.increment();
            for (int i = 0; i < 500; i++) counter.decrement();
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Final Counter Value: " + counter.getCount());

        System.out.println("\n=== Thread Pool Executor ===");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            executor.execute(new PrintTask(i));
        }
        executor.shutdown();

        System.out.println("\n=== Thread Safety: Local vs Instance Variable ===");
        ThreadSafeExample tse1 = new ThreadSafeExample();
        ThreadSafeExample tse2 = new ThreadSafeExample();
        Thread t3 = new Thread(tse1, "Thread-A");
        Thread t4 = new Thread(tse2, "Thread-B");
        t3.start();
        t4.start();
        t3.join();
        t4.join();
    }
}