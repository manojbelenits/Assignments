import lombok.ToString;

@ToString
public class Customer {

    private Integer customerId;
    private String customerName;
    private Integer age;
    private Double monthlySalary;
    private Integer creditScore;
    private Double existingEmi;
    private String employmentType;
    private Double requestedLoanAmount;

    public Customer(Integer customerId, String customerName, Integer age, Double monthlySalary, Integer creditScore, Double existingEmi, String employmentType, Double requestedLoanAmount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.age = age;
        this.monthlySalary = monthlySalary;
        this.creditScore = creditScore;
        this.existingEmi = existingEmi;
        this.employmentType = employmentType;
        this.requestedLoanAmount = requestedLoanAmount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public Double getExistingEmi() {
        return existingEmi;
    }

    public void setExistingEmi(Double existingEmi) {
        this.existingEmi = existingEmi;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public Double getRequestedLoanAmount() {
        return requestedLoanAmount;
    }

    public void setRequestedLoanAmount(Double requestedLoanAmount) {
        this.requestedLoanAmount = requestedLoanAmount;
    }
}
