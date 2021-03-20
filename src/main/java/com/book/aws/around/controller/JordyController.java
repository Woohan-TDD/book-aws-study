package com.book.aws.around.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JordyController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
