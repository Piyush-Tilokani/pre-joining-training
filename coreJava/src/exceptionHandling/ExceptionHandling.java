package exceptionHandling;

import java.io.*;
import java.util.Scanner;


public class ExceptionHandling {

    // Method to demonstrate checked exception with throws
    public static void readFile(String fileName) throws FileNotFoundException {
        if (!fileName.equals("src/exceptionHandling/data.txt")) {
            throw new FileNotFoundException("File " + fileName + " not found!");
        }
        
        System.out.println("Reading file: " + fileName);
        // Printing file content (assuming the file exists)

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    // Method to demonstrate unchecked exception with throw
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }

    public static void main(String[] args) {

        //Excception heierarchy 
        /*
         * Throwable (superclass of all exceptions and errors)
         * ├── Error (rarely caught) 
         * └── Exception (can be caught)
         *     ├── Checked Exceptions (e.g., IOException, SQLException) (must be declared or caught)
         *     └── Unchecked Exceptions (RuntimeException and its subclasses) (do not need to be declared or caught)
         */
        
        // Handling unchecked exception
        try {
            int result = divide(10, 0); // This will throw ArithmeticException
            System.out.println("Division Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Division operation complete.\n");
        }

        // Handling checked exception
        try {
            readFile("invalid.txt"); // Throws FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("Caught a FileNotFoundException: " + e.getMessage());
        } finally {
            System.out.println("File read attempt complete.\n");
        }

         try {
            readFile("src/exceptionHandling/data.txt"); 
        } catch (FileNotFoundException e) {
            System.out.println("Caught a FileNotFoundException: " + e.getMessage());
        } finally {
            System.out.println("File read attempt complete.\n");
        }

        // Using multiple catch blocks
        try {
            String s = null;
            System.out.println(s.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught General Exception: " + e.getMessage());
        }
        
        try {
            String s = null;
            System.out.println(s.length()); // NullPointerException
        }catch (Exception e) { //Any type of exception can be caught here
            System.out.println("Caught General Exception: " + e.getMessage());
        }
        // Cannot be placed after general Exception catch block as it is unreachable
        // Uncomment the below cathc block to see the compilation error
        //  catch (NullPointerException e) { 
        //     System.out.println("Caught NullPointerException: " + e.getMessage());
        // } 

        try {
            int[] numbers = {10, 20, 30};
            System.out.println("Accessing 4th element: " + numbers[3]); // index 3 is invalid
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        System.out.println("\nProgram execution continues...");

    }
}