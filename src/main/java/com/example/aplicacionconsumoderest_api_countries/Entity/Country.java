package com.example.aplicacionconsumoderest_api_countries.Entity;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Country {

    private Name name;
    private List<String> capital;
    private String region;
    private String subregion;
    //Usamos un Map para obtener los currencies(monedas) con keys variables según el país
    //Para ello se pasa la clase Currency (moneda) que tiene los campos name y symbol según el JSON (ver clase)
    private Map<String, Currency> currencies;
    //De forma similar también para los lenguajes
    private Map<String, String> languages;
    //Latitud y longitud como lista de enteros
    private List<Integer> latlng;
    private int area;
    private int population;
}
