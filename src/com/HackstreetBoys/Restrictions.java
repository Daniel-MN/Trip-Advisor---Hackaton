package com.HackstreetBoys;

public class Restrictions extends Atributes{
    boolean lockDown;
    String maskRequired;
    String mobilityRestrictions;
    String regulatedClosingHours;

    public Restrictions(boolean lockDown, String maskRequired, String mobilityRestrictions, String regulatedClosingHours, String description) {
        super(description);
        this.lockDown = lockDown;
        this.maskRequired = maskRequired;
        this.mobilityRestrictions = mobilityRestrictions;
        this.regulatedClosingHours = regulatedClosingHours;
    }

    public boolean isLockDown() {
        return lockDown;
    }

    public void setLockDown(boolean lockDown) {
        this.lockDown = lockDown;
    }

    public String getMaskRequired() {
        return maskRequired;
    }

    public void setMaskRequired(String maskRequired) {
        this.maskRequired = maskRequired;
    }

    public String getMobilityRestrictions() {
        return mobilityRestrictions;
    }

    public void setMobilityRestrictions(String mobilityRestrictions) {
        this.mobilityRestrictions = mobilityRestrictions;
    }

    public String getRegulatedClosingHours() {
        return regulatedClosingHours;
    }

    public void setRegulatedClosingHours(String regulatedClosingHours) {
        this.regulatedClosingHours = regulatedClosingHours;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Lockdown: ");
        if (this.isLockDown()) {
            string.append("YES\n");
        }
        string.append(this.getMaskRequired() + "\n");
        return string.toString();
    }
}

