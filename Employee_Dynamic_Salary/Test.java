import java.util.Comparator;
import java.util.function.*;


public class Test {

        public static void main(String[] args) {

            Employee employee = new Employee(
                    101,
                    "Ravi",
                    "IT",
                    "Developer",
                    6,
                    60000.0,
                    4.5
            );

            // Predicate
            Predicate<Employee> eligibleForHike =
                    emp -> emp.getPerformanceRating() >= 3;


            // Comparator
            Comparator<Employee> comparator =
                    Comparator.comparing(Employee::getPerformanceRating)
                            .reversed();

            // Custom Functional Interface
            SalaryProcessor salaryProcessor = emp -> {

                double hikePercentage = CheckRoleAndRating.checkForRoleandRating(emp);

                return emp.getSalary()
                        + (emp.getSalary() * hikePercentage / 100);
            };

            if (eligibleForHike.test(employee)) {

                double oldSalary = employee.getSalary();
                double hikePercentage =  CheckRoleAndRating.checkForRoleandRating(employee);

                double finalSalary =
                        salaryProcessor.process(employee);

                employee.setSalary(finalSalary);

                // Consumer
                Consumer<Employee> consumer = emp -> {
                    System.out.println("Employee: " +
                            emp.getEmployeeName());
                    System.out.println("Role: " +
                            emp.getRole());
                    System.out.println("Old Salary: " +
                            oldSalary);
                    System.out.println("Hike Applied: " +
                            hikePercentage + "%");
                    System.out.println("Final Salary: " +
                            emp.getSalary());
                };

                consumer.accept(employee);

            } else {
                System.out.println(
                        "No Hike Applied. Rating is below 3");
            }
        }
    }

