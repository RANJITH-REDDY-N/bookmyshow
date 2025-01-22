package com.bookmyshow.services;

import com.bookmyshow.models.City;
import com.bookmyshow.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    // Add a new city
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    // Get all cities
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Get a city by ID
    public City getCityById(int id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("City not found with ID: " + id));
    }

    // Update city
    public City updateCity(int id, City updatedCity) {
        City existingCity = cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("City not found with ID: " + id));

        existingCity.setName(updatedCity.getName());
        return cityRepository.save(existingCity);
    }

    // Delete city
    public void deleteCity(int id) {
        if (!cityRepository.existsById(id)) {
            throw new IllegalArgumentException("City not found with ID: " + id);
        }
        cityRepository.deleteById(id);
    }
}

