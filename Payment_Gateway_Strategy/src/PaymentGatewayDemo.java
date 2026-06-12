import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PaymentGatewayDemo {

    public static void main(String[] args) {

        PaymentRequest request = new PaymentRequest(
                "PAY101",
                "Manoj",
                25000.0,
                "UPI",
                "COURSE10",
                "SBI",
                "PhonePe"
        );

        Predicate<PaymentRequest> amountValidator =
                payment -> payment.getAmount() != null && payment.getAmount() > 0;

        Function<PaymentRequest, PaymentRequest> applyCoupon = payment -> {

            if ("COURSE10".equalsIgnoreCase(payment.getCouponCode())) {
                payment.setAmount(payment.getAmount() * 0.90);
            } else if ("COURSE20".equalsIgnoreCase(payment.getCouponCode())) {
                payment.setAmount(payment.getAmount() * 0.80);
            }

            return payment;
        };

        Function<PaymentRequest, PaymentRequest> addGatewayCharges = payment -> {

            switch (payment.getPaymentMode().toUpperCase()) {

                case "UPI":
                    payment.setAmount(payment.getAmount() + 5);
                    break;

                case "CREDIT_CARD":
                    payment.setAmount(payment.getAmount() + 50);
                    break;

                case "NET_BANKING":
                    payment.setAmount(payment.getAmount() + 20);
                    break;

                case "WALLET":
                    payment.setAmount(payment.getAmount() + 10);
                    break;
            }

            return payment;
        };

        Supplier<String> transactionGenerator =
                () -> "TXN" + System.currentTimeMillis();

        PaymentGateway upiPayment = payment -> {

            PaymentResponse response = new PaymentResponse();
            response.setTransactionId(transactionGenerator.get());
            response.setPaymentStatus("SUCCESS");
            response.setFinalAmount(payment.getAmount());
            response.setMessage("UPI Payment Completed");

            return response;
        };

        PaymentGateway creditCardPayment = payment -> {

            PaymentResponse response = new PaymentResponse();
            response.setTransactionId(transactionGenerator.get());
            response.setPaymentStatus("SUCCESS");
            response.setFinalAmount(payment.getAmount());
            response.setMessage("Credit Card Payment Completed");

            return response;
        };

        PaymentGateway netBankingPayment = payment -> {

            PaymentResponse response = new PaymentResponse();
            response.setTransactionId(transactionGenerator.get());
            response.setPaymentStatus("SUCCESS");
            response.setFinalAmount(payment.getAmount());
            response.setMessage("Net Banking Payment Completed");

            return response;
        };

        PaymentGateway walletPayment = payment -> {

            PaymentResponse response = new PaymentResponse();
            response.setTransactionId(transactionGenerator.get());
            response.setPaymentStatus("SUCCESS");
            response.setFinalAmount(payment.getAmount());
            response.setMessage("Wallet Payment Completed");

            return response;
        };

        if (!amountValidator.test(request)) {
            System.out.println("Invalid Payment Amount");
            return;
        }

        double originalAmount = request.getAmount();

        request = applyCoupon.andThen(addGatewayCharges)
                .apply(request);

        PaymentGateway selectedGateway;

        switch (request.getPaymentMode().toUpperCase()) {

            case "UPI":
                selectedGateway = upiPayment;
                break;

            case "CREDIT_CARD":
                selectedGateway = creditCardPayment;
                break;

            case "NET_BANKING":
                selectedGateway = netBankingPayment;
                break;

            case "WALLET":
                selectedGateway = walletPayment;
                break;

            default:
                throw new IllegalArgumentException("Unsupported Payment Mode");
        }

        PaymentResponse response = selectedGateway.pay(request);

        System.out.println("Payment Mode    : " + request.getPaymentMode());
        System.out.println("Original Amount : " + originalAmount);
        System.out.println("Coupon Applied  : " + request.getCouponCode());
        System.out.println("Final Amount    : " + response.getFinalAmount());
        System.out.println("Transaction ID  : " + response.getTransactionId());
        System.out.println("Payment Status  : " + response.getPaymentStatus());
    }
}