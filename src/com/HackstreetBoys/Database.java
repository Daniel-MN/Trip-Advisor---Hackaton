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
        initAfghanistan();
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

    public void initAfghanistan() {
        ConflictZone conflictZone = new ConflictZone(1, true, "ITS BAD");
        conflictZone.setConflict();
        Country tara = this.getCountries().get(0);
        tara.setConflictZone(conflictZone);
        AirQuality air = new AirQuality(1, "Good");
        air.setPM1(10, "particlesA");
        air.setPM2_5(32, "particlesB");
        air.setPM10(215, "particlesC");
        air.setCO(17, "carbon monoxide");
        air.setHumidity(75, "%");
        air.setNO2(21, "No2");
        air.setTemperature(35, "Celsius");
        air.setSO2(51, "so2");
        air.setO3(14, "heavy air");
        tara.setAirquality(air);
        HealthSystem health = new HealthSystem(1,31,"Saint George", 7, "Good healthcare");
        tara.setHealthSystem(health);
        HealthInsurance insurance = new HealthInsurance(1, "Health Insurance provider");
        insurance.addProvider("Alianz");
        insurance.addProvider("Omniasig");
        tara.setHealthInsurance(insurance);
        NaturalDisasters disaster = new NaturalDisasters(1, "REALLY BAD", "Tsunami", true);
        tara.setNaturalDisasters(disaster);
        Restrictions restrictii = new Restrictions(true, "Yes", "Yes", "All the time", "Basically prison");
        tara.setRestrictions(restrictii);
        EntryRequirements requirements = new EntryRequirements(1, false, false, false, null, null);
        tara.setRequirements(requirements);
    }

    public HashMap<Integer, Country> getCountries() {
        return countries;
    }
}
