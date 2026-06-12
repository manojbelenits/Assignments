import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Customer> customers = List.of(

                new Customer(
                        101,
                        "Mahesh",
                        30,
                        80000.0,
                        780,
                        15000.0,
                        "SALARIED",
                        1000000.0
                ),

                new Customer(
                        102,
                        "Kiran",
                        25,
                        60000.0,
                        700,
                        30000.0,
                        "SALARIED",
                        1500000.0
                ),

                new Customer(
                        103,
                        "Ravi",
                        45,
                        120000.0,
                        820,
                        20000.0,
                        "BUSINESS",
                        2000000.0
                )
        );

        LoanRule ageRule = c -> c.getAge() >= 21 &&
                        c.getAge() <= 60;

        LoanRule salaryRule = c -> c.getMonthlySalary() >= 50000;

        LoanRule creditRule = c -> c.getCreditScore() >= 750;

        LoanRule emiRule = c -> c.getExistingEmi() < (c.getMonthlySalary() * 0.40);

        LoanRule loanAmountRule = c -> c.getRequestedLoanAmount() <= (c.getMonthlySalary() * 20);

        LoanRule employmentRule =
                c -> c.getEmploymentType().equalsIgnoreCase("SALARIED")
                        ||
                        c.getEmploymentType().equalsIgnoreCase("BUSINESS");

        LoanRule eligibilityRule =
                ageRule
                        .and(salaryRule)
                        .and(creditRule)
                        .and(emiRule)
                        .and(loanAmountRule)
                        .and(employmentRule);

        for (Customer customer : customers) {

            System.out.println("--------------------------------");
            System.out.println("Customer : "
                    + customer.getCustomerName());

            if (eligibilityRule.validate(customer)) {

                System.out.println("Loan Status : APPROVED");
                System.out.println(
                        "Reason : All eligibility conditions satisfied");

            } else {

                System.out.println("Loan Status : REJECTED");
                System.out.println("Failed Rules :");

                List<String> reasons = new ArrayList<>();

                if (!ageRule.validate(customer)) {
                    reasons.add(
                            "Age should be between 21 and 60");
                }

                if (!salaryRule.validate(customer)) {
                    reasons.add(
                            "Monthly salary is below 50000");
                }

                if (!creditRule.validate(customer)) {
                    reasons.add(
                            "Credit score is below 750");
                }

                if (!emiRule.validate(customer)) {
                    reasons.add(
                            "Existing EMI is more than allowed limit");
                }

                if (!loanAmountRule.validate(customer)) {
                    reasons.add(
                            "Requested loan amount exceeds limit");
                }

                if (!employmentRule.validate(customer)) {
                    reasons.add(
                            "Employment type is invalid");
                }

                reasons.forEach(reason ->
                        System.out.println("- " + reason));
            }
        }
    }
}