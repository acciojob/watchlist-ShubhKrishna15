package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {


    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){

        return new ResponseEntity<>(movieRepository.addMovie(movie), HttpStatus.ACCEPTED);

    }
    @PostMapping("movies/add-director")
    public ResponseEntity <String> addDirector(@RequestBody Director director){

        return  new ResponseEntity<>(movieRepository.addDirector(director),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/add-movie-director-pair")
    public ResponseEntity <String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        String ans= movieRepository.addMovieAndDirector(movie,director);
        if(ans.equals("movie or director does not exist")) return new ResponseEntity<>(ans,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
    }
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity <Movie> getMovieByName(@PathVariable("name") String movie){
        Movie m=movieRepository.getMovieByName(movie);
        if(m==null){
            return new ResponseEntity<>(m,HttpStatus.BAD_REQUEST);
        }
    return new ResponseEntity<>(m,HttpStatus.ACCEPTED);




    }
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity <Director> getDirectorByName(@PathVariable("q") String DirectorName){

        Director d = movieRepository.getDirecdtorbyName(DirectorName);
        if(d==null){
            return new ResponseEntity<>(d,HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(d,HttpStatus.ACCEPTED);

    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity <List<String>>findAllMovies(){

        return new ResponseEntity<>(movieRepository.findAllMovies(),HttpStatus.ACCEPTED);

    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name") String directorname){
        return new ResponseEntity<>(movieRepository.getMoviesByDirectorName(directorname),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/delete-director-by-name")
    public ResponseEntity <String>  deleteDirectorByName(@RequestParam("name") String directorName){
        return new ResponseEntity<>(movieRepository.deleteDirectorByName(directorName),HttpStatus.ACCEPTED);

    }
    @DeleteMapping(" /movies/delete-all-directors")
    public ResponseEntity <String> deleteAllDirectors(){
        return new ResponseEntity<>(movieRepository.deleteAllDirectors(),HttpStatus.ACCEPTED);

    }











}
