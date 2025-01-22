package com.bookmyshow.services;

import com.bookmyshow.dtos.SeatRequestDTO;
import com.bookmyshow.models.Screen;
import com.bookmyshow.models.Seat;
import com.bookmyshow.models.SeatType;
import com.bookmyshow.repositories.ScreenRepository;
import com.bookmyshow.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScreenRepository screenRepository;

    // Add a new seat
    public Seat addSeat(SeatRequestDTO request) {
        // Verify the screen exists
        Optional<Screen> screenOptional = screenRepository.findById(request.getScreenId());
        if (screenOptional.isEmpty()) {
            throw new IllegalArgumentException("Screen not found with ID: " + request.getScreenId());
        }

        Seat seat = new Seat();
        seat.setName(request.getName());
        seat.setScreen(screenOptional.get());
        seat.setSeatType(SeatType.valueOf(request.getSeatType()));

        return seatRepository.save(seat);
    }

    // Get all seats
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }
}
