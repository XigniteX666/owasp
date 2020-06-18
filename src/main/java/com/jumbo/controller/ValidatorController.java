package com.jumbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class ValidatorController {

    @GetMapping("/validateUsername")
    public boolean validateUsername(@RequestParam(value = "username") String userName) {

        long StartTime = System.currentTimeMillis();
        boolean result = false;
        String regex = "(a+)+b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher =  pattern.matcher(userName);


        if(matcher.find()){
            result =true;
        }else{

        }

        System.out.println("Time in ms: " + (System.currentTimeMillis() - StartTime));
        return result;
    }

    private void doNothing(String s){

    }

}

