package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import dto.StudentDTO;
import entity.tm.CourseTm;
import entity.tm.StudentTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.Optional;

public class AddNewStudentFormController {
    public JFXTextField txtStudentId;
    public JFXTextField txtName;
    public JFXTextField txtBirthday;
    public JFXTextField txtAddress;
    public JFXTextField txtNIC;
    public JFXTextField txtSchool;
    public JFXTextField txtTelephoneNumber;
    public TableView<StudentTm> tblNewStudentDetails;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colBirthday;
    public TableColumn colNIC;
    public TableColumn colSchool;
    public TableColumn colAddress;
    public TableColumn colTelephoneNumber;
    public TableColumn colDelete;

    StudentBOImpl studentBOImpl = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize(){
        tableListener();
        setCellValueFactory();
        findAll();
    }

    private void setCellValueFactory(){
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colSchool.setCellValueFactory(new PropertyValueFactory<>("school"));
        colTelephoneNumber.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    private void tableListener(){
        tblNewStudentDetails.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                        setData(newValue);
                } );
    }

    private void setData(StudentTm tm){
        try {
            txtStudentId.setText(tm.getStudentId());
            txtName.setText(tm.getName());
            txtBirthday.setText(tm.getBirthday());
            txtAddress.setText(tm.getAddress());
            txtNIC.setText(tm.getNic());
            txtSchool.setText(tm.getSchool());
            txtTelephoneNumber.setText(tm.getTelephoneNumber());

        }catch (Exception e){

        }
    }

    public void findAll(){
        try{
            ObservableList<StudentTm> sTmList = FXCollections.observableArrayList();
            List<StudentDTO> all = studentBOImpl.findAll();
            for (StudentDTO dto : all){
                Button btn = new Button("Delete");
                StudentTm tm = new StudentTm(
                        dto.getStudentId(),
                        dto.getName(),
                        dto.getBirthday(),
                        dto.getAddress(),
                        dto.getNic(),
                        dto.getSchool(),
                        dto.getTelephoneNumber(),
                        btn
                );
                sTmList.add(tm);
                btn.setOnAction(e -> {
                    try {

                        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?", ok,no);
                        Optional<ButtonType> result = alert.showAndWait();
                        if(result.orElse(no)==ok){
                            if(studentBOImpl.delete(tm.getStudentId())){
                                new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK).show();
                                findAll();
                                return;
                            }
                            new Alert(Alert.AlertType.WARNING,"Try Again", ButtonType.OK).show();
                        }else {

                        }

                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                });
            }
            tblNewStudentDetails.setItems(sTmList);

        }catch (Exception e){

        }
    }

    public void addNewStudentOnAction(MouseEvent mouseEvent) {
        String id = txtStudentId.getText();
        String name = txtName.getText();
        String birthday = txtBirthday.getText();
        String address = txtAddress.getText();
        String nic = txtNIC.getText();
        String school = txtSchool.getText();
        String telephoneNumber = txtTelephoneNumber.getText();

        try{
            boolean add = studentBOImpl.add(new StudentDTO(id, name, birthday, address, nic, school, telephoneNumber));
            if (add){
                new Alert(Alert.AlertType.CONFIRMATION,"Done").showAndWait();
                findAll();
                txtStudentId.clear();
                txtName.clear();
                txtBirthday.clear();
                txtAddress.clear();
                txtNIC.clear();
                txtSchool.clear();
                txtTelephoneNumber.clear();
            }

        }catch (Exception e){
            e.printStackTrace();
           new Alert(Alert.AlertType.ERROR,"Try Again").showAndWait();
        }
    }

    public void updateStudentOnAction(MouseEvent mouseEvent) {
        String id = txtStudentId.getText();
        String name = txtName.getText();
        String birthday = txtBirthday.getText();
        String address = txtAddress.getText();
        String nic = txtNIC.getText();
        String school = txtSchool.getText();
        String telephoneNumber = txtTelephoneNumber.getText();

        try {
            if(studentBOImpl.update(new StudentDTO(
                    id,name,birthday,address,nic,school,telephoneNumber
            ))){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated").showAndWait();
                findAll();
                txtStudentId.clear();
                txtName.clear();
                txtBirthday.clear();
                txtAddress.clear();
                txtNIC.clear();
                txtSchool.clear();
                txtTelephoneNumber.clear();
            }else{
                new Alert(Alert.AlertType.ERROR,"Not Update, Try Again").show();
            }

        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Not Update, Try Again").show();
        }

    }
}
