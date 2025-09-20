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

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Map<String, Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, Currency> currencies) {
        this.currencies = currencies;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public List<Integer> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Integer> latlng) {
        this.latlng = latlng;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
