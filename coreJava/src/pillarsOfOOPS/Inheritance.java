package pillarsofOOPS;

//Inheritance in Java

// Base class 
class Employee {
    // Common properties and methods for all employees
    protected String name; 
    protected int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void work() {
        System.out.println(name + " is working.");
    }

    public void showDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    public void printRole() {
        System.out.println(this.name + " is " + this.getClass().getSimpleName());
    }
}

// Single Inheritance: Manager is a type of Employee
class Manager extends Employee {
    //Properties and methods specific to Manager
    private int teamSize;

    public Manager(String name, int id, int teamSize) {
        super(name, id);
        this.teamSize = teamSize;
    }

    public void conductMeeting() {
        System.out.println(name + " is conducting a meeting with " + teamSize + " team members.");
    }

    //Overriding the printRole method to specify the role of Manager
    @Override
    public void printRole() {
        System.out.println(this.name + " is " + this.getClass().getSimpleName());
    }
}

//  Developer is an Employee 
class Developer extends Employee {
    // Properties and methods specific to Developer
    public Developer(String name, int id) {
        super(name, id);
    }

    public void writeCode() {
        System.out.println(name + " is writing code.");
    }

    // Overriding the printRole method to specify the role of Developer
    @Override
    public void printRole() {
        System.out.println(this.name + " is " + this.getClass().getSimpleName());
    }
}

// Multilevel Inheritance: SeniorDeveloper is a type of Developer which is a type of Employee
//SeniorDeveloper -> Developer -> Employee
class SeniorDeveloper extends Developer {
    // Properties and methods specific to SeniorDeveloper
    public SeniorDeveloper(String name, int id) {
        super(name, id);
    }

    public void reviewCode() {
        System.out.println(name + " is reviewing code.");
    }

    // Overriding the printRole method to specify the role of SeniorDeveloper
    @Override
    public void printRole() {
        System.out.println(this.name + " is " + this.getClass().getSimpleName());
    }
}

// Hierarchical Inheritance: Intern and Developer both extend Employee
//                  Employee
//                 /        \
//           Developer      Intern
class Intern extends Employee {
    // Properties and methods specific to Intern
    private int duration;

    public Intern(String name, int id, int duration) {
        super(name, id);
        this.duration = duration;
    }

    public void learn() {
        System.out.println(name + " is learning for " + duration + " months.");
    }

    // Overriding the printRole method to specify the role of Intern
    @Override
    public void printRole() {
        System.out.println(this.name + " is " + this.getClass().getSimpleName());
    }
}

public class Inheritance {
    public static void main(String[] args) {

        Manager m = new Manager("Rohit", 45, 5);
        m.printRole();
        m.showDetails();
        m.work();
        m.conductMeeting();
        System.out.println();
        
        Developer d = new Developer("Piyush", 63);
        d.printRole();
        d.showDetails();
        d.work();
        d.writeCode();
        System.out.println();
        
        SeniorDeveloper sd = new SeniorDeveloper("Ankit", 32);
        sd.printRole();
        sd.showDetails();
        sd.work();
        sd.writeCode();
        sd.reviewCode();
        System.out.println();

        Intern i = new Intern("Chirag", 405, 6);
        i.printRole();
        i.showDetails();
        i.work();
        i.learn();

    }
}