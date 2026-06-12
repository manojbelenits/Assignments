import java.util.Objects;

public class Course {
    private Integer courseId;
    private String courseName;
    private String technology;
    private String level;
    private Double fee;
    private String duration;
    private Double rating;

    public Course(Integer courseId, String courseName, String technology, String level, Double fee, String duration, Double rating) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.technology = technology;
        this.level = level;
        this.fee = fee;
        this.duration = duration;
        this.rating = rating;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseName, course.courseName) && Objects.equals(fee, course.fee) && Objects.equals(rating, course.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, fee, rating);
    }
}
