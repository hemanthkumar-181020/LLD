// Target Interface
interface PaymentGateway {
    void pay(String id, double amount);
}

// Existing PhonePe implementation
class Phonepe implements PaymentGateway {

    @Override
    public void pay(String id, double amount) {
        System.out.println(
                "Paid Rs. " + amount + " using PhonePe for order: " + id
        );
    }
}

// Adaptee: Existing Razorpay API
class RazoPayApi {

    public void makePaymentGateway(String orderId, double amount) {
        System.out.println(
                "Paid Rs. " + amount + " using Razorpay for order: " + orderId
        );
    }
}

// Adapter
class RazoPayAdapter implements PaymentGateway {

    private RazoPayApi razoPayApi;

    public RazoPayAdapter() {
        this.razoPayApi = new RazoPayApi();
    }

    @Override
    public void pay(String orderId, double amount) {
        razoPayApi.makePaymentGateway(orderId, amount);
    }
}

// Client
class Checkout {

    private PaymentGateway paymentGateway;

    // Constructor Injection
    public Checkout(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkout(String orderId, double amount) {
        paymentGateway.pay(orderId, amount);
    }
}

// Main Class
public class AdapterPattern {

    public static void main(String[] args) {

        // PhonePe payment
        Checkout checkout1 = new Checkout(new Phonepe());
        checkout1.checkout("101", 2000);

        System.out.println("-------------------");

        // Razorpay payment through Adapter
        Checkout checkout2 = new Checkout(new RazoPayAdapter());
        checkout2.checkout("102", 3000);
    }
}