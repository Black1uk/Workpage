package com.example.workpage.DBSAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBSAccess {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "WashingtonDC@123";
    private static final String DATABASE_NAME = "schoolsystem";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;



    public static Connection DBSaccess() {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return  connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

}
