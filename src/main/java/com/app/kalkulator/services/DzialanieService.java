package com.app.kalkulator.services;

import com.app.kalkulator.DividedByZeroException;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class DzialanieService {

    public static double ObliczWynik(String operator, double liczba1, double liczba2) throws DividedByZeroException {
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
