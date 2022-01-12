package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.StudentBOImpl;
import dto.StudentDTO;
import entity.tm.StudentTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.Optional;

public class StudentDetailsFormController {
    public TableView <StudentTm>tblStudentDetails;
    public TableColumn colStID;
    public TableColumn colName;
    public TableColumn ColBirth;
    public TableColumn colNIc;
    public TableColumn colAddress;
    public TableColumn colSchool;
    public TableColumn colTp;
    StudentBOImpl studentBOImpl = BOFactory.getInstance().getBO(BOType.STUDENT);


    public void initialize(){
        findAll();
        setCellValueFactory();
    }


    private void setCellValueFactory(){
        colStID.setCellValueFactory(new PropertyValueFactory("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colNIc.setCellValueFactory(new PropertyValueFactory("nic"));
        colSchool.setCellValueFactory(new PropertyValueFactory("school"));
        colTp.setCellValueFactory(new PropertyValueFactory("telephoneNumber"));
        ColBirth.setCellValueFactory(new PropertyValueFactory("birthday"));

    }

    public void findAll(){
        try {
            ObservableList<StudentTm> tmList = FXCollections.observableArrayList();
            List<StudentDTO> all = studentBOImpl.findAll();
            for(StudentDTO dto : all){
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
                tmList.add(tm);
                btn.setOnAction((e) -> {
                    try {

                        ButtonType ok = new ButtonType("OK",
                                ButtonBar.ButtonData.OK_DONE);
                        ButtonType no = new ButtonType("NO",
                                ButtonBar.ButtonData.CANCEL_CLOSE);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "Are You Sure ?", ok, no);
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.orElse(no) == ok) {
                            if (studentBOImpl.delete(tm.getStudentId())) {
                                new Alert(Alert.AlertType.CONFIRMATION,
                                        "Deleted", ButtonType.OK).show();
                                findAll();
                                return;
                            }
                            new Alert(Alert.AlertType.WARNING,
                                    "Try Again", ButtonType.OK).show();
                        } else {

                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });
            }
            tblStudentDetails.setItems(tmList);
        } catch (Exception e) {
        }
    }


}
