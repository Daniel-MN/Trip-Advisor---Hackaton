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
    public float getRating() {
        if (this.isLockDown()) {
            return 0;
        }

        float rating = 0;

        if (this.getMaskRequired() == null) {
            rating += 1;
        }

        if (this.getMobilityRestrictions() == null) {
            rating += 0.5;
        }

        if (this.getRegulatedClosingHours() == null) {
            rating += 0.5;
        }

        return rating;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Lockdown: ");
        if (this.isLockDown()) {
            string.append("YES\n");
        }
        string.append("Mask Required: ");
        string.append(this.getMaskRequired() + "\n");
        string.append("Mobility restrictions: ");
        string.append(this.getMobilityRestrictions() + "\n");
        string.append("Regulated closing hours: ");
        string.append(this.getRegulatedClosingHours() + "\n");
        return string.toString();
    }
}

