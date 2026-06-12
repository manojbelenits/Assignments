import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<InterviewFeedback> sampleFeedbackList = SampleData.getSampleFeedbackList();

        //Function For OverAll Rating
        Function<InterviewFeedback,Double> overAllRatingProcess = ifd->{

          return    (ifd.getProblemSolvingRating()+ifd.getConfidenceRating()+ifd.getCodingRating()
                    +ifd.getTechnicalRating()+ifd.getTechnicalRating())/5;

        };



        //Function For Performance Status (ovr -> overAllRating)
        Function<Double,String> performanceStatus = ovr -> {
            if(ovr>=8d){
                return "Excellent";
            }
            else if (ovr>=6) {
                return "Good";
            }
            else if (ovr>=4) {
                return "Average";
            }
            else{
                return "Needs Improvement";
            }
        };



        Predicate<InterviewFeedback> placementEligibility =  ifd->{

            if( overAllRatingProcess.apply(ifd)>=6 && ifd.getCodingRating()>=6){
                return true;
            }
            return false;
        };

        for (InterviewFeedback stud:sampleFeedbackList){

            Double overAllRating = overAllRatingProcess.apply(stud);
            String status = performanceStatus.apply(overAllRating);
            String placementEligible = placementEligibility.test(stud) ?"Yes":"NO";

            List<String> suggList=new ArrayList<String>();


        if(stud.getCodingRating()<6)
            suggList.add("Improve Coding Skills");
        if(stud.getTechnicalRating()<6)
            suggList.add("Improve Technical Skills");
        if(stud.getConfidenceRating()<6)
            suggList.add("Improve Confidance Rating");
        if(stud.getCommunicationRating()<6)
            suggList.add("Improve Communication Skill");
        if(stud.getProblemSolvingRating()<6)
            suggList.add("Improve Problem Solving Skills");



        System.out.println("Student:"+stud.getStudentName()+"\n"+
                            "OverAll Rating:"+overAllRating+"\n"+
                            "Performance Status:"+status+"\n"+
                            "Placement Eligible:"+placementEligible);

        if(suggList.isEmpty()){
            System.out.println("No Suggestions Excellent Performance");
        }
        else{
            suggList.forEach(System.out::println);
            System.out.println("----------------------------------");
        }


    }//forEach loop

        //Group the students based on performance
        Map<String, List<InterviewFeedback>> collect = sampleFeedbackList.stream()
                                            .collect(
                                                    Collectors.groupingBy(std->performanceStatus.apply(overAllRatingProcess.apply(std)))
                                            );

        collect.forEach((status, students) -> {
            System.out.println("\n" + status);
            students.forEach(student ->
                    System.out.println(" - " + student.getStudentName()));
        });


    //Sort Based on OverAllRating
        sampleFeedbackList.stream()
                .sorted((s1,s2)->Double.compare
                                                                (overAllRatingProcess.apply(s2),
                                                                        overAllRatingProcess.apply(s1)))
                .forEach(std->{
                    System.out.println(std.getStudentName()+"->"+overAllRatingProcess.apply(std));
                });


        sampleFeedbackList.stream()
                .filter(student -> !placementEligibility.test(student))
                .forEach(student -> {

                    System.out.println("\nStudent : " + student.getStudentName());

                    List<String> suggestions = new ArrayList<>();

                    if (student.getCodingRating() < 6)
                        suggestions.add("Improve Coding Skills");

                    if (student.getTechnicalRating() < 6)
                        suggestions.add("Improve Technical Skills");

                    if (student.getCommunicationRating() < 6)
                        suggestions.add("Improve Communication Skills");

                    if (student.getConfidenceRating() < 6)
                        suggestions.add("Improve Confidence");

                    if (student.getProblemSolvingRating() < 6)
                        suggestions.add("Improve Problem Solving Skills");

                    System.out.println("Suggestions : ");
                    suggestions.forEach(s -> System.out.println(" - " + s));
                });






    }


}
