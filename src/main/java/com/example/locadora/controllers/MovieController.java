package com.example.locadora.controllers;

import com.example.locadora.dtos.MovieModelDto;
import com.example.locadora.models.MovieModel;
import com.example.locadora.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/movie")
public class MovieController {

    final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Object> saveMovie(@RequestBody @Valid MovieModelDto movieModelDto) {
        if (movieService.existByName(movieModelDto.getName()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Name is already in use.");
        var movieModel = new MovieModel();
        BeanUtils.copyProperties(movieModelDto, movieModel);
        return ResponseEntity.status(HttpStatus.OK).body(movieService.save(movieModel));
    }

    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovie() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOneMovie(@PathVariable(value = "id") UUID id) {
        var optionalMovieModel = movieService.findById(id);
        if (!optionalMovieModel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("movie not found");
        return ResponseEntity.status(HttpStatus.OK).body(optionalMovieModel.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable(value = "id") UUID id) {
        var optionalMovieModel = movieService.findById(id);
        if (!optionalMovieModel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("movie not found");
        movieService.delete(optionalMovieModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Movie deleted successfully.");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateMovie(@RequestBody @Valid MovieModelDto movieModelDto, @PathVariable(value = "id") UUID id) {
        var optionalMovieModel = movieService.findById(id);
        if (!optionalMovieModel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("movie not found");
        var movieModel = optionalMovieModel.get();
        BeanUtils.copyProperties(movieModelDto, movieModel);
        return ResponseEntity.status(HttpStatus.OK).body(movieService.save(movieModel));
    }
}
