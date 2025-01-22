package com.bookmyshow.controllers;

import com.bookmyshow.dtos.SeatRequestDTO;
import com.bookmyshow.models.Seat;
import com.bookmyshow.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    // Add a new seat
    @PostMapping
    public Seat addSeat(@RequestBody SeatRequestDTO request) {
        return seatService.addSeat(request);
    }

    // Get all seats
    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }
}
