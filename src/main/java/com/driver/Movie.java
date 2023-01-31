package com.driver;

public class Movie {

    //Movie.java - String name, int durationInMinutes, double imdbRating, no-args constructor, all-args constructor and getters-setters
    //Director.java Class - String name, int numberOfMovies, double imdbRating, no-args constructor, all-args constructor and getters-setters
    private String name;
    private int durationInMinutes;
    private Double imdbRating;


    public Movie(String name, Integer durationInMinutes, Double imbRating) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Double getImbRating() {
        return imdbRating;
    }

    public void setImbRating(Double imbRating) {
        this.imdbRating = imbRating;
    }
}
