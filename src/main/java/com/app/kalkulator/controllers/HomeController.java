package com.app.kalkulator.controllers;

import com.app.kalkulator.models.Dzialanie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class HomeController {
    @GetMapping
    public String calculate(Model model){
        model.addAttribute("cos", "0");
        model.addAttribute("dzialanie", new Dzialanie());
        return "mainPage";
    }
    @PostMapping
    public String calculate(Model model, @Valid Dzialanie dzialanie, Errors errors, BindingResult bindingResult){
        model.addAttribute("cos", "0");
        if(bindingResult.hasErrors()){
            String[] fields = {"liczba1", "liczba2"};

            for (String field : fields) {
                if (errors.hasFieldErrors(field)) {
                    model.addAttribute("wynikRownania", Objects.requireNonNull(errors.getFieldError(field)).getDefaultMessage());
                }
            }
            return "mainPage";
        }
        model.addAttribute("wynikRownania", dzialanie.ObliczWynik());
        return "mainPage";
    }
}
