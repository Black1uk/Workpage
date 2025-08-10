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

public class Anit_Malaria implements Initializable {
    @FXML
    public TableView T_view;
    public TableColumn<Drugs, Integer> numbercolumn;
    public TableColumn<Drugs,String> drugscolumn;
    public TableColumn<Drugs,String> authorcolumn;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numbercolumn.setCellValueFactory(cell -> cell.getValue().numberProperty().asObject());
        drugscolumn.setCellValueFactory(cell -> cell.getValue().drugnameProperty());
        authorcolumn.setCellValueFactory(cell -> cell.getValue().authorProperty());

        ObservableList<Drugs> data = FXCollections.observableArrayList(
                new Drugs(1, "Lufart DS", "alice@example.com"),
                new Drugs(2, "Lonart DS", "bob@example.com"),
                new Drugs(3, "Coartem", "carol@example.com"),
                new Drugs(4, "Lumatrona", "carol@example.com"),
                new Drugs(5, "Aquanmal Suspension", "carol@example.com"),
                new Drugs(6, "Doxy 100", "carol@example.com"),
                new Drugs(7, "Malarone", "carol@example.com"),
                new Drugs(8, "Monodox", "carol@example.com")
        );

        T_view.setItems(data);
    }
    public void addbooks(ActionEvent actionEvent) {

    }
}
