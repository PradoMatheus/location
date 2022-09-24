package com.example.locadora.repository;

import com.example.locadora.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, UUID> {
    boolean existsByName(String name);
}
