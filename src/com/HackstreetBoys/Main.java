package com.HackstreetBoys;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        Country tara = Administration.searchCountry("Norway");
        System.out.println(tara.toString());
        System.out.println(Administration.calculateRatingCountry(tara));
        System.out.println();

        Country tara2 = Administration.searchCountry("Maldives");
        System.out.println(tara2.toString());
        System.out.println(Administration.calculateRatingCountry(tara2));
        System.out.println();
    }
}
