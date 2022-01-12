package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ManageCourse implements SuperEntity {
    @Id
    private String registerId;
    private String name;
    private String programId;
    private Double fee;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courses;


    public ManageCourse() {
    }

    public ManageCourse(String registerId, String name, String programId, Double fee, Student student, List<Course> courses) {
        this.registerId = registerId;
        this.name = name;
        this.programId = programId;
        this.fee = fee;
        this.student = student;
        this.courses = courses;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
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

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
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
