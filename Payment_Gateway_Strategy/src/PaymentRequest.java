class PaymentRequest {

    private String paymentId;
    private String customerName;
    private Double amount;
    private String paymentMode;
    private String couponCode;
    private String bankName;
    private String walletName;

    public PaymentRequest(String paymentId,
                          String customerName,
                          Double amount,
                          String paymentMode,
                          String couponCode,
                          String bankName,
                          String walletName) {

        this.paymentId = paymentId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.couponCode = couponCode;
        this.bankName = bankName;
        this.walletName = walletName;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public String getBankName() {
        return bankName;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}