package com.HackstreetBoys;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        Database database = new Database();
        for (Country country : database.getCountries().values()) {
            System.out.println("ID = " + country.getID() + ";   Name = " + country.getName() + ";   NewConfirmed = " + country.getCovidIncidence().getNewConfirmed());
        }
    }
}
