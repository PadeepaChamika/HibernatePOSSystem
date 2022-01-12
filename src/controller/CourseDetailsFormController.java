package controller;

import bo.BOFactory;
import bo.BOType;
import bo.custom.impl.CourseBOImpl;
import dto.CourseDTO;
import entity.tm.CourseTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.Optional;

public class CourseDetailsFormController {
    public TableView<CourseTm> tblCourseDetails;
    public TableColumn colCourseId;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFees;

    CourseBOImpl courseBOImpl = BOFactory.getInstance().getBO(BOType.COURSE);


    public void initialize(){
        findAll();
        setCellValueFactory();
    }


    private void setCellValueFactory(){
        colCourseId.setCellValueFactory(new PropertyValueFactory("courseId"));
        colProgram.setCellValueFactory(new PropertyValueFactory("program"));
        colDuration.setCellValueFactory(new PropertyValueFactory("duration"));
        colFees.setCellValueFactory(new PropertyValueFactory("courseFee"));
    }

    public void findAll(){
        try {
            ObservableList<CourseTm> tmList = FXCollections.observableArrayList();
            List<CourseDTO> all = courseBOImpl.findAll();
            for(CourseDTO dto : all){
                Button btn = new Button("Delete");
                CourseTm tm = new CourseTm(
                        dto.getCourseId(),
                        dto.getProgram(),
                        dto.getDuration(),
                        dto.getCourseFee(),
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
                            if (courseBOImpl.delete(tm.getCourseId())) {
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
            tblCourseDetails.setItems(tmList);
        } catch (Exception e) {
        }
    }



}
