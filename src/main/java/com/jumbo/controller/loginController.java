package com.jumbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;


public class loginController {

    @GetMapping("/login")
    public boolean login(@RequestParam(value = "username" ) String userName, @RequestParam(value="password") String password){
        String regex = "(a+)+b";
        if(userName.matches(regex)){
            String query = "SELECT * from users where username = " + userName + " AND password = " + password;

            String url = "jdbc:msql://localhost/Demo";
            Connection conn;

            try {
                conn = DriverManager.getConnection(url,"","");
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(query);

                conn.close();
                while ( rs.next() ) {
                    String lastName = rs.getString("Lname");
                    System.out.println(lastName);
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
