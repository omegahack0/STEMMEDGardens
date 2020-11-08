package com.tutorialtwo.tutorialtwo.controller;

import com.tutorialtwo.tutorialtwo.userZipcode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TutorialController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("appName", appName);
        return "home";
    }
    @GetMapping("/GetUserZipcode")
    public String zipcodeForm(Model model) {
        model.addAttribute("GetUserZipcode", new userZipcode());
        //need to add try catch statement to verify user input
        return "GetUserZipcode";
    }

    @PostMapping("/GetUserZipcode")
    public String zipcodeSubmit(@ModelAttribute userZipcode userZip, Model model) {
        model.addAttribute("GetUserZipcode", userZip);
        return "result";

    }
}
