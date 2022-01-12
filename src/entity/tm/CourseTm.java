package entity.tm;

import javafx.scene.control.Button;

import java.awt.*;

public class CourseTm {
    private String courseId;
    private String program;
    private String duration;
    private Double courseFee;
    private Button btn;


    public CourseTm() {
    }

    public CourseTm(String courseId, String program, String duration, Double courseFee, Button btn) {
        this.courseId = courseId;
        this.program = program;
        this.duration = duration;
        this.courseFee = courseFee;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
