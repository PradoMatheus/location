package com.example.locadora.models;

import com.example.locadora.enums.GenreMovie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_movie")
public class MovieModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private GenreMovie genreMovie;
    @Column(nullable = false, unique = true)
    private String name;

}
