import java.util.Objects;

public class Employee {

    private Integer employeeId;
    private String employeeName;
    private String department;
    private String role;
    private Integer experience;
    private Double salary;
    private Double performanceRating;

    public Employee(Integer employeeId, String employeeName, String department, String role, Integer experience, Double salary, Double performanceRating) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.role = role;
        this.experience = experience;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }



    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(Double performanceRating) {
        this.performanceRating = performanceRating;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(employeeName, employee.employeeName) && Objects.equals(department, employee.department) && Objects.equals(role, employee.role) && Objects.equals(experience, employee.experience) && Objects.equals(salary, employee.salary) && Objects.equals(performanceRating, employee.performanceRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName, department, role, experience, salary, performanceRating);
    }
}
