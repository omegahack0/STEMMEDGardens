package com.tutorialtwo.tutorialtwo.controller;

import com.tutorialtwo.tutorialtwo.domain.Book;
import com.tutorialtwo.tutorialtwo.handlingformsubmission;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TutorialController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("appName", appName);
        return "home";
    }
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new handlingformsubmission());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute handlingformsubmission greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }


}

//    Book book = new Book();
//        book.setTitle(randomAlphabetic(10));
//                book.setAuthor(randomAlphabetic(15));
//                return book;