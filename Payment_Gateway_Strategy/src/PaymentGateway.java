@FunctionalInterface
interface PaymentGateway {
    PaymentResponse pay(PaymentRequest request);
}