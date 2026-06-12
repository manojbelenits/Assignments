import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Course c1 = new Course(300, "Java FullStack", "Java Stack", "Beginner",
                12500d, "6mnths", 4d);
        Course c2 = new Course(350, "Java FullStack", "Java Stack", "Advance",
                12500d, "6mnths", 4d);
        Course c3 = new Course(490, "Java FullStack", "Java Stack", "Beginner",
                9500d, "6mnths", 3d);

        Student student = new Student(101, "Smith", "Btech", List.of("Java", "python", "React"),
                0, "java Stack", 15000d);

         List<Course> courseList= Arrays.asList(c1, c2, c3);


        Predicate<Student> exp0 = std->std.getExperience()==0;

        Predicate<Student> budget = std->std.getBudget()<20000;

        Predicate<Student> expG3 = std->std.getExperience()>=3;


        Function<Student,List<Course>> recommendCourses = std->{

            List<Course> returning =null;

            if(exp0.test(std)){

                String preferredTechnology = std.getPreferredTechnology();


                List<Course> technologyCourses =
                        courseList.stream()
                                .filter(c ->
                                        c.getTechnology()
                                                .equalsIgnoreCase(preferredTechnology))
                                .toList();


                List<Course> rc =
                        technologyCourses.stream()
                                .filter(c ->
                                        c.getLevel()
                                                .equalsIgnoreCase("Beginner"))
                                .sorted((co1,co2) ->
                                        Double.compare(
                                                c2.getRating(),
                                                c1.getRating()))
                                .toList();

                returning= rc;
            }

            if(expG3.test(std)){

                String preferredTechnology = std.getPreferredTechnology();

                returning = courseList.stream()
                        .filter(c ->
                                c.getTechnology()
                                        .equalsIgnoreCase(preferredTechnology))
                        .filter(c ->
                                c.getLevel()
                                        .equalsIgnoreCase("Advanced"))
                        .sorted((co1,co2) ->
                                Double.compare(
                                        c2.getRating(),
                                        c1.getRating()))
                        .toList();

            }

            if(budget.test(std)){

                String preferredTechnology = std.getPreferredTechnology();

                returning= courseList.stream()
                        .filter(c ->
                                c.getTechnology()
                                        .equalsIgnoreCase(preferredTechnology))
                        .filter(c -> c.getFee() < 20000)
                        .sorted((co1,co2) ->
                                Double.compare(
                                        c2.getRating(),
                                        c1.getRating()))
                        .toList();
            }


        return returning;
        };


        List<Course> finalRes = recommendCourses.apply(student);

        HashSet<Course> courses = new HashSet<>(finalRes);


        System.out.println("Recommended Courses for:"+student.getStudentName());
        courses.forEach(c->{
        System.out.println(c.getCourseName()+" "+c.getFee()+" "+c.getRating());
    });





    }
}
