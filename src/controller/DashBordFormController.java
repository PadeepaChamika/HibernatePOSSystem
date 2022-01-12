package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class DashBordFormController {
    public JFXTextArea txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane loginAnchorPaneContext;
    public AnchorPane loginHomeAnchorPaneContext;

    public void onHomePages(MouseEvent mouseEvent) throws IOException {
        if (txtUserName.getText().equalsIgnoreCase("Admin")&& txtPassword.getText().equals("A1234")) {
            URL resource = getClass().getResource("../views/AdminForm.fxml");
            Parent load = FXMLLoader.load(resource);
            loginHomeAnchorPaneContext.getChildren().clear();
            loginHomeAnchorPaneContext.getChildren().add(load);
        } else if (txtUserName.getText().equalsIgnoreCase("Worker")&& txtPassword.getText().equals("W1234")) {
            URL resource = getClass().getResource("../views/OfficeWorkerForm.fxml");
            Parent load = FXMLLoader.load(resource);
            loginHomeAnchorPaneContext.getChildren().clear();
            loginHomeAnchorPaneContext.getChildren().add(load);
        }
    }
}
