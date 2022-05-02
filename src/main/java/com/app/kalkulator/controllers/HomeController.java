package com.app.kalkulator.controllers;

import com.app.kalkulator.models.Dzialanie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping
    public String main(Model model){
        model.addAttribute("cos", "0");
        return "mainPage";
    }
    @PostMapping("/")
    public String result(@ModelAttribute("dzialanie") Dzialanie dzialanie){
        return "mainPage";
    }
}
