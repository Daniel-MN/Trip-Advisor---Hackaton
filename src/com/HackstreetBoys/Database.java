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
        initNorway();
        initMaldive();
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

    public void initNorway() {
        Database database = new Database();
        Country tara = Administration.searchCountry("Norway");
        tara.getCovidIncidence().setIncidence(1.1F);
        tara.getCovidIncidence().setVaccinationRate(82.3F);
        ConflictZone conflictZone = new ConflictZone(2, false, "Safe place");
        tara.setConflictZone(conflictZone);
        AirQuality air = new AirQuality(2, "Good");
        air.setPM1(2, "particlesA");
        air.setPM2_5(5, "particlesB");
        air.setPM10(7, "particlesC");
        air.setCO(3.1F, "carbon monoxide");
        air.setHumidity(20, "%");
        air.setNO2(4, "No2");
        air.setTemperature(12, "Celsius");
        air.setSO2(9, "so2");
        air.setO3(23, "heavy air");
        tara.setAirquality(air);
        HealthSystem health = new HealthSystem(2,500,"Oslo Universitetssykehus", 9.7F, "Excellent healthcare");
        tara.setHealthSystem(health);
        HealthInsurance insurance = new HealthInsurance(2, "Health Insurance provider");
        insurance.addProvider("Any european state public insurance");
        insurance.addProvider("Alianz");
        insurance.addProvider("Groupama");
        insurance.addProvider("Omniasig");
        tara.setHealthInsurance(insurance);
        NaturalDisasters disaster = new NaturalDisasters(2, "No", "No", false);
        tara.setNaturalDisasters(disaster);
        Restrictions restrictii = new Restrictions(false, "Indoors", "No", "after 23:00", "Decent measures");
        tara.setRestrictions(restrictii);
        EntryRequirements requirements = new EntryRequirements(2, true, false, false, null, null);
        tara.setRequirements(requirements);
        System.out.println(tara.toString());
        System.out.println(Administration.calculateRatingCountry(tara));
        System.out.println();
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

    public void initMaldive() {
        Country tara2 = Administration.searchCountry("Maldives");
        tara2.getCovidIncidence().setIncidence(0.3F);
        tara2.getCovidIncidence().setVaccinationRate(98.7F);
        ConflictZone conflictZone2 = new ConflictZone(3, false, "Safe place");
        tara2.setConflictZone(conflictZone2);
        AirQuality air2 = new AirQuality(3, "Best");
        air2.setPM1(1, "particlesA");
        air2.setPM2_5(2, "particlesB");
        air2.setPM10(3, "particlesC");
        air2.setCO(0.2F, "carbon monoxide");
        air2.setHumidity(5, "%");
        air2.setNO2(2, "No2");
        air2.setTemperature(27, "Celsius");
        air2.setSO2(2, "so2");
        air2.setO3(7, "heavy air");
        tara2.setAirquality(air2);
        HealthSystem health2 = new HealthSystem(3,1000,"European Clinic Maldives", 8.9F, "Very good healthcare");
        tara2.setHealthSystem(health2);
        HealthInsurance insurance2 = new HealthInsurance(3, "Health Insurance provider");
        insurance2.addProvider("Any european state public insurance");
        insurance2.addProvider("Alianz");
        tara2.setHealthInsurance(insurance2);
        NaturalDisasters disaster2 = new NaturalDisasters(3, "No", "No", false);
        tara2.setNaturalDisasters(disaster2);
        Restrictions restrictii2 = new Restrictions(false, "Indoors", "No", "No", "Relaxed measures");
        tara2.setRestrictions(restrictii2);
        EntryRequirements requirements2 = new EntryRequirements(2, true, false, false, null, null);
        tara2.setRequirements(requirements2);
    }

    public HashMap<Integer, Country> getCountries() {
        return countries;
    }
}
