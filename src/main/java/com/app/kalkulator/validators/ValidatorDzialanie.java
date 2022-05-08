package com.app.kalkulator.validators;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
@Component
public class ValidatorDzialanie {
    public static boolean CanConvertStringToDouble(String liczba){
        try{
            Double.parseDouble(liczba);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
