package com.example.workpage;

import com.example.workpage.Aut.AuthService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button buttonClick;


    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.show();
    }

    public void userlogin(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String fetchusername = "";
        String fetchpassword = "";

        if(username.isEmpty() || password.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Input Error");
            alert.setContentText("check username and password");
            alert.showAndWait();
            return;
        }

        boolean nam = new AuthService().login(username,password);
        if (nam){
            FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("HomePage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Login Page!");
            stage.setScene(scene);
            stage.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Input Error");
            alert.setContentText(" username and password not found");
            alert.showAndWait();

        }

    }
}