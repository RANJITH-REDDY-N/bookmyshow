package com.bookmyshow.controllers;

import com.bookmyshow.dtos.TheatreRequestDTO;
import com.bookmyshow.models.Theatre;
import com.bookmyshow.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    // Add a new theatre
    @PostMapping
    public Theatre addTheatre(@RequestBody TheatreRequestDTO request) {
        return theatreService.addTheatre(request);
    }

    // Get all theatres
    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }
}
