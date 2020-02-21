package com.jumbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CookieController {

    @GetMapping("/setcookie")
    public String setCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("someKey", "someValue");

        response.addCookie(cookie);

        return "cookie set";
    }
}
