package com.example.workpage.Aut;

import com.example.workpage.DBSAccess.DBSAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthService {
    private String username;
    private  String password;
    private  int id;


    public boolean login(String username, String password){
        String query = "SELECT * FROM users WHERE name = ? AND password = ?;";
        try{
            PreparedStatement stmt = DBSAccess.DBSaccess().prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet= stmt.executeQuery();


            return resultSet.next();

        } catch (Exception e) {
            System.out.println("LoginException: "+e);

        }
        return false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
