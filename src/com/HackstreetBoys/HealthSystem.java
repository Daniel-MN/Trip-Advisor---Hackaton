package com.HackstreetBoys;

public class HealthSystem extends Atributes{
    private int ID;
    private int ICUBedsAvailable;
    private String bestHospitalInCountry;
    float systemRating;

    public HealthSystem(int ID, int ICUBedsAvailable, String bestHospitalInCountry, float systemRating, String description) {
        super(description);
        this.ID = ID;
        this.ICUBedsAvailable = ICUBedsAvailable;
        this.bestHospitalInCountry = bestHospitalInCountry;
        this.systemRating = systemRating;
    }

    public int getICUBedsAvailable() {
        return ICUBedsAvailable;
    }

    public void setICUBedsAvailable(int ICUBedsAvailable) {
        this.ICUBedsAvailable = ICUBedsAvailable;
    }

    public String getBestHospitalInCountry() {
        return bestHospitalInCountry;
    }

    public void setBestHospitalInCountry(String bestHospitalInCountry) {
        this.bestHospitalInCountry = bestHospitalInCountry;
    }

    //Nr maxim 2;
    public float getSystemRating() {
        return systemRating;
    }

    public void setSystemRating(float systemRating) {
        this.systemRating = systemRating;
    }

    @Override
    public float getRating() {
        return getSystemRating()/5;
    }
}

