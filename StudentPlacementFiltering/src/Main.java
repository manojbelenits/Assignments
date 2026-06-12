import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> students = List.of(

                new Student(101, "Smith", "Java", 2024,
                        80d, 0, 4.5,
                        List.of("Java", "SQL"),
                        true, true),

                new Student(102, "John", "Python", 2023,
                        75d, 1, 4.2,
                        List.of("Python"),
                        true, false),

                new Student(103, "Alice", "Spring Boot", 2024,
                        90d, 0, 4.8,
                        List.of("Java", "Spring"),
                        true, true),

                new Student(104, "David", "Angular", 2022,
                        65d, 2, 3.9,
                        List.of("Angular"),
                        false, true),

                new Student(105, "Emma", "React", 2025,
                        88d, 0, 4.7,
                        List.of("Python", "React"),
                        true, true)
        );

        Predicate<Student> gradYear =
                s -> s.getGraduationYear() >= 2022;

        Predicate<Student> percentage =
                s -> s.getPercentage() >= 60;

        Predicate<Student> backlogs =
                s -> s.getBacklogs() == 0;

        Predicate<Student> mockRating =
                s -> s.getMockRating() >= 4;

        Predicate<Student> resume =
                Student::getResumeAvailable;

        Predicate<Student> feePaid =
                Student::getFeePaid;

        Predicate<Student> skill =
                s -> s.getSkills().contains("Java")
                        || s.getSkills().contains("Python");

        Predicate<Student> eligibleCriteria =
                gradYear
                        .and(percentage)
                        .and(backlogs)
                        .and(mockRating)
                        .and(resume)
                        .and(feePaid)
                        .and(skill);


        List<Student> eligibleStudents = students.stream()
                .filter(eligibleCriteria)
                .sorted(Comparator.comparing(Student::getMockRating)
                        .reversed())
                .toList();

        List<Student> rejectedStudents = students.stream()
                .filter(eligibleCriteria.negate())
                .toList();

        System.out.println("Eligible Students for Placement:");
        eligibleStudents.forEach(s ->
                System.out.println(
                        s.getStudentName()
                                + " - "
                                + s.getCourseName()
                                + " - Rating: "
                                + s.getMockRating()));

        System.out.println("\nRejected Students:");

        rejectedStudents.forEach(s -> {

            List<String> reasons = new ArrayList<>();

            if (s.getGraduationYear() < 2022)
                reasons.add("Graduation year less than 2022");

            if (s.getPercentage() < 60)
                reasons.add("Percentage below 60");

            if (s.getBacklogs() > 0)
                reasons.add("Backlogs available");

            if (s.getMockRating() < 4)
                reasons.add("Mock rating below 4");

            if (!s.getResumeAvailable())
                reasons.add("Resume missing");

            if (!s.getFeePaid())
                reasons.add("Fee not paid");

            if (!(s.getSkills().contains("Java")
                    || s.getSkills().contains("Python")))
                reasons.add("Java/Python skill missing");

            System.out.println(
                    s.getStudentName()
                            + " - Reason: "
                            + String.join(", ", reasons));
        });

        System.out.println("\nStudents Grouped By Course:");

        Map<String, List<Student>> groupedStudents =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getCourseName));

        groupedStudents.forEach((course, studentList) -> {
            System.out.println("\n" + course);
            studentList.forEach(
                    s -> System.out.println(
                            "   " + s.getStudentName()));
        });
    }
}