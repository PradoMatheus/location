package com.example.locadora.dtos;

import com.example.locadora.enums.GenreMovie;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class MovieModelDto implements Serializable {

    public MovieModelDto(GenreMovie genreMovie, String name) {
        this.genreMovie = genreMovie;
        this.name = name;
    }

    @NotBlank
    private GenreMovie genreMovie;
    @NotBlank
    private String name;

}
