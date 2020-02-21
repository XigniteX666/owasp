package com.jumbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.Socket;

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

    public void test(Socket socket){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(socket.getInputStream()); //unsafe
        }catch (Exception e){

        }
    }
}
