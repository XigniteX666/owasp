package com.jumbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class errorController {

    @GetMapping("/widercasting")
    public long cast(@RequestParam(value = "number") int number) {
        long result = number *number;
        return result;
    }

}
