package com.app.kalkulator.models;

import java.util.*;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class Dzialanie {
    private String operator;
    @NotEmpty(message = "First field is not filled, please put a number")
    private double liczba1;
    @NotEmpty(message = "Second field is not filled, please put a number")
    private double liczba2;

    /*public Dzialanie(String _operator, double _liczba1, double _liczba2) {
        liczba1 = _liczba1;
        liczba2 = _liczba2;
        operator = _operator;
        ObliczWynik();
    }*/
    public double ObliczWynik(){
        double wynik = 0;
        switch(operator){
            case "+":
                wynik = liczba1+liczba2;
                break;
            case "-":
                wynik = liczba1-liczba2;
                break;
            case "*":
                wynik = liczba1*liczba2;
                break;
            case "/":
                wynik = liczba1/liczba2;
                break;
        }
        return wynik;
    }
}
