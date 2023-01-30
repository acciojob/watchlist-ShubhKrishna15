package com.driver;

public class Director {

    //Director.java Class - String name, int numberOfMovies, double imdbRating, no-args constructor, all-args constructor and getters-setters

    private String name;
    private int numberOfMovies;
    private double imdebRating;

    public Director(String name, int numberOfMovies, double imdebRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdebRating = imdebRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdebRating() {
        return imdebRating;
    }

    public void setImdebRating(double imdebRating) {
        this.imdebRating = imdebRating;
    }
}
