package com.example.locadora.others;

import com.example.locadora.dtos.MovieModelDto;
import com.example.locadora.enums.GenreMovie;

public class Factory {
    public static MovieModelDto createMovie(){
        return new MovieModelDto(GenreMovie.HORROR, "THE EXORCIST");
    }
}
