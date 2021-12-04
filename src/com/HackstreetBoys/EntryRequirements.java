package com.HackstreetBoys;

import java.util.ArrayList;
import java.util.List;

public class EntryRequirements extends Atributes{
    private int ID;
    private boolean covidVaccine;
    private boolean PCRtest;
    private boolean antigenTest;
    private List<String> otherVaccines;

    public EntryRequirements(int ID, boolean covidVaccine, boolean PCRtest, boolean antigenTest, String[] otherVaccines, String description) {
        super(description);
        this.ID = ID;
        this.covidVaccine = covidVaccine;
        this.PCRtest = PCRtest;
        this.antigenTest = antigenTest;
        this.otherVaccines = new ArrayList<String>();
    }

    public boolean isCovidVaccine() {
        return covidVaccine;
    }

    public void setCovidVaccine(boolean covidVaccine) {
        this.covidVaccine = covidVaccine;
    }

    public boolean isPCRtest() {
        return PCRtest;
    }

    public void setPCRtest(boolean PCRtest) {
        this.PCRtest = PCRtest;
    }

    public boolean isAntigenTest() {
        return antigenTest;
    }

    public void setAntigenTest(boolean antigenTest) {
        this.antigenTest = antigenTest;
    }

    public List<String> getOtherVaccines() {
        return otherVaccines;
    }

    public void addVacine(String vaccine) {
        this.otherVaccines.add(vaccine);
    }

    public boolean vaccineIsRequired(String vaccine) {
        for(int i = 0; i < this.otherVaccines.size(); i++) {
            if(this.otherVaccines.get(i).equals(vaccine))
                return true;
        }
        return false;
    }

    public void removeVaccine(String vaccine) {
        for(int i = 0; i < this.otherVaccines.size(); i++) {
            if(this.otherVaccines.get(i).equals(vaccine))
                this.otherVaccines.remove(i);
        }
    }
}

