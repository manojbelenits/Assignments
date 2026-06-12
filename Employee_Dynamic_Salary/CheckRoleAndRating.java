git import java.util.function.Function;

public class CheckRoleAndRating {

    public static Double checkForRoleandRating(Employee employee){

        Function<Employee, Double> hikeCalculator = emp -> {

            double hike = 0;

            if (emp.getPerformanceRating() >= 4.5) {
                hike += 20;
            }

            if (emp.getExperience() >= 5) {
                hike += 15;
            }

            if ("Developer".equalsIgnoreCase(emp.getRole())) {
                hike += 10;
            } else if ("Tester".equalsIgnoreCase(emp.getRole())) {
                hike += 8;
            }

            return hike;
        };
        return hikeCalculator.apply(employee);
    }
}
