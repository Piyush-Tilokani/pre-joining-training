package exceptionHandling;

// Custom exception class for invalid marks
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

// Student class with encapsulated marks
class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public void setMarks(int newMarks) throws InvalidMarksException {
        if (newMarks < 0) { //If newMarks is negative, throw custom exception
            throw new InvalidMarksException("Marks cannot be negative, newMarks value passed: " + newMarks);
        }
        this.marks = newMarks;
        System.out.println("Marks updated successfully to: " + marks);
    }

    public void display() {
        System.out.println("Student: " + name + ", Marks: " + marks);
    }
}

public class CustomException {
    public static void main(String[] args) {
        Student s1 = new Student("Piyush", 85);
        s1.display();
        System.out.println();

        try {
            s1.setMarks(95);  // Valid update
            s1.setMarks(-10); // Invalid update, triggers custom exception
        } catch (InvalidMarksException e) {
            System.out.println("\nError: " + e.getMessage());
            System.out.println();
        }

        //The last marks update will not be successful due to the exception
        s1.display();  
    }
}