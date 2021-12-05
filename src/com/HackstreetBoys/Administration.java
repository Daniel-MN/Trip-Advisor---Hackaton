package com.HackstreetBoys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Administration {
    private final static Database database = new Database();

    public static Country searchCountry(String name) {
        HashMap<Integer, Country> countries = database.getCountries();
        for (Country country : countries.values()) {
            if (country.getName().equals(name)) {
                return country;
            }
        }
        return null;
    }

    public static float calculateRatingCountry(Country country) {
        float ratingCountry = 0F;
        if (country.getNaturalDisasters().isDisaster()) {
            ratingCountry -=4;
        }

        if (country.getConflictZone().isConflict()) {
            ratingCountry -=4;
        }

        ratingCountry += country.getCovidIncidence().getRating() + country.getHealthInsurance().getRating() + country.getAirquality().getRating() + country.getHealthSystem().getRating() + country.getRequirements().getRating();
        return ratingCountry;
    }

    public static ArrayList<Country> sortCountries(HashMap<Integer, Country> countries) {

        ArrayList<Country> unsortedCountries = new ArrayList<>(countries.values());
        Collections.sort(unsortedCountries);
        return unsortedCountries;
    }
}
