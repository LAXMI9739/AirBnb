package com.agoda.controller;

import com.agoda.entity.Location;
import com.agoda.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // http://localhost:8080/api/v1/location/addLocation
    @PostMapping("/addLocation")
    public ResponseEntity<Location> addLocation(@RequestBody Location location){
        Location location1 = locationService.addLocation(location);
        return new ResponseEntity<>(location1, HttpStatus.CREATED);
    }
    // http://localhost:8080/api/v1/location?locationId=1
    @DeleteMapping
    public ResponseEntity<String> deleteLocation(@RequestParam long locationId){
        locationService.deleteLocation(locationId);
        return new ResponseEntity<>("deleted location",HttpStatus.OK);
    }
    //http://localhost:8080/api/v1/location
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocation(){
        List<Location> allLocation = locationService.getAllLocation();
        return new ResponseEntity<>(allLocation,HttpStatus.OK);
    }
    // http://localhost:8080/api/v1/location/ById?locationId=1
    @GetMapping("/ById")
    public ResponseEntity<Location> getLocationById(@RequestParam long locationId){
        Location locationById = locationService.getLocationById(locationId);
        return new ResponseEntity<>(locationById,HttpStatus.OK);
    }
    // http://localhost:8080/api/v1/location?locationId=1
    @PutMapping
    public ResponseEntity<Location> updateLocation(@RequestParam long locationId,@RequestBody Location location){
        Location location1 = locationService.updateLocation(locationId, location);
        return new ResponseEntity<>(location1,HttpStatus.OK);
    }
}
