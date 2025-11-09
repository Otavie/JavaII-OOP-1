abstract class PaymentProcessor {
    abstract void processPayment(double amount);
}

class PayPalProcessor extends PaymentProcessor {
    void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via PayPal.");
    }
}

class StripeProcessor extends PaymentProcessor {
    void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via Stripe.");
    }
}

public class RuntimePayment {
    public static void main(String[] args) {
        PaymentProcessor processor;

        processor = new PayPalProcessor();
        processor.processPayment(150.00); // PayPal

        processor = new StripeProcessor();
        processor.processPayment(200.00); // Stripe
    }
}
