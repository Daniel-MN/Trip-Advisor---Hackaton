package com.HackstreetBoys;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        Database database = new Database();
        ConflictZone conflictZone = new ConflictZone(1, true, "ITS BAD");
        conflictZone.setConflict();
        Country tara = database.getCountries().get(0);
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
        System.out.println(tara.toString());

        for (Country country : database.getCountries().values()) {
//            System.out.println("ID = " + country.getID() + ";   Name = " + country.getName() + ";   NewConfirmed = " + country.getCovidIncidence().getNewConfirmed());
        }
    }
}
