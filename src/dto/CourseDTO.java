package dto;

public class CourseDTO {
    private String courseId;
    private String program;
    private String duration;
    private Double courseFee;

    public CourseDTO() {
    }

    public CourseDTO(String courseId, String program, String duration, Double courseFee) {
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
}
