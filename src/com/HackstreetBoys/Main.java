package com.HackstreetBoys;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
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

        Country tara2 = Administration.searchCountry("Maldives");
        tara2.getCovidIncidence().setIncidence(0.3F);
        tara2.getCovidIncidence().setVaccinationRate(98.7F);
        ConflictZone conflictZone2 = new ConflictZone(3, false, "Safe place");
        tara2.setConflictZone(conflictZone);
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
        System.out.println(tara2.toString());
        System.out.println(Administration.calculateRatingCountry(tara2));

//        System.out.println(Administration.calculateRatingCountry(database.getCountries().get(0)));
//        System.out.println(Administration.searchCountry("Afghanistan").toString());
    }
}
