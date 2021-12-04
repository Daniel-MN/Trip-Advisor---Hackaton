package com.HackstreetBoys;

public class Parameter {
    private String name;
    private float value;
    private String unit;

    public Parameter(String name) {
        this.name = name;
    }

    public Parameter(float value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}

