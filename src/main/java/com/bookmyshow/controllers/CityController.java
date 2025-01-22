package com.bookmyshow.controllers;

import com.bookmyshow.models.City;
import com.bookmyshow.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    // Add a new city
    @PostMapping
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    // Get all cities
    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    // Get a city by ID
    @GetMapping("/{id}")
    public City getCityById(@PathVariable int id) {
        return cityService.getCityById(id);
    }

    // Update a city
    @PutMapping("/{id}")
    public City updateCity(@PathVariable int id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    // Delete a city
    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable int id) {
        cityService.deleteCity(id);
        return "City deleted successfully";
    }
}
