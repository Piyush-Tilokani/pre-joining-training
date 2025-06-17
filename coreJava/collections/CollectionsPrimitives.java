import java.util.*;

public class CollectionsPrimitives {
    public static void main(String[] args) {
        
        // List of ordered student names (duplicates allowed)
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Piyush");
        studentNames.add("Shashwat");
        studentNames.add("Atharva");
        studentNames.add("Ajinkya");
        studentNames.add("Atharva"); // Duplicate name

        System.out.println("Student Names (List): " + studentNames);
        System.out.println("Student at index 1: " + studentNames.get(1));

        studentNames.remove("Ajinkya"); // Remove by value
        System.out.println("After removing 'Ajinkya': " + studentNames);

        Collections.sort(studentNames); // Sort alphabetically
        System.out.println("Sorted Student Names: " + studentNames);

        System.out.println("Does the list contain 'Shashwat'? " + studentNames.contains("Shashwat"));
        System.out.println("Size of student list: " + studentNames.size());

        studentNames.clear(); // Remove all elements
        System.out.println("Is student list empty after clear? " + studentNames.isEmpty());
 
        //Set of unique roll numbers
        Set<Integer> rollNumbers = new HashSet<>();
        rollNumbers.add(101);
        rollNumbers.add(102);
        rollNumbers.add(103);
        rollNumbers.add(101); // Duplicate ignored

        System.out.println("\nUnique Roll Numbers (Set): " + rollNumbers);

        rollNumbers.remove(102);
        System.out.println("After removing 102: " + rollNumbers);

        System.out.println("Contains 103? " + rollNumbers.contains(103));
        System.out.println("Set size: " + rollNumbers.size());

        // Traversing Set
        for (int roll : rollNumbers) {
            System.out.println("Processing Roll Number: " + roll);
        }

        // Map of student name -> marks
        Map<String, Integer> studentMarks = new HashMap<>();
        studentMarks.put("Piyush", 89);
        studentMarks.put("Shashwat", 95);
        studentMarks.put("Atharva", 92);
        studentMarks.put("Ajinkya", 85);

        System.out.println("\nStudent Marks (Map): " + studentMarks);
        System.out.println("Marks of Atharva: " + studentMarks.get("Atharva"));

        studentMarks.remove("Ajinkya");
        System.out.println("After removing 'Ajinkya': " + studentMarks);

        System.out.println("Contains student 'Piyush'? " + studentMarks.containsKey("Piyush"));
        System.out.println("Contains marks 95? " + studentMarks.containsValue(95));

        // Iterating over map using keySet
        System.out.println("\nStudent list:");
        for (String name : studentMarks.keySet()) {
            System.out.println(name + " scored " + studentMarks.get(name));
        }

        // Iterating over map using entrySet
        System.out.println("\nStudent -> Marks:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " marks");
        }

        // Updating marks
        studentMarks.replace("Piyush", 99);
        System.out.println("\nAfter updating Piyush's marks: " + studentMarks);
    }
}