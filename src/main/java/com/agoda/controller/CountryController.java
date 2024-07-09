package com.agoda.controller;

import com.agoda.entity.Country;
import com.agoda.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // http://localhost:8080/api/v1/country/addCountry
    @PostMapping("/addCountry")
    public ResponseEntity<Country> addCountry(@RequestBody Country country){
        Country country1 = countryService.addCountry(country);
        return new ResponseEntity<>(country1, HttpStatus.CREATED);
    }
    // http://localhost:8080/api/v1/country?countryId=1
    @DeleteMapping
    public ResponseEntity<String> deleteCountry(@RequestParam long countryId){
        countryService.deleteCountry(countryId);
        return new ResponseEntity<>("deleted country",HttpStatus.OK);
    }
    // http://localhost:8080/api/v1/country
    @GetMapping
    public ResponseEntity<List<Country>>  getAllCountry(){
        List<Country> allCountry = countryService.getAllCountry();
        return new ResponseEntity<>(allCountry,HttpStatus.OK);
    }
    // http://localhost:8080/api/v1/country?countryId=1
    @PutMapping
    public ResponseEntity<Country> updateCountry(@RequestParam long countryId,@RequestBody Country country){
        Country country1 = countryService.updateCountry(countryId, country);
        return new ResponseEntity<>(country1,HttpStatus.OK);
    }
    // http://localhost:8080/api/v1/country/getById?countryId=1
    @GetMapping("/getById")
    public ResponseEntity<Country> getCountryById(@RequestParam long countryId){
        Country countryById = countryService.getCountryById(countryId);
        return new ResponseEntity<>(countryById,HttpStatus.OK);
    }



}
