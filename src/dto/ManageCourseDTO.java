package dto;

import entity.Course;
import entity.Student;

import java.util.List;

public class ManageCourseDTO {
    String registerID;
    private String name;
    private String programId;
    Double fees;
    private Student student;
    private List<Course> courses;

    public ManageCourseDTO() {
    }

    public ManageCourseDTO(String registerID, String name, String programId, Double fees, Student student, List<Course> courses) {
        this.registerID = registerID;
        this.name = name;
        this.programId = programId;
        this.fees = fees;
        this.student = student;
        this.courses = courses;
    }

    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
