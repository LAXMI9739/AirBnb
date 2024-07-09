package com.agoda.service;

import com.agoda.entity.Country;
import com.agoda.exception.ResourceNotFound;
import com.agoda.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country addCountry(Country country) {
      return  countryRepository.save(country);
    }

    public void deleteCountry(long countryId) {
        countryRepository.deleteById(countryId);
    }

    public List<Country> getAllCountry() {
       return countryRepository.findAll();
    }

    public Country updateCountry(long countryId, Country country) {
        Country country1 = countryRepository.findById(countryId).get();
        country1.setName(country.getName());
       return countryRepository.save(country1);
    }

    public Country getCountryById(long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(
                ()->new ResourceNotFound("country not found with id " +countryId)
        );
        return country;
    }
}
