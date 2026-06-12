import java.util.List;

public class Student {
    private Integer studentId;
    private String studentName;
    private String qualification;
    private List<String> skills;
    private Integer experience;
    private String preferredTechnology;
    private Double budget;

    public Student(Integer studentId, String studentName, String qualification, List<String> skills, Integer experience, String preferredTechnology, Double budget) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.qualification = qualification;
        this.skills = skills;
        this.experience = experience;
        this.preferredTechnology = preferredTechnology;
        this.budget = budget;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getPreferredTechnology() {
        return preferredTechnology;
    }

    public void setPreferredTechnology(String preferredTechnology) {
        this.preferredTechnology = preferredTechnology;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

}
