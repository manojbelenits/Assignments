class Payment {

    private int studentId;
    private double amount;
    private String status;

    public Payment(int studentId,
                   double amount,
                   String status) {

        this.studentId = studentId;
        this.amount = amount;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}