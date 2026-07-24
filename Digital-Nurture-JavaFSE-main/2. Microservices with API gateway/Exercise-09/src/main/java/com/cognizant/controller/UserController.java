package com.cognizant.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, Object> details = new HashMap<>();
        if (principal != null) {
            details.put("name", principal.getAttribute("name"));
            details.put("email", principal.getAttribute("email"));
            details.put("id", principal.getName());
        }
        return details;
    }
}
