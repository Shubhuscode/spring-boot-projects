package com.pinnacle.database.service;

import com.pinnacle.database.model.Location;
import com.pinnacle.database.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Create or update a location
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    // Get all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // Get a location by id
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    // Update a location
    public Location updateLocation(Long id, Location locationDetails) {
        if (locationRepository.existsById(id)) {
            locationDetails.setId(id);
            return locationRepository.save(locationDetails);
        }
        return null; // Return null or throw an exception if not found
    }

    // Delete a location by id
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
