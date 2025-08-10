package com.example.workpage;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Books {
    private final SimpleIntegerProperty number;
    private final SimpleStringProperty bookname;
    private final SimpleStringProperty author;

    public String getBookname() {
        return bookname.get();
    }

    public int getNumber() {
        return number.get();
    }

    public String getAuthor() {
        return author.get();
    }



    public Books(int number, String bookname, String author) {
        this.number = new SimpleIntegerProperty(number);
        this.bookname =new SimpleStringProperty(bookname);
        this.author = new SimpleStringProperty(author);
    }

    public SimpleIntegerProperty numberProperty() {
        return number;
    }

    public SimpleStringProperty booknameProperty() {
        return bookname;
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }


}
