package pillarsOfOOPS;

// Encapsulation: private fields and public methods
class Student {
    // Private fields - hidden from outside
    private String name;
    private int rollNumber;
    private int marks;

    // Constructor
    public Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Public getter methods
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int getMarks() {
        return marks;
    }

    // Public setter method to update marks
    public void setMarks(int newMarks) {
        if (newMarks >= 0 && newMarks <= 100) {
            marks = newMarks;
            System.out.println("Marks updated to: " + marks);
        } else {
            System.out.println("Invalid marks. Must be between 0 and 100.");
        }
    }

    // Method to display student details
    public void printReportCard() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}


// Abstraction
abstract class SmartDevice {
    // Abstract methods to be implemented by subclasses
    abstract void turnOn();
    abstract void turnOff();

    // Concrete method to check device status (Can be overridden by subclasses)
    void checkStatus() {
        System.out.println("Device is online.");
    }
}

// Subclass 1: Smart Light
class SmartLight extends SmartDevice {
    @Override
    void turnOn() {
        System.out.println("Smart Light is turned ON.");
    }

    @Override
    void turnOff() {
        System.out.println("Smart Light is turned OFF.");
    }
}

// Subclass 2: Smart Fan
class SmartFan extends SmartDevice {
    @Override
    void turnOn() {
        System.out.println("Smart Fan is SPINNING now.");
    }

    @Override
    void turnOff() {
        System.out.println("Smart Fan STOPPED.");
    }

    // Overriding the concrete method to provide specific status
    @Override
    void checkStatus() {
        System.out.println("Smart Fan is operational.");
    }
}

public class AbstractionAndEncapsulation {
    public static void main(String[] args) {
        System.out.println("------------------- Encapsulation -------------------");
        Student student = new Student("Piyush", 63, 88);
        
        student.printReportCard();
        
        System.out.println("\nTrying to update marks...");
        student.setMarks(95);   // Valid update
        
        System.out.println("\nTrying to set invalid marks...");
        student.setMarks(120);  // Invalid update
        
        System.out.println("\nFinal Report:");
        student.printReportCard();
        
        // --- Abstraction Demo: Smart Devices ---
        System.out.println("\n------------------- Abstraction -------------------");
        SmartDevice light = new SmartLight();
        SmartDevice fan = new SmartFan();
        
        light.checkStatus();
        light.turnOn();
        light.turnOff();
        System.out.println();

        fan.checkStatus();
        fan.turnOn();
        fan.turnOff();
    }
}