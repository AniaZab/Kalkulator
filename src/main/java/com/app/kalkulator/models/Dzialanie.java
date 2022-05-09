package com.app.kalkulator.models;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Data
public class Dzialanie {
    private String operator;
    @Digits(message = "First field is not a digit which has maximum 10 integral digits for the number and maximum 15 fractional digits for the number, please put a digit", integer = 10, fraction = 15)
    @NotEmpty(message = "First field is not filled, please put a number")
    private double liczba1;
    @Digits(message = "First field is not a digit which has maximum 10 integral digits for the number and maximum 15 fractional digits for the number, please put a digit", integer = 10, fraction = 15)
    @NotEmpty(message = "Second field is not filled, please put a number")
    private double liczba2;

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
