package com.jumbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class loginController {

    @GetMapping("/login")
    public boolean login(@RequestParam(value = "username") String userName, @RequestParam(value = "password") String password) {

        long StartTime = System.currentTimeMillis();
        boolean result = false;
        String regex = "(a+)+s";
        String regexSafe = "a+s";
        if (userName.matches(regex)) {
            result = true;
        }
        System.out.println("time in ms: " + (System.currentTimeMillis() - StartTime));
        return result;
    }

    @GetMapping("/userlookup")
    public boolean searchUser(@RequestParam(value = "userid") String userId) {
        String query = "SELECT * from users where userid = " + userId;

        String url = "jdbc:msql://localhost/Demo";
        String dbUser = "";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword); Statement statement = conn.createStatement()) {

            ResultSet rs = statement.executeQuery(query);

            conn.close();
            while (rs.next()) {
                String lastName = rs.getString("Lname");
                System.out.println(lastName);
                rs.close();
                return true;
            }
        }catch (SQLException ex) {
        }
        return false;
    }

}

