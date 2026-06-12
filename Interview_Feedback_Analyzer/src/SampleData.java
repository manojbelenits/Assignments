import java.util.Arrays;
import java.util.List;

public class SampleData {


    public static List<InterviewFeedback> getSampleFeedbackList() {
        return Arrays.asList(

                new InterviewFeedback(
                        101,
                        "Alex Rivera",
                        7d, 6.5d, 7d, 4.0, 8d,
                        Arrays.asList("xyz", "xyz", "xyz"),
                        Arrays.asList("xyz", "xyz", "xyz"),
                        Arrays.asList("xyz", "xyz", "xyz")
                ),


                new InterviewFeedback(
                        102,
                        "Samira Patel",
                        7d, 7d, 7d, 7d, 4.2,
                        Arrays.asList("xyz", "xyz", "xyz"),
                        Arrays.asList("xyz", "xyz", "xyz"),
                        Arrays.asList("xyz", "xyz", "xyz")
                ),


                new InterviewFeedback(
                        103,
                        "Marcus Vance",
                        6.7, 6.7, 3.0, 2.5, 6.7,
                        Arrays.asList("xyz", "xyz", "xyz"),
                        Arrays.asList("xyz", "xyz", "xyz"),
                        Arrays.asList("xyz", "xyz", "xyz")
                ),


                new InterviewFeedback(
                        104,
                        "Chloe Zhao",
                        8d, 5.0, 8d, 4.9, 8d,
                        Arrays.asList("xyz", "xyz", "xyz"),
                        Arrays.asList("xyz", "xyz", "xyz"),
                        Arrays.asList("None")
                )
        );
    }
}
