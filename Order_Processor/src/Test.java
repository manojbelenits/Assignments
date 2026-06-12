import java.util.List;

public class Test {

    public static void main(String[] args) {

        Order order = new Order(
                "ORD101",
                "Ravi",
                List.of("Laptop", "Mouse"),
                5000.0,
                "PENDING",
                "NOT_ASSIGNED",
                "GENAI10"
        );

        double originalAmount = order.getTotalAmount();

        // 1. Validate Order
        OrderProcessor validateOrder = ord -> {

            if (ord.getItems() == null ||
                    ord.getItems().isEmpty()) {

                throw new RuntimeException(
                        "Invalid Order. No Items Found");
            }

            System.out.println(
                    "Order Validation Completed");

            return ord;
        };

        // 2. Apply Coupon
        OrderProcessor applyCoupon = ord -> {

            if ("GENAI10".equalsIgnoreCase(
                    ord.getCouponCode())) {

                double discount =
                        ord.getTotalAmount() * 0.10;

                ord.setTotalAmount(
                        ord.getTotalAmount() - discount);

                System.out.println(
                        "Coupon Applied : GENAI10");
            }

            return ord;
        };

        // 3. Calculate GST
        OrderProcessor calculateGst = ord -> {

            double gst =
                    ord.getTotalAmount() * 0.18;

            ord.setTotalAmount(
                    ord.getTotalAmount() + gst);

            System.out.println(
                    "GST Added : 18%");

            return ord;
        };

        // 4. Confirm Payment
        OrderProcessor confirmPayment = ord -> {

            ord.setPaymentStatus("SUCCESS");

            System.out.println(
                    "Payment Confirmed");

            return ord;
        };

        // 5. Assign Delivery Partner
        OrderProcessor assignDeliveryPartner =
                ord -> {

                    ord.setDeliveryStatus(
                            "ASSIGNED");

                    System.out.println(
                            "Delivery Partner Assigned");

                    return ord;
                };

        // 6. Update Delivery Status
        OrderProcessor updateDeliveryStatus =
                ord -> {

                    ord.setDeliveryStatus(
                            "OUT_FOR_DELIVERY");

                    System.out.println(
                            "Delivery Status Updated");

                    return ord;
                };

        // Chain Processing
        Order finalOrder =
                validateOrder
                        .andThen(applyCoupon)
                        .andThen(calculateGst)
                        .andThen(confirmPayment)
                        .andThen(assignDeliveryPartner)
                        .andThen(updateDeliveryStatus)
                        .process(order);

        // Final Output

        System.out.println("\n===== FINAL ORDER =====");

        System.out.println(
                "Order ID: "
                        + finalOrder.getOrderId());

        System.out.println(
                "Original Amount: "
                        + originalAmount);

        System.out.println(
                "Coupon Applied: "
                        + finalOrder.getCouponCode());

        System.out.println(
                "Final Amount: "
                        + finalOrder.getTotalAmount());

        System.out.println(
                "Payment Status: "
                        + finalOrder.getPaymentStatus());

        System.out.println(
                "Delivery Status: "
                        + finalOrder.getDeliveryStatus());
    }
}