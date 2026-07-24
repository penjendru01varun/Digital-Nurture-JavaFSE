package com.cognizant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/account")
    public Map<String, String> accountFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "fallback");
        response.put("message", "Account service is temporarily down or slow. Please try again later.");
        return response;
    }
}
