package com.app.kalkulator.models;

import java.util.*;

import com.app.kalkulator.DividedByZeroException;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DzialanieDto {
    private String operator;

    // @Digits(message = "First field is not a digit which has maximum 10 integral digits for the number and maximum 15 fractional digits for the number, please put a digit", integer = 10, fraction = 15)
    @NotEmpty(message = "First field is not filled, please put a digit")
    private String liczba1;

    @NotEmpty(message = "Second field is not filled, please put a digit")
    private String liczba2;
}