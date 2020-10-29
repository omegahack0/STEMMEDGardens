package com.tutorialtwo.tutorialtwo.controller;

import com.tutorialtwo.tutorialtwo.domain.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TutorialController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("appName", appName);
        return "home";
    }
    @GetMapping("/createBook")
    public String saveBook(Model model){
        try {
//            book.save(book);
            model.addAttribute("book", new Book());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "createBook";
//        https://stackoverflow.com/questions/40899494/how-to-get-input-values-from-spring-boot-thyme-leaf-to-java-class
    }
    @PostMapping("/createBook")
    public String saveBook(@ModelAttribute("book") Book book) {

        book.getTitle();
        book.getAuthor();
        return "redirect:someOtherPage";
    }
}
