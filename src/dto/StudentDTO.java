package dto;

public class StudentDTO {
    private String studentId;
    private String name;
    private String birthday;
    private String address;
    private String nic;
    private String school;
    private String telephoneNumber;

    public StudentDTO() {
    }

    public StudentDTO(String studentId, String name, String birthday, String address, String nic, String school, String telephoneNumber) {
        this.setStudentId(studentId);
        this.setName(name);
        this.setBirthday(birthday);
        this.setAddress(address);
        this.setNic(nic);
        this.setSchool(school);
        this.setTelephoneNumber(telephoneNumber);
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

}
