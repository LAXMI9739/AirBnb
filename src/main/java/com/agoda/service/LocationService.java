package com.agoda.service;

import com.agoda.entity.Location;
import com.agoda.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location addLocation(Location location) {
       return locationRepository.save(location);
    }

    public void deleteLocation(long locationId) {
        locationRepository.deleteById(locationId);
    }

    public List<Location> getAllLocation() {
       return locationRepository.findAll();
    }

    public Location getLocationById(long locationId) {
        Location location = locationRepository.findById(locationId).get();
        return location;
    }

    public Location updateLocation(long locationId, Location location) {
        Location location1 = locationRepository.findById(locationId).get();
        location1.setName(location.getName());
         return locationRepository.save(location1);
    }
}
