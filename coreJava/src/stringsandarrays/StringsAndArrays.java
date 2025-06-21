package stringsandarrays;

import java.util.Arrays;

public class StringsAndArrays {
    public static void main(String[] args) {
        String url = "https://www.YouTube.com/watch?v=0f2b8c4a5d8"; 

        //String operations
        System.out.println("URL: " +url); //Print the string
        System.out.println("Length of URL: " + url.length()); // Get the length of the string
        System.out.println("is URL empty? " + url.isEmpty());  // Check if the length of string is 0
        System.out.println("URL in uppercase: " + url.toUpperCase()); // Convert to uppercase
        System.out.println("URL in lowercase: " + url.toLowerCase()); // Convert to lowercase
        System.out.println();

        //String splitting use case
        String [] parts = url.split("/"); // Split URL into parts using "/" as delimiter
        System.out.println("Split URL: " + Arrays.toString(parts));
        for(String part: parts){
            if(part.startsWith("www")){
                String domainParts [] = part.split("\\.");  // Split the domain using "." 
                //Uncomment the next line to see the domain parts
                // System.out.println("Domain parts: " + Arrays.toString(domainParts));
                for(int i=0; i<domainParts.length; i++){
                    if(i==0){
                        System.out.println("Subdomain: " + domainParts[i]); 
                    }else if (i==1){
                        System.out.println("Domain: " + domainParts[i]); 
                    } else {
                        System.out.println("Top level domain: " + domainParts[i]); 
                    }                    
                }
            }
            else if(part.length() > 0) {
                if(part.startsWith("https:")){
                    System.out.println("Protocol: " + part); 
                } else {
                    System.out.println("video id: " + part); 
                }
            }
        }
        System.out.println();

        //String operations
        String firstName = "Piyush";
        String lastName = "Tilokani";

        //String concatenation
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Full name: " + firstName + " " + lastName); // Join first and last name
        System.out.println();

        //Comparison operations
        String company1 = new String("ISS"); // Creates new object in heap
        String company2 = new String("ISS"); // Creates another new object in heap
        System.out.print("company1 == company2: "); 
        System.out.println(company1 == company2); //Prints false as 2 new String objects have been created
        System.out.println("company1.equals(company2): " + company1.equals(company2)); //Prints true as both strings have the same content

        System.out.println();
        String company3 = "ISS"; // Stored in String pool
        String company4 = "ISS"; // Refers to same object in pool
        System.out.print("company3 == company4: "); 
        System.out.println(company3 == company4); //Prints true as both are string literals and refer to the same object in the string pool
        System.out.println("company3.equals(company4): " + company3.equals(company4)); //Prints true as both strings have the same content
        System.out.println();

        //String traversal using for loop
        for(char c : firstName.toCharArray()) {
            System.out.print(c + " "); 
        }

        System.out.println();

        // Arrays and Their Operations

        // Array declaration and initialization
        int[] prices = {45, 60, 30, 90, 120};
        String[] fruits = {"Apple", "Banana", "Cherry", "Date"}; 

        // Accessing elements
        System.out.println("\nFirst price: " + prices[0]); 
        System.out.println("Last fruit: " + fruits[fruits.length - 1]); 

        // Traversing using for loop
        System.out.println("\nAll prices:");
        for (int i = 0; i < prices.length; i++) {
            System.out.println("Price " + (i + 1) + ": INR " + prices[i]); 
        }

        // Traversing using for-each loop
        System.out.println("\nAvailable fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit); 
        }

        // Sorting an array
        Arrays.sort(prices); // Sorts the original array object in ascending order
        System.out.println("\nSorted prices: " + Arrays.toString(prices)); 

        // Searching an element (binary search)
        int index = Arrays.binarySearch(prices, 60); // Binary search works only on sorted arrays
        System.out.println("Index of price 60 after sorting: " + index); // Print index of 60

        // Copying an array
        int[] copiedPrices = Arrays.copyOf(prices, prices.length); // Creates a new array pbjrct with same values
        System.out.println("\nCopied prices: " + Arrays.toString(copiedPrices)); // Print copied array
        System.out.println();
        System.out.println("prices == copiedPrices (Object comparison): " + (prices == copiedPrices)); // Prints false as they are different objects
        System.out.println("Arrays.equals(prices, copiedPrices) (Value comparison): " + Arrays.equals(prices, copiedPrices)); // Prints true as they have the same content

        // Filling an array with a specific value
        int[] discountArray = new int[5]; 
        Arrays.fill(discountArray, 10);
        System.out.println("\nDiscounts: " + Arrays.toString(discountArray)); // Print filled array
        
    }
}