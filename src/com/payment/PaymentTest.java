package com.payment;

interface PaymentMethod {
    boolean processPayment(double amount);
    String getPaymentDetails();
    default boolean validate() {
        return true;
    }
}

interface Refundable {
    boolean processRefund(String transactionId);
    default double getRefundFee() {
        return 0.0;
    }
}

class FraudCheckResult {
    boolean isSafe;
    String message;

    public FraudCheckResult(boolean isSafe, String message) {
        this.isSafe = isSafe;
        this.message = message;
    }
}

interface FraudCheckable {
    FraudCheckResult checkFraud(double amount);
    default boolean isHighRisk(double amount) {
        return amount > 5000;
    }
}

class CreditCardPayment implements PaymentMethod, Refundable, FraudCheckable {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
        System.out.println("Card: ****-****-****-" + cardNumber.substring(12));
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return "Credit Card: " + cardHolder;
    }

    @Override
    public boolean processRefund(String transactionId) {
        System.out.println("Processing refund for: " + transactionId);
        return true;
    }

    @Override
    public double getRefundFee() {
        return 2.50; // Credit cards have refund fees
    }

    @Override
    public FraudCheckResult checkFraud(double amount) {
        boolean suspicious = amount > 10000 || cardNumber.startsWith("9999");
        return new FraudCheckResult(!suspicious, suspicious ? "High risk transaction" : "OK");
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        CreditCardPayment payment = new CreditCardPayment("1234567890123456", "John Doe");

        payment.processPayment(1500);
        System.out.println(payment.getPaymentDetails());

        payment.processRefund("TXN12345");

        FraudCheckResult result = payment.checkFraud(12000);
        System.out.println(result.message + ", Safe? " + result.isSafe);
    }
}
