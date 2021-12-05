package com.HackstreetBoys;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        System.out.println(Administration.calculateRatingCountry(database.getCountries().get(0)));
        System.out.println(Administration.searchCountry("Afghanistan").toString());
    }
}
