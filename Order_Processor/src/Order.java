import java.util.List;

public class Order {

    private String orderId;
    private String customerName;
    private List<String> items;
    private Double totalAmount;
    private String paymentStatus;
    private String deliveryStatus;
    private String couponCode;

    public Order(String orderId, String customerName,
                 List<String> items, Double totalAmount,
                 String paymentStatus, String deliveryStatus,
                 String couponCode) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.deliveryStatus = deliveryStatus;
        this.couponCode = couponCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<String> getItems() {
        return items;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}