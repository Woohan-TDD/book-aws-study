package com.book.aws.around.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.book.aws.around.dto.SecretResponse;
import com.book.aws.around.service.SecretService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SecretController {

    private final SecretService secretService;

    @GetMapping("/secret")
    public String secret(Model model) {
        final SecretResponse secretResponse = secretService.readSecret();
        model.addAttribute("secrets", secretResponse);
        return "secret";
    }
}
