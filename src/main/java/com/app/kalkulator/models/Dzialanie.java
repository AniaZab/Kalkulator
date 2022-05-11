package com.app.kalkulator.models;

import com.app.kalkulator.Exceptions.DividedByZeroException;
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

    public double ObliczWynik() throws DividedByZeroException {
        /*if (Objects.isNull(liczba1)) {
            return 0;
        }*/
        double wynik = 0;
        switch (operator) {
            case "+":
                wynik = liczba1 + liczba2;
                break;
            case "-":
                wynik = liczba1 - liczba2;
                break;
            case "*":
                wynik = liczba1 * liczba2;
                break;
            case "/":
                if (liczba2 != 0) {
                    wynik = liczba1 / liczba2;
                } else {
                    throw new DividedByZeroException("You can't divide by 0!");
                }
                break;
        }
        return wynik;
    }
}
/*

    top: 20%;
            left: 50%;
            transform: translate(-50%, 0%);*/
