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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @GetMapping
    //@RequestMapping(value = "", method = RequestMethod.GET)
    public String calculate(Model model){
        model.addAttribute("dzialanie", new DzialanieDto());
        model.addAttribute("innyKolor", "black");
        return "mainPage";
    }
    @PostMapping
    //@RequestMapping(value = "", method = RequestMethod.POST)
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
//
// th:style="|${innyKolor == 'red' ? 'color: red;' : 'color: black;'}|"
        return "mainPage";
    }
    public void MeetAnError(Model model, String message){
        //model.addAttribute("innyKolor", "red");
        model.addAttribute("wynikRownania", "Error");
        model.addAttribute("error", message);
    }
}
