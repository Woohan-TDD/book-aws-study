package com.book.aws.around.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JordyController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
