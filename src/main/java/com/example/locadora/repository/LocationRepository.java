package com.example.locadora.repository;

import com.example.locadora.models.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<LocationModel, UUID> {
}
