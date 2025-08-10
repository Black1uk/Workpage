package com.example.workpage;

import com.example.workpage.Aut.AuthService;
import com.example.workpage.action.Actions;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Signupcontroller {

    public TextField UserName;
    public TextField emailField;
    public TextField numberField;
    public TextField password;

    public void onclicksignup(ActionEvent actionEvent) {
        String name = UserName.getText();
        String email = emailField.getText();
        String number = numberField.getText();
        String passwordvalue = password.getText();

        if (name == null || name.isEmpty() || email == null || email.isEmpty() || number == null ||  number.isEmpty() || passwordvalue == null || passwordvalue.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Input Error");
            alert.setContentText("Please fill in all the fields");
            alert.showAndWait();
            return;
        }

        try{
            new AuthService().Register(name,passwordvalue,email, Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

    }

    public void onclicklogin(ActionEvent actionEvent) throws IOException {
        new Actions().nextpage(actionEvent,"login.fxml","homepage");
    }
}
