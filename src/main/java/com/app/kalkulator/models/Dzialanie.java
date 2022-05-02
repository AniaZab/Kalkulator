package com.app.kalkulator.models;

import java.util.*;

public class Dzialanie {
    List<String> operatory = new ArrayList<String>();
    List<Double> liczby = new ArrayList<Double>();

    public Dzialanie(String dzialanie) {
        MakeDzialanie(dzialanie);
    }
    public String ZwrocOperatory(){

        return String.join("",operatory);
    }
    private void MakeDzialanie(String dzialanie){
        String[] wyrazy = dzialanie.split("[*/+-]");
        for(int i = 0; i<wyrazy.length;i++){
            liczby.add(Double.parseDouble(wyrazy[i]));
        }
        String[] _operatory = {"+", "-", "*", "/"};
        /*
        int index = 0;
        while(index<4){
            while(dzialanie.contains(operatory[index])){
            }
            index++;
        }*/
        for(int i = 0; i<4; i++){
            if(dzialanie.contains(_operatory[i])){
                operatory.add("operatory[i]");
            }
        }
    }
}
