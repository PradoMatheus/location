package com.example.locadora.controllers;

import com.example.locadora.dtos.LocationModelDto;
import com.example.locadora.dtos.MovieModelDto;
import com.example.locadora.models.LocationModel;
import com.example.locadora.models.MovieModel;
import com.example.locadora.service.LocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/location")
public class LocationController {

    final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<Object> saveLocation(@RequestBody @Valid LocationModelDto locationModelDto) {
        var locationModel = new LocationModel();
        BeanUtils.copyProperties(locationModelDto, locationModel);
        locationModel.setDate_location(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.OK).body(locationService.save(locationModel));
    }

    @GetMapping
    public ResponseEntity<List<LocationModel>> getAllLocation() {
        return ResponseEntity.status(HttpStatus.OK).body(locationService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOneLocation(@PathVariable(value = "id") UUID id) {
        var optionalLocationModel = locationService.findById(id);
        if (!optionalLocationModel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("location not found");
        return ResponseEntity.status(HttpStatus.OK).body(optionalLocationModel.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteLocation(@PathVariable(value = "id") UUID id) {
        var optionalLocationModel = locationService.findById(id);
        if (!optionalLocationModel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("location not found");
        locationService.delete(optionalLocationModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Location deleted successfully.");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateLocation(@RequestBody @Valid LocationModelDto locationModelDto, @PathVariable(value = "id") UUID id) {
        var optionalLocationModel = locationService.findById(id);
        if (!optionalLocationModel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("location not found");
        var locationModel = optionalLocationModel.get();
        BeanUtils.copyProperties(locationModelDto, locationModel);
        return ResponseEntity.status(HttpStatus.OK).body(locationService.save(locationModel));
    }
}
