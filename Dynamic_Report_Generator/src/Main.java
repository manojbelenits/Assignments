import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Supplier - Sample Courses
        Supplier<List<Course>> courseSupplier = () -> Arrays.asList(
                new Course(101, "Java Fullstack", "Ramesh", 50000),
                new Course(102, "Python Fullstack", "Suresh", 45000),
                new Course(103, "DevOps", "Mahesh", 40000),
                new Course(104, "Data Science", "Kiran", 60000),
                new Course(105, "AWS Cloud", "Ramesh", 55000),
                new Course(106, "React JS", "Suresh", 30000)
        );

        List<Course> courses = courseSupplier.get();

        List<Student> students = Arrays.asList(
                new Student(1, "Ravi"),
                new Student(2, "Teja"),
                new Student(3, "Sai"),
                new Student(4, "Arjun"),
                new Student(5, "Kiran"),
                new Student(6, "Manoj"),
                new Student(7, "Vijay"),
                new Student(8, "Rahul")
        );

        List<Enrollment> enrollments = Arrays.asList(

                new Enrollment(1, 101, LocalDate.of(2025, 1, 10)),
                new Enrollment(2, 101, LocalDate.of(2025, 1, 15)),
                new Enrollment(3, 102, LocalDate.of(2025, 2, 5)),
                new Enrollment(4, 103, LocalDate.of(2025, 2, 20)),
                new Enrollment(5, 104, LocalDate.of(2025, 3, 11)),
                new Enrollment(6, 101, LocalDate.of(2025, 3, 21)),
                new Enrollment(7, 105, LocalDate.of(2025, 4, 8)),
                new Enrollment(8, 106, LocalDate.of(2025, 4, 19)),
                new Enrollment(1, 104, LocalDate.of(2025, 5, 15)),
                new Enrollment(2, 105, LocalDate.of(2025, 5, 18))
        );

        List<Payment> payments = Arrays.asList(

                new Payment(1, 50000, "PAID"),
                new Payment(2, 50000, "PAID"),
                new Payment(3, 45000, "PENDING"),
                new Payment(4, 40000, "PAID"),
                new Payment(5, 60000, "PAID"),
                new Payment(6, 50000, "PENDING"),
                new Payment(7, 55000, "PAID"),
                new Payment(8, 30000, "PENDING")
        );


        // Report Generator Functional Interface


        ReportGenerator<Payment, Double> totalRevenueReport =
                data -> data.stream()
                        .filter(p -> p.getStatus().equalsIgnoreCase("PAID"))
                        .mapToDouble(Payment::getAmount)
                        .sum();

        ReportGenerator<Payment, Double> pendingPaymentReport =
                data -> data.stream()
                        .filter(p -> p.getStatus().equalsIgnoreCase("PENDING"))
                        .mapToDouble(Payment::getAmount)
                        .sum();


        Function<Course, String> trainerExtractor =
                Course::getTrainerName;



        Predicate<Payment> pendingPaymentPredicate =
                p -> p.getStatus().equalsIgnoreCase("PENDING");



        Consumer<String> printer = System.out::println;


        printer.accept("\n----- COURSE WISE ENROLLMENT REPORT ------");

        Map<Integer, Long> enrollmentCount =
                enrollments.stream()
                        .collect(Collectors.groupingBy(
                                Enrollment::getCourseId,
                                Collectors.counting()
                        ));

        enrollmentCount.forEach((courseId, count) -> {

            String courseName = courses.stream()
                    .filter(c -> c.getCourseId() == courseId)
                    .findFirst()
                    .get()
                    .getCourseName();

            System.out.println(courseName + " : " + count + " Students");
        });



        printer.accept("\n----- TOTAL REVENUE REPORT ---------");

        Double totalRevenue =
                totalRevenueReport.generate(payments);

        System.out.println("Total Revenue : ₹" + totalRevenue);



        printer.accept("\n---------- PENDING PAYMENT REPORT -------------");

        Double pendingAmount =
                pendingPaymentReport.generate(payments);

        System.out.println("Pending Payments : ₹" + pendingAmount);

        payments.stream()
                .filter(pendingPaymentPredicate)
                .forEach(p ->
                        System.out.println(
                                "Student Id : "
                                        + p.getStudentId()
                                        + " Pending Amount : ₹"
                                        + p.getAmount()
                        )
                );



        printer.accept("\n--------- TRAINER WISE COURSE REPORT ------");

        Map<String, List<Course>> trainerWiseCourses =
                courses.stream()
                        .collect(Collectors.groupingBy(
                                trainerExtractor
                        ));

        trainerWiseCourses.forEach((trainer, courseList) -> {

            System.out.println("\nTrainer : " + trainer);

            courseList.forEach(c ->
                    System.out.println(c.getCourseName()));
        });


        printer.accept("\n--------- MONTHLY ADMISSION REPORT -----------");

        Map<Month, Long> monthlyAdmissions =
                enrollments.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getEnrollmentDate().getMonth(),
                                Collectors.counting()
                        ));

        monthlyAdmissions.forEach((month, count) ->
                System.out.println(month + " : " + count)
        );



        printer.accept("\n----------- TOP 5 HIGH FEE COURSES -------------");

        courses.stream()
                .sorted(
                        Comparator.comparingDouble(
                                Course::getFee
                        ).reversed()
                )
                .limit(5)
                .forEach(course ->
                        System.out.println(
                                course.getCourseName()
                                        + " - ₹"
                                        + course.getFee()
                        )
                );



        printer.accept("\n---------- REVENUE BY STATUS ----------");

        Map<String, Double> revenueByStatus =
                payments.stream()
                        .collect(Collectors.groupingBy(
                                Payment::getStatus,
                                Collectors.summingDouble(
                                        Payment::getAmount
                                )
                        ));

        revenueByStatus.forEach(
                (status, amount) ->
                        System.out.println(status + " : ₹" + amount)
        );



        printer.accept("\n------- COURSE NAMES --------");

        List<String> courseNames =
                courses.stream()
                        .map(Course::getCourseName)
                        .collect(Collectors.toList());

        courseNames.forEach(System.out::println);
    }
}


















