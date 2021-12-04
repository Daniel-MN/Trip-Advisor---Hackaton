package com.HackstreetBoys;

import java.util.Arrays;

public class AirQuality extends Atributes {
    private int ID;
    Parameter[] parameters;

    public AirQuality(int ID, String description) {
        super(description);
        this.ID = ID;
        parameters = new Parameter[9];
        parameters[0] = new Parameter("PM1");
        parameters[1] = new Parameter("PM2.5");
        parameters[2] = new Parameter("PM10");
        parameters[3] = new Parameter("NO2");
        parameters[4] = new Parameter("SO2");
        parameters[5] = new Parameter("O3");
        parameters[6] = new Parameter("CO");
        parameters[7] = new Parameter("Temperature");
        parameters[8] = new Parameter("Humidity");
    }

    public Parameter getPM1() {
        return parameters[0];
    }

    public void setPM1(float value, String unit) {
        this.parameters[0].setValue(value);
        this.parameters[0].setUnit(unit);
    }

    public Parameter getPM2_5() {
        return parameters[1];
    }

    public void setPM2_5(float value, String unit) {
        this.parameters[1].setValue(value);
        this.parameters[1].setUnit(unit);
    }

    public Parameter getPM10() {
        return parameters[2];
    }

    public void setPM10(float value, String unit) {
        this.parameters[2].setValue(value);
        this.parameters[2].setUnit(unit);
    }

    public Parameter getNO2() {
        return parameters[3];
    }

    public void setNO2(float value, String unit) {
        this.parameters[3].setValue(value);
        this.parameters[3].setUnit(unit);
    }

    public Parameter getSO2() {
        return parameters[4];
    }

    public void setSO2(float value, String unit) {
        this.parameters[4].setValue(value);
        this.parameters[4].setUnit(unit);
    }

    public Parameter getO3() {
        return parameters[5];
    }

    public void setO3(float value, String unit) {
        this.parameters[5].setValue(value);
        this.parameters[5].setUnit(unit);
    }

    public Parameter getCO() {
        return parameters[6];
    }

    public void setCO(float value, String unit) {
        this.parameters[6].setValue(value);
        this.parameters[6].setUnit(unit);
    }

    public Parameter getTemperature() {
        return parameters[7];
    }

    public void setTemperature(float value, String unit) {
        this.parameters[7].setValue(value);
        this.parameters[7].setUnit(unit);
    }

    public Parameter getHumidity() {
        return parameters[8];
    }

    public void setHumidity(float value, String unit) {
        this.parameters[8].setValue(value);
        this.parameters[8].setUnit(unit);
    }

}