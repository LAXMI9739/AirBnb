package com.agoda.controller;

import com.agoda.entity.Property;
import com.agoda.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {
    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }
    @PostMapping("/addProperty")
    public ResponseEntity<Property> addProperty(@RequestParam long countryId, @RequestParam long locationId, @RequestBody Property property){
        Property property1 = propertyService.addProperty(countryId, locationId, property);
        return new ResponseEntity<>(property1, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteProperty(@RequestParam long propertyId){
        propertyService.deleteProperty(propertyId);
        return new ResponseEntity<>("deleted property",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/searchProperty")
    public ResponseEntity<List<Property>> searchProperty( @RequestParam String name){
        List<Property> properties = propertyService.searchProperty(name);
        return new ResponseEntity<>(properties,HttpStatus.OK);
    }

}
