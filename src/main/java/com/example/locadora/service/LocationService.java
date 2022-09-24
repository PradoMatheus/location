package com.example.locadora.service;

import com.example.locadora.models.LocationModel;
import com.example.locadora.models.MovieModel;
import com.example.locadora.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocationService {
    final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Object save(LocationModel locationModel) {
        return locationRepository.save(locationModel);
    }

    public List<LocationModel> findAll() {
        return locationRepository.findAll();
    }

    public Optional<LocationModel> findById(UUID id) {
        return locationRepository.findById(id);
    }

    public void delete(LocationModel locationModel) {
        locationRepository.delete(locationModel);
    }
}
