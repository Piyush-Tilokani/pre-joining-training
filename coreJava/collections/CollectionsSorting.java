import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Override compareTo method of Comparable interface to sort employees by ID (ascending)
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    // For Set/Map uniqueness based on ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return id == e.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Override toString for easy pretty printing of Employee objects
    @Override
    public String toString() {
        return "[" + id + ", " + name + ", INR " + salary + "]";
    }
}

// Custom comparator for sorting by Name (ascending)
class NameAscendingComparator implements Comparator<Employee> {
    //Overridiung the compare method of Comparator interface to sort employees by Name (ascending)
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.name.compareTo(e2.name);
    }
}

// Custom comparator for sorting by Salary (ascending)
class SalaryAscendingComparator implements Comparator<Employee> {
    //Overridiung the compare method of Comparator interface to sort employees by Salary (ascending)
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.salary, e2.salary);
    }
}

public class CollectionsSorting {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(3, "Shashwat", 58000));
        employeeList.add(new Employee(1, "Piyush", 60000));
        employeeList.add(new Employee(2, "Atharva", 55000));
        employeeList.add(new Employee(4, "Ajinkya", 59000));

        System.out.println("Original Employee List:");
        System.out.println(employeeList);

        // 1. Sort by ID (ascending - Comparable)
        Collections.sort(employeeList);
        System.out.println("\nSorted by Employee ID (Ascending):");
        System.out.println(employeeList);

        // 2. Sort by Name (Ascending - using Comparator)
        Collections.sort(employeeList, new NameAscendingComparator());
        System.out.println("\nSorted by Name (Ascending):");
        System.out.println(employeeList);

        // 3. Sort by Salary (Ascending - using Comparator)
        Collections.sort(employeeList, new SalaryAscendingComparator());
        System.out.println("\nSorted by Salary (Ascending):");
        System.out.println(employeeList);

        // Example of sorting a list of Primitive data type (integer)
        List<Integer> marksList = new ArrayList<>();
        marksList.add(85);
        marksList.add(92);
        marksList.add(76);
        marksList.add(88);
        marksList.add(91);

        System.out.println("\nOriginal Marks List: " + marksList);

        // Sort in ascending order
        Collections.sort(marksList);
        System.out.println("\nSorted Marks (Ascending): " + marksList);

        // Sort in descending order
        Collections.sort(marksList, Comparator.reverseOrder());
        System.out.println("\nSorted Marks (Descending): " + marksList);

        // Example of sorting a list of String
        List<String> stringList = new ArrayList<>();    
        stringList.add("Shashwat");
        stringList.add("Atharva");
        stringList.add("Piyush");
        stringList.add("Ajinkya");
        System.out.println("\nOriginal String List: " + stringList);  

        // Sort in ascending order
        Collections.sort(stringList);   
        System.out.println("\nSorted String List (Ascending): " + stringList);

        // Sort in descending order
        Collections.sort(stringList, Comparator.reverseOrder());    
        System.out.println("\nSorted String List (Descending): " + stringList);
    }
}