package com.agoda.service;

import com.agoda.entity.Country;
import com.agoda.entity.Location;
import com.agoda.entity.Property;
import com.agoda.repository.CountryRepository;
import com.agoda.repository.LocationRepository;
import com.agoda.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    private PropertyRepository propertyRepository;
    private CountryRepository countryRepository;
    private LocationRepository locationRepository;

    public PropertyService(PropertyRepository propertyRepository, CountryRepository countryRepository, LocationRepository locationRepository) {
        this.propertyRepository = propertyRepository;
        this.countryRepository = countryRepository;
        this.locationRepository = locationRepository;
    }


    public Property addProperty(long countryId, long locationId, Property property) {
        Country country = countryRepository.findById(countryId).get();
        Location location = locationRepository.findById(locationId).get();
        property.setCountry(country);
        property.setLocation(location);
       return propertyRepository.save(property);
    }

    public void deleteProperty(long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    public List<Property> searchProperty(String name) {
        List<Property> properties = propertyRepository.searchProperty(name);
        return properties;
    }
}
