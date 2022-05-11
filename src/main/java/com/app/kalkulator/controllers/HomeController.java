package com.app.kalkulator.controllers;

import com.app.kalkulator.Exceptions.DividedByZeroException;
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
        model.addAttribute("dzialanie", new Dzialanie());
        model.addAttribute("innyKolor", "black");
        return "mainPage";
    }
    @PostMapping
    public String calculate(Model model, @Valid Dzialanie dzialanie, Errors errors, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            MeetAnError(model);
            return "mainPage";
            /*if(bindingResult.hasErrors()){
            String[] fields = {"liczba1", "liczba2"};

            for (String field : fields) {
                if (errors.hasFieldErrors(field)) {
                    model.addAttribute("wynikRownania", "Error");
                    model.addAttribute("innyKolor", "red");
                    model.addAttribute("error", Objects.requireNonNull(errors.getFieldError(field)).getDefaultMessage());
                }
            }
            return "mainPage";*/
        }
        try{
            double wynik = dzialanie.ObliczWynik();
            model.addAttribute("innyKolor", "black");
            model.addAttribute("wynikRownania", wynik);
        }
        catch(DividedByZeroException e){
            MeetAnError(model);
            model.addAttribute("error", e.getMessage());
        }
        return "mainPage";
    }
    public void MeetAnError(Model model){
        model.addAttribute("innyKolor", "red");
        model.addAttribute("wynikRownania", "Error");
    }
}