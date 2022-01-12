package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity

public class Course implements SuperEntity {
    @Id
    private String courseId;
    private String program;
    private String duration;
    private Double courseFee;
    @ManyToMany(mappedBy = "courses")
    private List<ManageCourse> registerList;

    public Course() {
    }

    public Course(String courseId, String program, String duration, Double courseFee) {
        this.setCourseId(courseId);
        this.setProgram(program);
        this.setDuration(duration);
        this.setCourseFee(courseFee);
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Double courseFee) {
        this.courseFee = courseFee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", program='" + program + '\'' +
                ", duration='" + duration + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}
