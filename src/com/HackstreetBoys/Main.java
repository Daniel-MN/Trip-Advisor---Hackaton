package com.HackstreetBoys;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Database database = new Database();
        System.out.println(Administration.calculateRatingCountry(database.getCountries().get(0)));
        System.out.println(Administration.searchCountry("Afghanistan").toString());
    }
}
