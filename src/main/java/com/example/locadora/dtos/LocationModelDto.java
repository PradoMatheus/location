package com.example.locadora.dtos;

import com.example.locadora.models.MovieModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class LocationModelDto implements Serializable {

    @NotBlank
    private MovieModel movie;
    @NotBlank
    private int quantity;
}
