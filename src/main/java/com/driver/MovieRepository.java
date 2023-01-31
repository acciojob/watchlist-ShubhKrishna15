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

// ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????/
///??????????????????????????????????????????????????????????????????????????????????????????????????????????????????
//???????????????????????????????????????????????????????????????????????????????????????????????????????????????????
//????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
//
//package com.driver;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//public class MovieRepository {
//    Map<String,Movie> moviedb=new HashMap<>();
//    Map<String,Director> direcdb=new HashMap<>();
//    Map<String,String> movdirdb=new HashMap<>();
//
//    public String addMovie(Movie movie){
//        String name = movie.getName();
//        moviedb.put(name,movie);
//        return "Movie added Successfully";
//    }
//
//    public String addDirector(Director director){
//        String name= director.getName();
//        direcdb.put(name,director);
//        return "Director added Successfully";
//    }
//
//    public String addMovieDirectorPair(String moviename , String directorname){
//        if(!moviedb.containsKey(moviename)){
//            return "movie does not exist";
//        }
//        if(!direcdb.containsKey(directorname)){
//            return "director does not exist";
//        }
//        movdirdb.put(moviename,directorname);
//        return "Added Successfully";
//    }
//
//    public Movie getMoviesByName(String moviename){
//        if(moviedb.containsKey(moviename)){
//            return moviedb.get(moviename);
//        }
//        return null;
//    }
//
//    public Director getDirectorByName(String dirname){
//        if(direcdb.containsKey(dirname)) return direcdb.get(dirname);
//        return null;
//    }
//
//    public List<String> getMoviesByDirectorName(String dirname){
//        if(!direcdb.containsKey((dirname))) return null;
//        List<String> l= new ArrayList<>();
//        for(String a : movdirdb.keySet()){
//            if(movdirdb.get(a).equals(dirname)){
//                l.add(a);
//            }
//        }
//        return l;
//    }
//
//    public List<String> findAllMovies(){
//        List<String> l=new ArrayList<>();
//        for(String a : moviedb.keySet()){
//            l.add(a);
//        }
//        return l;
//    }
//
//    public String deleteDirectorByName(String name){
//        HashSet<String> hm= new HashSet<>();
//        direcdb.remove(name);
//        for(String a:movdirdb.keySet()){
//            if(movdirdb.get(a).equals(name)){
//                hm.add(a);
//            }
//
//        }
//        for(String a :hm) {
//            moviedb.remove(a);
//            movdirdb.remove(a);
//        }
//
//        return "Deleted Successfully";
//    }
//
//    public String deleteAllDirectors(){
//        HashSet<String> hm=new HashSet<>();
//        for(String a : movdirdb.keySet()){
//            hm.add(a);
//        }
//        for(String a : hm){
//            moviedb.remove(a);
//            movdirdb.remove(a);
//        }
//        direcdb.clear();
//        return "Deleted all directors and related movies";
//    }
//}