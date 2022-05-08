package com.app.kalkulator.mappers;

import org.springframework.stereotype.Component;

@Component
public class mapperDzialanie {
    public static double ConvertStringToDouble(String liczba) {
        return Double.parseDouble(liczba);
    }
}
