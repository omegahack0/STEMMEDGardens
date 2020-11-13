package com.tutorialtwo.tutorialtwo.controller;

import com.tutorialtwo.tutorialtwo.domain.UsdaInfo;
import com.tutorialtwo.tutorialtwo.UserZipcode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

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
        model.addAttribute("UserZipcodeObj", new UserZipcode());
        //need to add try catch statement to verify user input
        return "getUserZipcode";
    }

    @PostMapping("/GetUserZipcode")
    public String zipcodeSubmit(@ModelAttribute UserZipcode userZip, Model model) throws IOException {
        String userUSDAZone = UsdaInfo.getUSDAZone(userZip.zipcode);
        model.addAttribute("UserZipcodeObj", userZip);
        model.addAttribute("UserUSDAZoneObj", userUSDAZone);//the problem child
        return "result";

    }
}
