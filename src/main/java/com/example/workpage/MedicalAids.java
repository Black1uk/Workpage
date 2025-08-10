package com.example.workpage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Engineering implements Initializable {

    @FXML
    public TableView T_view;
    public TableColumn<Drugs, Integer> numbercolumn;
    public TableColumn<Drugs,String> drugscolumn;
    public TableColumn<Drugs,String> manufacturer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numbercolumn.setCellValueFactory(cell -> cell.getValue().numberProperty().asObject());
        drugscolumn.setCellValueFactory(cell -> cell.getValue().drugsnameProperty());
        manufacturer.setCellValueFactory(cell -> cell.getValue().manufacturerProperty());

        ObservableList<Drugs> data = FXCollections.observableArrayList(
                new Drugs(1, "java", "alice@example.com"),
                new Drugs(2, "Basic electronic", "bob@example.com"),
                new Drugs(3, "Network maintenance", "carol@example.com")
        );

        T_view.setItems(data);
    }

    public void addbooks(ActionEvent actionEvent) {
    }
}
