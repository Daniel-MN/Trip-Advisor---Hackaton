package com.HackstreetBoys;

import java.util.HashMap;

public class HealthInsurance extends Atributes{
    private int ID;
    private HashMap<Integer, String> insuranceProviders;
    private int nrProviders;

    public HealthInsurance(int ID, String description) {
        super(description);
        this.ID = ID;
    }

    boolean searchProvider(String providerName) {
        return insuranceProviders.containsValue(providerName);
    }

    void addProvider(String provider) {
        insuranceProviders.put(nrProviders, provider);
        this.nrProviders++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public HashMap<Integer, String> getInsuranceProviders() {
        return insuranceProviders;
    }

    public void setInsuranceProviders(HashMap<Integer, String> insuranceProviders) {
        this.insuranceProviders = insuranceProviders;
    }

    public int getNrProviders() {
        return nrProviders;
    }

    public void setNrProviders(int nrProviders) {
        this.nrProviders = nrProviders;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (String provider : insuranceProviders.values()) {
            string.append(provider + "; ");
        }

        return string.toString();
    }
}
