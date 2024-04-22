package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springboot.model.Country;
import net.javaguides.springboot.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    @PostMapping("/add_country")
    public Country createCountry(@RequestBody Country country){
        return countryRepository.save(country);
    }

    @DeleteMapping("/country/{id}")
    public void deleteCountry(@PathVariable Long id){
        countryRepository.deleteById(id);
    }

    @PutMapping("/country/{id}")
    public void updateCountry(@PathVariable Long id, @RequestBody Country country){
        Country oldCountry = countryRepository.findById(id).get();

        oldCountry.setCountryName(country.getCountryName());

        countryRepository.save(oldCountry);
    }
}
