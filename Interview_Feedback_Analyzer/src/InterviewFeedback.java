import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InterviewFeedback {
    private Integer studentId;
    private String studentName;
    private Double technicalRating;
    private Double communicationRating;
    private Double codingRating;
    private Double confidenceRating;
    private Double problemSolvingRating;
    private List<String> questionsAsked;
    private List<String> strengths;
    private List<String> weaknesses;
}
