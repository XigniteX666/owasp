package com.jumbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping("/widercasting")
    public long cast(@RequestParam(value = "number") int number) {
        long result = number *number;
        return number * number;
    }
    @GetMapping("/input")
    public int userControlledData(@RequestParam(value="number") String input){
        int data;

        if (input != null) {
            data = Integer.parseInt(input.trim());
        } else {
            data = 0;
        }

        return data * 10;
    }
}
