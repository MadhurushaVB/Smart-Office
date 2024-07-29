
interface PaymentProcessor {
    void processPayment(double amount);
}

class ThirdPartyPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of $" +  amount + " made through Third Party Gateway");
    }
}

class PaymentAdapter implements PaymentProcessor {
    private ThirdPartyPaymentGateway thirdPartyPaymentGateway;

    public PaymentAdapter(ThirdPartyPaymentGateway thirdPartyPaymentGateway) {
        this.thirdPartyPaymentGateway = thirdPartyPaymentGateway;
    }

    public void processPayment(double amount) {
        thirdPartyPaymentGateway.makePayment(amount);
    }
}

public class AdapterPattern{
    public static void main(String[] args) {
        ThirdPartyPaymentGateway thirdPartyPaymentGateway = new ThirdPartyPaymentGateway();
        PaymentProcessor paymentProcessor = new PaymentAdapter(thirdPartyPaymentGateway);

        paymentProcessor.processPayment(100.0);
    }
}
