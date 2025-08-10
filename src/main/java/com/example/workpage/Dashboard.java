package com.example.workpage;

import com.example.workpage.action.Actions;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class Dashboard {

    public AnchorPane container;

    public void onengineer(ActionEvent actionEvent) throws IOException {
        AnchorPane engine = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("medicalaids.fxml")));
        container.getChildren().setAll(engine);
    }

    public void onscience(ActionEvent actionEvent) throws IOException {
        AnchorPane engine = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("anti_malaria.fxml")));
        container.getChildren().setAll(engine);
    }

    public void onlab(ActionEvent actionEvent) throws IOException {
        AnchorPane engine = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sex_wellness.fxml")));
        container.getChildren().setAll(engine);
    }

    public void onbusiness(ActionEvent actionEvent) throws IOException {
        AnchorPane engine = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("herbal.fxml")));
        container.getChildren().setAll(engine);
    }

    public void onsignout(ActionEvent actionEvent) throws IOException {
        new Actions().nextpage(actionEvent,"login.fxml","Login");
    }

    public void preview(ActionEvent actionEvent) {
    }
}
