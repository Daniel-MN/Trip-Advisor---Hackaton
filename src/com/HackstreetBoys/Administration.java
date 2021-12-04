package com.HackstreetBoys;

import java.util.HashMap;

public class Administration {
    private static Database database;

    public Administration() {
        this.database = new Database();
    }

    public static Country searchCountry(String name) {
        HashMap<Integer, Country> countries = database.getCountries();
        for (Country country : countries.values()) {
            if (country.getName().equals(name)) {
                return country;
            }
        }
        return null;
    }
}
