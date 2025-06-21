package datatypeandmodifiers;


// Class representing a Grocery Item in a store
class GroceryItem {

    //Access Modifiers

    // Private: accessible only within this class
    private String name;               
    private double price;              

    // Default (no modifier): accessible within the same package
    int quantity;                 

    // Protected: accessible within same package or subclasses
    protected String supplierName = "Generic Supplier";

    // Public: accessible from anywhere
    public static String storeName = "Walmart";  // Static shared variable
    public final String category;                // Final constant

    // Default constructor
    public GroceryItem() {
        this.name = "Unnamed Item";
        this.price = 0.0;
        this.quantity = 0;
        this.category = "General";
    }

    // Parameterized constructor
    public GroceryItem(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0)
            this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    // Final method - cannot be overridden
    public final void printLabel() {
        System.out.println("Label: " + name + " - INR " + price + " [" + category + "]");
    }

    // Public method to add stock
    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println(amount + " units added. New quantity: " + quantity);
        } else {
            System.out.println("Invalid restock amount.");
        }
    }

    // Public method to sell item
    public void sell(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            System.out.println(amount + " units sold. Remaining: " + quantity);
        } else if (amount <= 0) {
            System.out.println("Invalid quantity to sell.");
        } else {
            System.out.println("Insufficient stock to sell " + amount + " units. Available: " + quantity);
        }
    }

    // Public method to display item details
    public void displayDetails() {
        System.out.println("--- Item Details ---");
        System.out.println("Store: " + storeName);                 
        System.out.println("Item: " + name);
        System.out.println("Price: INR " + price);
        System.out.println("Quantity in stock: " + quantity);
        System.out.println("Category: " + category);
        System.out.println("Supplier: " + supplierName);           
    }
}


// Main class 
public class DatatypeAndModifiers {
    public static void main(String[] args) {

        // Create item using default constructor
        System.out.println("--------- Item 1 ---------");
        GroceryItem item1 = new GroceryItem();
        // Set properties using setters
        item1.setName("Sugar");
        item1.setPrice(45.50);
        item1.setQuantity(100);
        item1.displayDetails();

        System.out.println("\n--- Selling Some Units ---");
        item1.sell(20);
        System.out.println();
        item1.displayDetails();

        // Create item using parameterized constructor
        GroceryItem item2 = new GroceryItem("Milk", 28.00, 50, "Dairy");
        System.out.println("\n--------- Item 2 ---------");
        item2.displayDetails();

        System.out.println("\n--- Restocking ---");
        item2.restock(30);
        System.out.println();
        item2.displayDetails();

        // Changing the value of default access variable (quantity)
        item2.quantity = 200; // allowed since in same package
        System.out.println("\n--- Directly Updated Quantity (default access) ---");
        item2.displayDetails();

        // Changing the value of protected access variable (supplierName)
        item2.supplierName = "Amul Ltd."; // allowed since in same package
        System.out.println("\n--- Updated Supplier (protected access) ---");
        item2.displayDetails();

        // Static variable (same for all the items of the class) modified directly
        GroceryItem.storeName = "DailyNeeds Grocery Hub";
        System.out.println("\n--- After Changing Static Store Name ---");
        System.out.println("\n--------- Item 1 ---------");
        item1.displayDetails();
        System.out.println("\n--------- Item 2 ---------");
        item2.displayDetails();

        // item2.category = "Beverages"; Cannot modify final variable
    }
}
