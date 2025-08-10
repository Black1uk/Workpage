package com.example.workpage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Business implements Initializable {

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
                new Drugs(1, "java", "alice@example.com"),
                new Drugs(2, "Basic electronic", "bob@example.com"),
                new Drugs(3, "Network maintenance", "carol@example.com")

        );

        T_view.setItems(data);

    }

    public void addbooks(ActionEvent actionEvent) {
        Drugs selectedBook = (Drugs) T_view.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setContentText(" Select at least one item");
        alert.showAndWait();
        if (selectedBook != null) {
            int number = selectedBook.getNumber();
            String drugname = selectedBook.getDrugname();
            String author = selectedBook.getAuthor();

            String query = "INSERT INTO books(name,author)";
        }


    }
}
