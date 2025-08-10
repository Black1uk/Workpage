package com.example.workpage;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Drugs {
    private final SimpleIntegerProperty number;
    private final SimpleStringProperty drugsname;
    private final SimpleStringProperty manufacturer;

    public String getDrugsname() {

        return drugsname.get();
    }

    public int getNumber() {
        return number.get();
    }

    public String getManufacturer() {
        return manufacturer.get();
    }



    public Drugs(int number, String drugname, String author) {
        this.number = new SimpleIntegerProperty(number);
        this.drugsname =new SimpleStringProperty(drugname);
        this.manufacturer = new SimpleStringProperty(author);
    }

    public SimpleIntegerProperty numberProperty() {
        return number;
    }

    public SimpleStringProperty drugsnameProperty() {
        return drugsname;
    }

    public SimpleStringProperty manufacturerProperty() {
        return manufacturer;
    }


}
