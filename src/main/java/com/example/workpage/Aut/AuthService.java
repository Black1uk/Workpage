package com.example.workpage.Aut;

import com.example.workpage.DBSAccess.DBSAccess;
/*import com.example.workpage.Users;*/

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

    public void Register(String username, String password, String email, int phoneNumber) {
        try {
            String query = "INSERT INTO users (name, password,email,phoneNumber) VALUES (?, ?,?,?)";
            PreparedStatement stmt = DBSAccess.DBSaccess().prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, String.valueOf(phoneNumber));
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
