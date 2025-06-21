package pillarsofOOPS;

// Base class
class Payment {
    void makePayment(double amount) {
        System.out.println("Processing payment of INR " + amount);
    }
}

// Subclass 1 - Credit Card Payment
class CreditCard extends Payment {
    @Override // Method overriding
    void makePayment(double amount) {
        System.out.println("Processing credit card payment of INR " + amount);
    }
}

// Subclass 2 - UPI Payment
class UPI extends Payment {
    @Override // Method overriding
    void makePayment(double amount) {
        System.out.println("Processing UPI payment of INR " + amount);
    }
}

// Class to demonstrate method overloading
class DiscountCalculator {
    double applyDiscount(double price) {
        return price * 0.95; // 5% discount
    }

    double applyDiscount(double price, double discountPercent) {
        return price - (price * discountPercent / 100);
    }

    double applyDiscount(double price, String couponCode) {
        if (couponCode.equals("SAVE10")) {
            return price - 10;
        }
        return price;
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        // Runtime Polymorphism (Method Overriding)
        Payment payment = new Payment();
        payment.makePayment(1000.0);

        payment = new CreditCard();
        payment.makePayment(1500.0);

        payment = new UPI();
        payment.makePayment(600.0);

        System.out.println();

        // Compile-time Polymorphism (Method Overloading)
        DiscountCalculator dc = new DiscountCalculator();
        System.out.println("Discounted price (default): INR " + dc.applyDiscount(1000));
        System.out.println("Discounted price (custom %): INR " + dc.applyDiscount(1000, 20));
        System.out.println("Discounted price (coupon): INR " + dc.applyDiscount(500, "SAVE10"));
    }
}
