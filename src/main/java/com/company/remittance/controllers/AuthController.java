package com.company.remittance.controllers;

import com.company.remittance.dto.CredentialsDto;
import com.company.remittance.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

//    @GetMapping("/login")
//    public String login(Model model, String error, String logout) {
//        if (error != null) {
//            model.addAttribute("error", "Your username or password is invalid");
//        }
//
//        if (logout != null) {
//            model.addAttribute("logout", "You logged out successfully");
//        }
//        model.addAttribute("credentials", new CredentialsDto());
//        return "login";
//    }
}
