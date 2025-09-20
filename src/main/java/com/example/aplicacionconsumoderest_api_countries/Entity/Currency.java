package com.example.aplicacionconsumoderest_api_countries.Entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Currency {

    private String name;
    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
