package com.HackstreetBoys;

public class CovidIncidence extends Atributes{
    private int totalConfirmedCases;
    private int totalDeaths;
    private int newConfirmed;
    private float incidence;
    private float vaccinationRate;
    private int ID;

    public CovidIncidence(int totalConfirmedCases, int totalDeaths, int newConfirmed, int ID) {
        this.totalConfirmedCases = totalConfirmedCases;
        this.totalDeaths = totalDeaths;
        this.newConfirmed = newConfirmed;
        this.ID = ID;
    }

    public CovidIncidence(int ID, int totalConfirmedCases, int vaccinationRate, String description) {
        super(description);
        this.ID = ID;
        this.totalConfirmedCases = totalConfirmedCases;
    }

    public CovidIncidence(int totalConfirmedCases, float vaccinationRate, String description) {
        super(description);
        this.totalConfirmedCases = totalConfirmedCases;
        this.vaccinationRate = vaccinationRate;
    }

    public float getIncidence() {
        return this.incidence;
    }


    public float getVaccinationRate() {
        return vaccinationRate;
    }

    public void setVaccinationRate(float vaccinationRate) {
        this.vaccinationRate = vaccinationRate;
    }

    public int getTotalConfirmedCases() {
        return totalConfirmedCases;
    }

    public void setTotalConfirmedCases(int totalConfirmedCases) {
        this.totalConfirmedCases = totalConfirmedCases;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public float getRating() {
        return this.getIncidence()/10;
    }

    public int getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public void setIncidence(float incidence) {
        this.incidence = incidence;
    }
}

