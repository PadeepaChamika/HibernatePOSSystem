package controller;

import bo.BOFactory;
import bo.BOType;
import bo.SuperBO;
import bo.custom.CourseBO;
import bo.custom.impl.CourseBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.custom.CourseDAO;
import dto.CourseDTO;
import entity.tm.CourseTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.hibernate.sql.Delete;

import java.util.List;
import java.util.Optional;

public class AddNewCourseFormController {
    public JFXTextField txtCourseId;
    public JFXTextField txtProgram;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public TableView <CourseTm> tblCourseDetails;
    public TableColumn colProgramId;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;
    public TableColumn colDelete;

    CourseBOImpl courseBOImpl = BOFactory.getInstance().getBO(BOType.COURSE);

    public void initialize(){
        tableListener();
        findAllCourses();
        setCellValueFactory();
    }

    private void tableListener(){
        tblCourseDetails.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
    }

    private void setData(CourseTm tm){
        try {
            txtCourseId.setText(tm.getCourseId());
            txtProgram.setText(tm.getProgram());
            txtDuration.setText(tm.getDuration());
            txtFee.setText(String.valueOf(tm.getCourseFee()));
        }catch (Exception e){

        }
    }

    private void setCellValueFactory(){
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("program"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("courseFee"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    public void findAllCourses(){
        try{
            ObservableList<CourseTm> cTmList = FXCollections.observableArrayList();
            List<CourseDTO> all = courseBOImpl.findAll();
            System.out.println(all.size());
            for (CourseDTO dto : all){
                Button btn = new Button("Delete");
                CourseTm tm = new CourseTm(
                        dto.getCourseId(),
                        dto.getProgram(),
                        dto.getDuration(),
                        dto.getCourseFee(),
                        btn
                );
                cTmList.add(tm);
                /*System.out.println(cTmList.size());*/
                btn.setOnAction(e -> {
                    try {

                        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?", ok,no);
                        Optional<ButtonType> result = alert.showAndWait();
                        if(result.orElse(no)==ok){
                            if(courseBOImpl.delete(tm.getCourseId())){
                                new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK).show();
                                findAllCourses();
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
            tblCourseDetails.setItems(cTmList);
            setCellValueFactory();

        }catch (Exception e){

        }
    }

    public void addNewCourseOnAction(MouseEvent mouseEvent) {
        String id = txtCourseId.getText();
        String program = txtProgram.getText();
        String duration = txtDuration.getText();
        Double fee = Double.valueOf(txtFee.getText());

        try{
            if (courseBOImpl.add(new CourseDTO(
                    id,program,duration,fee
            )));{
                new Alert(Alert.AlertType.CONFIRMATION,"Done").showAndWait();
                findAllCourses();
                txtCourseId.clear();
                txtProgram.clear();
                txtDuration.clear();
                txtFee.clear();
            }

        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Try Again").showAndWait();
        }

    }

    public void updateCourseOnAction(MouseEvent mouseEvent) {
        String id = txtCourseId.getText();
        String program = txtProgram.getText();
        String duration = txtDuration.getText();
        Double fee = Double.valueOf(txtFee.getText());

        try {
            if(courseBOImpl.update(new CourseDTO(
                    id,program,duration,fee
            ))){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated").showAndWait();
                findAllCourses();
                txtCourseId.clear();
                txtProgram.clear();
                txtDuration.clear();
                txtFee.clear();
            }else{
              new Alert(Alert.AlertType.ERROR,"Not Update, Try Again").show();
            }

        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Not Update, Try Again").show();
        }
    }
}
