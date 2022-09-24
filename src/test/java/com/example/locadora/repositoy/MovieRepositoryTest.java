package com.example.locadora.repositoy;

import com.example.locadora.models.MovieModel;
import com.example.locadora.others.Factory;
import com.example.locadora.repository.MovieRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

@RunWith(MockitoJUnitRunner.class)
public class MovieRepositoryTest {

    @InjectMocks
    MovieRepository movieRepository;

    @Test
    public void insert_should_create_movie() {
        var movieModel = new MovieModel();
//        BeanUtils.copyProperties(Factory.createMovie(), movieModel);

        var movie = movieRepository.save(movieModel);

        Assertions.assertNotNull(movie.getId());
    }
//
//    @Test
//    public void delete_should_delete_movie_when_id_exists() {
//
//        movieRepository.deleteById(existingId);
//
//        var movie = repository.findById(existingId);
//
//        Assertions.assertFalse(result.isPresent());
//    }
//
//    @Test
//    public void delete_should_not_delete_movie_when_id_not_exist() {
//
//        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
//            repository.deleteById(nonExistingId);
//        });
//
//    }
}
