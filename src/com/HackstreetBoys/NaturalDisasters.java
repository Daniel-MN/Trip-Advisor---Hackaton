package com.HackstreetBoys;

public class NaturalDisasters extends Atributes {
    private int ID;
    private boolean isDisaster;
    private String typeOfNaturalDisaster;

    public NaturalDisasters(int ID, String description, String typeOfNaturalDisaster, boolean isDisaster) {
        super(description);
        this.ID = ID;
        this.typeOfNaturalDisaster = typeOfNaturalDisaster;
    }

    public String getTypeOfNaturalDisaster() {
        return typeOfNaturalDisaster;
    }

    public void setTypeOfNaturalDisaster(String typeOfNaturalDisaster) {
        this.typeOfNaturalDisaster = typeOfNaturalDisaster;
    }

    public boolean isDisaster() {
        return isDisaster;
    }

    public void setDisaster(boolean disaster) {
        isDisaster = disaster;
    }
}
