package com.bookmyshow.services;

import com.bookmyshow.dtos.TheatreRequestDTO;
import com.bookmyshow.models.City;
import com.bookmyshow.models.Theatre;
import com.bookmyshow.repositories.CityRepository;
import com.bookmyshow.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private CityRepository cityRepository;

    // Add a new theatre
    public Theatre addTheatre(TheatreRequestDTO request) {
        // Verify the city exists
        Optional<City> cityOptional = cityRepository.findById(request.getCityId());
        if (cityOptional.isEmpty()) {
            throw new IllegalArgumentException("City not found with ID: " + request.getCityId());
        }

        Theatre theatre = new Theatre();
        theatre.setName(request.getName());
        theatre.setAddress(request.getAddress());
        theatre.setCity(cityOptional.get());

        return theatreRepository.save(theatre);
    }

    // Get all theatres
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }
}
