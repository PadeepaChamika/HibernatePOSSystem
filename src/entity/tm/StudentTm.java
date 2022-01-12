package entity.tm;


import javafx.scene.control.Button;

public class StudentTm {
    private String studentId;
    private String name;
    private String birthday;
    private String address;
    private String nic;
    private String school;
    private String telephoneNumber;
    private Button btn;

    public StudentTm() {
    }

    public StudentTm(String studentId, String name, String birthday, String address, String nic, String school, String telephoneNumber, Button btn) {
        this.studentId = studentId;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.nic = nic;
        this.school = school;
        this.telephoneNumber = telephoneNumber;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}

