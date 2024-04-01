public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean processPayment(double amount) {
        // Logic to process payment using paymentGateway
        return paymentGateway.charge(amount);
    }
}

public interface PaymentGateway {
    boolean charge(double amount);
}
