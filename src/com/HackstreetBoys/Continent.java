package com.HackstreetBoys;

import java.util.HashMap;

public class Continent {
    private String name;

    HashMap<Integer, Country> countries;
    int nrCountries;

    public Continent(String name) {
        this.name = name;
        countries = new HashMap<>();
        nrCountries = 0;
    }

    void addCountry(Country country) {
        countries.put(country.getID(), country);
        nrCountries++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

