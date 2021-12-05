package com.HackstreetBoys;

public abstract class Atributes {
    float rating;
    int nrRating;
    String description;

    public Atributes() {
    }

    public Atributes(String description) {
        rating = 0;
        nrRating = 0;
        this.description = description;
    }

    //used when calling changeRating
    public float calculateRating(float rating) {
        float ratingReturn = (this.rating * this.nrRating) + this.rating;
        this.nrRating++;
        ratingReturn = ratingReturn / this.nrRating;
        return ratingReturn;
    }

    void changeRating(float rating) {
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getNrRating() {
        return nrRating;
    }

    public void setNrRating(int nrRating) {
        this.nrRating = nrRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

