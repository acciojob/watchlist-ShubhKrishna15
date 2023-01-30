package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {


    Map<String,Movie> MovieList = new HashMap<>();
    Map<String,Director>DirectorList  = new HashMap<>();
    Map<String,String> MovieAndDirector = new HashMap<>();


    public String addMovie(Movie movie){

        MovieList.put(movie.getName(),movie);
        return "success";
    }

    public String addDirector(Director director){

        DirectorList.put(director.getName(),director);
        return "success";
    }
    public String addMovieAndDirector(String movie,String director){
        if(MovieList.containsKey(movie)&& DirectorList.containsKey(director)){
            MovieAndDirector.put(movie , director);
        }
        else{
             return  "movie or director does not exist";
        }
        return "success";
    }

    public  Movie getMovieByName(String movieName){
        if(MovieList.containsKey(movieName))
            return MovieList.get(movieName);

        return null;
    }

    public  Director getDirecdtorbyName(String director){
        if(DirectorList.containsKey(director))return DirectorList.get(director);
        return null;
    }



    public List<String> findAllMovies(){
       List<String> ans = new ArrayList<>();
       for(String i : MovieList.keySet()){
           ans.add(i);
       }
       return ans;
    }

    public List<String> getMoviesByDirectorName(String directorname){
        List<String> ans=new ArrayList<>();
        if(!DirectorList.containsKey(directorname)) return ans;
        for(String i : MovieAndDirector.keySet()){
            if(MovieAndDirector.get(i).equals(directorname)) ans.add(i);
        }
        return ans;
    }

    public  String deleteDirectorByName(String director){
        if(DirectorList.containsKey(director)){
            DirectorList.remove(director);
        }
        else{
            return "Failure";
        }
        List<String> moviesName = new ArrayList<>();
        for(String  i : MovieAndDirector.keySet()){
            if(MovieAndDirector.get(i).equals(director)){
                moviesName.add(i);
            }
        }
        for(int i = 0 ; i < moviesName.size() ; i++ ){
            MovieAndDirector.remove(moviesName.get(i));
            MovieList.remove(moviesName.get(i));
        }
        return "Success";


    }
    public String  deleteAllDirectors(){
        for(String i : MovieAndDirector.keySet()){
            MovieList.remove(i);
        }
        MovieAndDirector.clear();
        DirectorList.clear();
        return "Success";

    }




}
