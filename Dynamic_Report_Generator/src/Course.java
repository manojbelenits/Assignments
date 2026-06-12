class Course {

    private int courseId;
    private String courseName;
    private String trainerName;
    private double fee;

    public Course(int courseId,
                  String courseName,
                  String trainerName,
                  double fee) {

        this.courseId = courseId;
        this.courseName = courseName;
        this.trainerName = trainerName;
        this.fee = fee;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public double getFee() {
        return fee;
    }
}