package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdminFormController {
    public AnchorPane adminAnchorPaneContext;
    public AnchorPane adminMainAnchorPaneContext;

    public void onManageCourses(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../views/AddNewCourseForm.fxml");
        Parent load = FXMLLoader.load(resource);
        adminAnchorPaneContext.getChildren().clear();
        adminAnchorPaneContext.getChildren().add(load);
    }

    public void onStudentDetails(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../views/StudentDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        adminAnchorPaneContext.getChildren().clear();
        adminAnchorPaneContext.getChildren().add(load);
    }

    public void onBackToDashBord(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage) adminMainAnchorPaneContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/DashBordForm.fxml"))));
    }
}
