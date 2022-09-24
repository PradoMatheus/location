package com.example.locadora.service;

import com.example.locadora.models.MovieModel;
import com.example.locadora.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Object save(MovieModel movieModel) {
        return movieRepository.save(movieModel);
    }

    public List<MovieModel> findAll() {
        return movieRepository.findAll();
    }

    public Optional<MovieModel> findById(UUID id) {
        return movieRepository.findById(id);
    }

    public void delete(MovieModel movieModel) {
        movieRepository.delete(movieModel);
    }

    public boolean existByName(String name) {
        return movieRepository.existsByName(name);
    }
}
