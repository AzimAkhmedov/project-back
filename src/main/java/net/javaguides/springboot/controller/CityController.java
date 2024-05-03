package net.javaguides.springboot.controller;

import java.sql.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springboot.model.City;
import net.javaguides.springboot.model.Flight;
import net.javaguides.springboot.repository.CityRepository;
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

public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @PostMapping("/new_city")
    public City createCity(@RequestBody City city) {
        return cityRepository.save(city);
    }

    @DeleteMapping("/city/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityRepository.deleteById(id);
    }

    @PutMapping("/city/{id}")
    public void updateCity(@PathVariable Long id, @RequestBody City city) {
        City oldCity = cityRepository.findById(id).get();

        oldCity.setCityName(city.getCityName());
        oldCity.setCountryID(city.getCountryID());

        cityRepository.save(oldCity);
    }
}
