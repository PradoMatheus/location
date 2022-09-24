package com.example.locadora.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tb_location")
public class LocationModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieModel movie;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private LocalDateTime date_location;
}
