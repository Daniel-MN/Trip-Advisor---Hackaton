package com.HackstreetBoys;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Database {
    Continent[] continents;
    private HashMap<Integer, Country> countries;

    public Database() {
        continents = new Continent[7];
        countries = new HashMap<>();
        continents[0] = new Continent("Asia");
        continents[1] = new Continent("Africa");
        continents[2] = new Continent("Europe");
        continents[3] = new Continent("North America");
        continents[4] = new Continent("South America");
        continents[5] = new Continent("Australia");
        continents[6] = new Continent("Antarctica");
        initCountries();
    }

    void initCountries() {
        try {

            URL url = new URL("https://api.covid19api.com/summary");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);

                //Get the required object from the above created object
                JSONObject obj = (JSONObject) data_obj.get("Global");

                JSONArray arr = (JSONArray) data_obj.get("Countries");

                for (int i = 0; i < arr.size(); i++) {
                    JSONObject new_obj = (JSONObject) arr.get(i);
                    String name = new_obj.get("Country").toString();
                    int totalConfirmed = Integer.parseInt(new_obj.get("TotalConfirmed").toString());
                    int totalDeaths = Integer.parseInt(new_obj.get("TotalDeaths").toString());
                    int newConfirmed = Integer.parseInt(new_obj.get("NewConfirmed").toString());
                    CovidIncidence covidIncidence = new CovidIncidence(totalConfirmed, totalDeaths, newConfirmed, i);
                    Country country = new Country(i, name, covidIncidence);
                    countries.put(i, country);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Country> getCountries() {
        return countries;
    }
}
