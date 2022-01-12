package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class OfficeWorkerFormController {
    public AnchorPane officeWorkerMainAnchorPaneContext;
    public AnchorPane officeWorkerAnchorPaneContext;

    public void OnAddNewStudent(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../views/AddNewStudentForm.fxml");
        Parent load = FXMLLoader.load(resource);
        officeWorkerAnchorPaneContext.getChildren().clear();
        officeWorkerAnchorPaneContext.getChildren().add(load);
    }

    public void OnManageCourses(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../views/ManageCoursesForm.fxml");
        Parent load = FXMLLoader.load(resource);
        officeWorkerAnchorPaneContext.getChildren().clear();
        officeWorkerAnchorPaneContext.getChildren().add(load);
    }

    public void onCoursesDetails(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../views/CourseDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        officeWorkerAnchorPaneContext.getChildren().clear();
        officeWorkerAnchorPaneContext.getChildren().add(load);
    }

    public void onBackToDashBord(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage) officeWorkerMainAnchorPaneContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/DashBordForm.fxml"))));
    }
}
