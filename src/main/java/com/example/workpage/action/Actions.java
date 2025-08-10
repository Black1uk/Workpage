package com.example.workpage.action;

import com.example.workpage.LoginApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Actions {
    public void nextpage(ActionEvent actionEvent,String stagename , String stagetitle ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource(stagename));
        Scene scene = new Scene(fxmlLoader.load(), 750, 600);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle(stagetitle);
        stage.setScene(scene);
        stage.show();
    }
}
