package com.example.workpage;

import com.example.workpage.DBSAccess.DBSAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.ResourceBundle;

public class Sex_wellness implements Initializable {
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
                new Drugs(1, "DRAGON", "alice@example.com"),
                new Drugs(2, "IMAX DELAY SPRAY", "bob@example.com"),
                new Drugs(3, "LEVON 2", "carol@example.com"),
                new Drugs(4, "COMIT", "carol@example.com"),
                new Drugs(5, "LYDIA POSTPIL", "carol@example.com"),
                new Drugs(6, "POSTINOR 2", "carol@example.com"),
                new Drugs(7, "KISS CONDOM", "carol@example.com"),
                new Drugs(8, "EBONY CONDOM", "carol@example.com"),
                new Drugs(9, "ROUGH RIDER", "carol@example.com")

        );

        T_view.setItems(data);
    }
    public void addbooks(ActionEvent actionEvent) {
        Drugs selectedDrug = (Drugs) T_view.getSelectionModel().getSelectedItem();


        if (selectedDrug == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Input Error");
            alert.setContentText("Select at least one item.");
            alert.showAndWait();
            return;
        }


        String drugname = selectedDrug.getDrugsname();
        String manufacturer = selectedDrug.getManufacturer();
        LocalDateTime dateTime = LocalDateTime.now();


        String query = "INSERT INTO Drugs(name, manufacturer,Date) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = Objects.requireNonNull(DBSAccess.DBSaccess()).prepareStatement(query)) {
            stmt.setString(1, drugname);
            stmt.setString(2, manufacturer);
            stmt.setTimestamp(3, Timestamp.valueOf(dateTime));
            stmt.executeUpdate();


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Drug added successfully.");
            alert.showAndWait();
        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setContentText("Failed to insert drug: " + e.getMessage());
            alert.showAndWait();
            e.printStackTrace(); // For debugging
        }
    }
}
