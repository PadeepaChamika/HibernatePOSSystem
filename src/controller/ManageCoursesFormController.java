package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.CourseBO;
import bo.custom.ManageCourseBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import dto.ManageCourseDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Student;
import entity.tm.ManageCourseTm;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageCoursesFormController {
    public JFXTextField txtName;
    public JFXTextField txtBirthday;
    public JFXTextField txtAddress;
    public JFXTextField txtNIC;
    public JFXTextField txtSchool;
    public JFXTextField txtTelephoneNumber;
    public TableView <ManageCourseTm>tblManageCourse;
    public TableColumn colRegisterId;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colProgramId;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;
    public JFXTextField txtProgram;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public JFXComboBox<String> cmbProgramId;
    public JFXComboBox<String> cmbStudentId;
    public Label lblRegisterId;
    public Label lblTotal;

    private StudentBO studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);
    private CourseBO courseBO = BOFactory.getInstance().getBO(BOType.COURSE);
    private ManageCourseBO manageCourseBO = BOFactory.getInstance().getBO(BOType.MANAGECOURSE);
    private Object Course;

    public void initialize() throws Exception {

        colRegisterId.setCellValueFactory(new PropertyValueFactory<>("registerId"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("program"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        lastId();
        List<String> ids = courseBO.getAllCourseId();
        cmbProgramId.setItems(FXCollections.observableArrayList(ids));

        List<String> SIds = studentBO.getAllStudentId();
        cmbStudentId.setItems(FXCollections.observableArrayList(SIds));

        cmbStudentId.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setStudentData( newValue);
                    } catch (Exception throwables) {
                        throwables.printStackTrace();
                    }
                });

        cmbProgramId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setCustomerData( newValue);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    private void setStudentData(String Code) throws Exception {

        StudentDTO s= studentBO.findStudent(Code);
        if (s == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
            txtName.setText(s.getName());
            txtAddress.setText(s.getAddress());
            txtBirthday.setText(s.getBirthday());
            txtNIC.setText(s.getNic());
            txtSchool.setText(s.getSchool());
            txtTelephoneNumber.setText(s.getTelephoneNumber());
        }
    }

    private void setCustomerData(String Id) throws Exception {
        CourseDTO c=courseBO.findCourse(Id);
        if (c == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
            txtProgram.setText(c.getProgram());
            txtDuration.setText(c.getDuration());
            txtFee.setText(String.valueOf(c.getCourseFee()));
        }
    }


    public void lastId() throws Exception {
        String Id = manageCourseBO.getLastRegisterId();;
        String finalId = "R-001";

        if (Id != null) {

            String[] splitString = Id.split("-");
            int id = Integer.parseInt(splitString[1]);
            id++;

            if (id < 10) {
                finalId = "R-00" + id;
            } else if (id < 100) {
                finalId = "R-0" + id;
            } else {
                finalId = "R-" + id;
            }
            lblRegisterId.setText(finalId);
        } else {
            lblRegisterId.setText(finalId);
        }
    }

    private void calculateTotal() {
        Double total = 0.00;
        for (ManageCourseTm detail : tblManageCourse.getItems()) {
            total = detail.getFee();
        }
        lblTotal.setText(String.valueOf(total));
    }

    public void registerCourseOnAction(MouseEvent mouseEvent) throws Exception {
        List<Course>  courseArrayList= new ArrayList<>();

        courseArrayList.add((entity.Course) Course);
        Course course=new Course(
                cmbProgramId.getSelectionModel().getSelectedItem(),
                txtProgram.getText(),
                txtDuration.getText(),
                Double.valueOf(lblTotal.getText())
        );
        Student student = new Student(
                cmbStudentId.getSelectionModel().getSelectedItem(),
                txtName.getText(),
                txtAddress.getText(),
                txtNIC.getText(),
                txtSchool.getText(),
                txtTelephoneNumber.getText(),
                txtBirthday.getText()
        );

        ManageCourseDTO registration = new ManageCourseDTO(lblRegisterId.getText(),student.getName(),course.getCourseId(),course.getCourseFee(),student, courseArrayList);
        boolean saved =manageCourseBO.ManageCourse(registration);
        if (saved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Registered", ButtonType.OK).show();
            lastId();
            cmbProgramId.getSelectionModel().clearSelection();
            txtProgram.clear();
            txtDuration.clear();
            txtFee.clear();
            cmbStudentId.getSelectionModel().clearSelection();
            txtName.clear();
            txtAddress.clear();
            txtNIC.clear();
            txtSchool.clear();
            txtTelephoneNumber.clear();
            txtBirthday.clear();

        }else{
            new Alert(Alert.AlertType.CONFIRMATION, "Not Registered", ButtonType.OK).show();
        }

    }

    public void addCourseOnAction(MouseEvent mouseEvent) {
        String registerId= lblRegisterId.getText();
        String studentId=cmbStudentId.getSelectionModel().getSelectedItem();
        String courseId=cmbProgramId.getSelectionModel().getSelectedItem();
        String program=txtProgram.getText();
        String duration=txtDuration.getText();
        Double fees= Double.valueOf(txtFee.getText());
        String name=txtName.getText();

        tblManageCourse.getItems().add(new ManageCourseTm(registerId,studentId,name,courseId,program,duration,fees));
        calculateTotal();

        cmbProgramId.getSelectionModel().clearSelection();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
    }
}
