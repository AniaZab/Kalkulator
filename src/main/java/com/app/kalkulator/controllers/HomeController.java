package com.app.kalkulator.controllers;

import com.app.kalkulator.DividedByZeroException;
import com.app.kalkulator.mappers.mapperDzialanie;
import com.app.kalkulator.models.DzialanieDto;
import com.app.kalkulator.services.DzialanieService;
import com.app.kalkulator.validators.ValidatorDzialanie;
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
        model.addAttribute("dzialanie", new DzialanieDto());
        model.addAttribute("innyKolor", "black");
        return "mainPage";
    }
    @PostMapping
    public String calculate(Model model, @Valid DzialanieDto dzialanie, Errors errors, BindingResult bindingResult){
        String liczba1 = dzialanie.getLiczba1();
        String liczba2 = dzialanie.getLiczba2();

        if(ValidatorDzialanie.CanConvertStringToDouble(liczba1) && ValidatorDzialanie.CanConvertStringToDouble(liczba2)){
            try{
                double wynik = DzialanieService.ObliczWynik(dzialanie.getOperator(), mapperDzialanie.ConvertStringToDouble(liczba1), mapperDzialanie.ConvertStringToDouble(liczba2));
                model.addAttribute("innyKolor", "black");
                model.addAttribute("wynikRownania", wynik);
            }
            catch(DividedByZeroException e){
                MeetAnError( model,  e.getMessage());
            }
        }
        /*
        dac w template classe kolr by zmienialo kolor jak jest error - przyklad w str. od javy
        zmienic w Dzialanie Double i metode przeniesc do nowej klasy Servisu
1. validator - spr czy da sie zrobic convert
2. jesli tak to do mappera na double
3. Controller obsluguje validator i mapper
4. potem wywoluje service
         */

        return "mainPage";
    }
    public void MeetAnError(Model model, String message){
        model.addAttribute("innyKolor", "red");
        model.addAttribute("wynikRownania", "Error");
        model.addAttribute("error", message);
    }
}
