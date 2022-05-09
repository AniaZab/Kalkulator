package com.app.kalkulator.mappers;

import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class mapperDzialanie {
    public static double ConvertStringToDouble(String liczba) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(liczba,Double.class);
    }
}
