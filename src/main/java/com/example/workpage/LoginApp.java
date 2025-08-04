package com.example.workpage;

import com.example.workpage.DBSAccess.DBSAccess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Login Page!");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        try{
            DBSAccess.DBSaccess();
            System.out.println("connection successful");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        launch();
    }
}







