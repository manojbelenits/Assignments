import java.time.LocalDate;

class Enrollment {

    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;

    public Enrollment(int studentId,
                      int courseId,
                      LocalDate enrollmentDate) {

        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
}