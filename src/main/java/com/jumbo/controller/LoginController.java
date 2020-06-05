package com.jumbo.controller;

import com.jumbo.domain.Credentials;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @PostMapping("/login")
    public boolean validateUsername(@RequestBody Credentials credentials) {

     if(credentials.getUsername().equals("oskar") && credentials.getPassword().equals("teset")){
         return true;
     }else{
         return false;
     }
    }
}
