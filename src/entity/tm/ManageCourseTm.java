package entity.tm;

public class ManageCourseTm {
    private String registerId;
    private String studentId;
    private String name;
    private String programId;
    private String program;
    private String duration;
    private Double fee;

    public ManageCourseTm() {
    }

    public ManageCourseTm(String registerId, String studentId, String name, String programId, String program, String duration, Double fee) {
        this.registerId = registerId;
        this.studentId = studentId;
        this.name = name;
        this.programId = programId;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
