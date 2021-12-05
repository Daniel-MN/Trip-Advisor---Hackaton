package com.HackstreetBoys;

public class Country {
    private String name;
    private int ID;
    private AirQuality airquality;
    private ConflictZone conflictZone;
    private CovidIncidence covidIncidence;
    private HealthSystem healthSystem;
    private HealthInsurance healthInsurance;
    private NaturalDisasters naturalDisasters;
    private Restrictions restrictions;
    private EntryRequirements requirements;
    private static int nrCountries = 0;

    public Country(int ID, String name, CovidIncidence covidIncidence) {
        this.name = name;
        this.ID = ID;
        this.covidIncidence = covidIncidence;
        this.airquality = new AirQuality(ID,"No description");
        this.conflictZone = new ConflictZone(ID, false, "No description");
        this.healthSystem = new HealthSystem(ID, 0, "No Hospital", 0, "No desciption");
        this.healthInsurance = new HealthInsurance(ID, "No description");
        this.naturalDisasters = new NaturalDisasters(ID, "No description", "No type", false);
        this.restrictions = new Restrictions(false, "No mask", "No mobility restrictions", "No regulating closing hours", "No description");
        this.requirements = new EntryRequirements(ID, false, false, false, null, "No desccription");
    }

    public Country(String name, int ID, AirQuality airquality, ConflictZone conflictZone, CovidIncidence covidIncidence, HealthSystem healthSystem, HealthInsurance healthInsurance, NaturalDisasters naturalDisasters, Restrictions restrictions) {
        this.name = name;
        this.ID = ID;
        this.airquality = airquality;
        this.conflictZone = conflictZone;
        this.covidIncidence = covidIncidence;
        this.healthSystem = healthSystem;
        this.healthInsurance = healthInsurance;
        this.naturalDisasters = naturalDisasters;
        this.restrictions = restrictions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public AirQuality getAirquality() {
        return airquality;
    }

    public void setAirquality(AirQuality airquality) {
        this.airquality = airquality;
    }

    public ConflictZone getConflictZone() {
        return conflictZone;
    }

    public void setConflictZone(ConflictZone conflictZone) {
        this.conflictZone = conflictZone;
    }

    public CovidIncidence getCovidIncidence() {
        return covidIncidence;
    }

    public void setCovidIncidence(CovidIncidence covidIncidence) {
        this.covidIncidence = covidIncidence;
    }

    public HealthSystem getHealthSystem() {
        return healthSystem;
    }

    public void setHealthSystem(HealthSystem healthSystem) {
        this.healthSystem = healthSystem;
    }

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public NaturalDisasters getNaturalDisasters() {
        return naturalDisasters;
    }

    public void setNaturalDisasters(NaturalDisasters naturalDisasters) {
        this.naturalDisasters = naturalDisasters;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public static int getNrCountries() {
        return nrCountries;
    }

    public static void setNrCountries(int nrCountries) {
        Country.nrCountries = nrCountries;
    }

    public EntryRequirements getRequirements() {
        return requirements;
    }

    public void setRequirements(EntryRequirements requirements) {
        this.requirements = requirements;
    }



    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Country: " + this.getName() + "\n");
        if (this.getConflictZone().isConflict()) {
            string.append("!!!CONFLICT ZONE!!!\n");
            string.append(this.getConflictZone().getDescription() + "\n");
        }

        if (this.getNaturalDisasters().isDisaster()) {
            string.append("!!!NATURAL DISASTER!!!\n");
            string.append(this.getNaturalDisasters().getDescription()+"\n");
        }

        string.append("Covid-19 cases incidence rate: " + this.getCovidIncidence().getIncidence() + "\n");
        string.append("Total covid-19 cases until now: " + this.getCovidIncidence().getTotalConfirmedCases() + "\n");
        string.append("Vaccination rate: " + this.getCovidIncidence().getVaccinationRate() + "% of adults\n");
        string.append("Restrictions: \n" + this.getRestrictions().toString());
        string.append(this.getRestrictions().getDescription() + "\n");
        string.append("Air quality Indicators: \n" + this.getAirquality().toString());
        string.append("Entry requirements:\n" + this.getRequirements().toString());
        string.append("Health System Rating: " + this.getHealthSystem().getRating() + "\n");
        string.append("Health insurance providers: " + this.getHealthInsurance().toString());
        return string.toString();
    }
}
