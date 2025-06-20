package collections;


import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Override equals and hashCode for proper Set/Map operations
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

    @Override
    public String toString() {
        return "[" + id + ", " + name + ", INR " + salary + "]";
    }
}

public class CollectionsCustom {
    public static void main(String[] args) {
        // List of Employees
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Piyush", 60000));
        employeeList.add(new Employee(2, "Atharva", 55000));
        employeeList.add(new Employee(3, "Shashwat", 58000));
        System.out.println("Employee List:");
        System.out.println(employeeList); //Easy printing due to overridden toString() method

        // Set of Employees
        Set<Employee> employeeSet = new HashSet<>(employeeList);
        employeeSet.add(new Employee(4, "Atharva", 55000)); // Duplicate ID, won't be added
        System.out.println("\nEmployee Set:");
        System.out.println(employeeSet); // Set will not allow duplicates based on equals() and hashCode()

        // Mapping Employee to themselves
        Map<Employee, Employee> employeeMap = new HashMap<>();
        for (Employee emp : employeeList) {
            employeeMap.put(emp, emp); // Mapping employee to themselves
        }

        System.out.println("\nEmployee Map: "+ employeeMap); // Easy printing due to overridden toString() method

        System.out.println("\nEmployee Map (Key -> Value):");
        for (Map.Entry<Employee, Employee> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}