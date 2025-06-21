package loopanddecisionmaking;

public class LoopAndDecision{
    public static void main(String[] args) {

        //Conditional statements for decision making
        
        int age = 20;
        //If else for decision making
        if (age >= 18) {
            System.out.println("You are eligible to vote.\n");
        } else {
            System.out.println("You must be at least 18 to vote.\n");
        }

        
        String day = "Tuesday";
        //Switch case for decision on multiple conditions
        switch (day) {
            case "Monday":
                System.out.println("Start of the work week.\n");
                break;
            case "Friday":
                System.out.println("Almost weekend!\n");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println("Weekend vibes!\n");
                break;
            default:
                System.out.println("Midweek grind: " + day+"\n");
        }

        //Loops for iteration

        //For loop
        for (int i = 1; i <= 5; i++) {
            System.out.println("For Loop Value: " + i);
        }
        System.out.println();
        
        //Enhanced For loop (for-each)
        String[] fruits = {"Apple", "Banana", "Cherry"};
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
        System.out.println();

        // While loop
        int counter = 5;
        while (counter > 0) {
            System.out.println("While Loop Value: " + counter);
            counter--;
        }
        System.out.println();

        //Do While loop (executes at least once)
        int num = 1;
        do {
            System.out.println("Do-While Value: " + num);
            num++;
        } while (num <= 3);
        System.out.println();

        // Loop control statements
        for (int i = 1; i <= 10; i++) {
            if (i == 5) { //If statement to control loop execution
                System.out.println("Breaking loop at i = " + i);
                break; // exits loop
            }
            System.out.println("i = " + i);
        }
        System.out.println();
        
        for (int i = 1; i <= 5; i++) {
            if (i == 3) { // If statement to control loop execution
                System.out.println("Skipping i = " + i);
                continue; // skips this iteration
            }
            System.out.println("i = " + i);
        }
    }
}