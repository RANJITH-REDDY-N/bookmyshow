package com.bookmyshow.services;

import com.bookmyshow.dtos.BookTicketRequestDTO;
import com.bookmyshow.dtos.BookTicketResponseDTO;
import com.bookmyshow.models.*;
import com.bookmyshow.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO request) {
        // Fetch show
        Optional<Show> showOptional = showRepository.findById(request.getShowId());
        if (showOptional.isEmpty()) {
            throw new IllegalArgumentException("Show not found");
        }
        Show show = showOptional.get();

        // Fetch available seats
        List<ShowSeat> availableSeats = showSeatRepository.findAvailableSeatsForShow(
                request.getShowId(), request.getSeatIds()
        );

        if (availableSeats.size() != request.getSeatIds().size()) {
            throw new IllegalArgumentException("Some seats are already booked or unavailable.");
        }

        // Mark seats as BLOCKED
        availableSeats.forEach(seat -> seat.setStatus(SeatStatus.BLOCKED));
        showSeatRepository.saveAll(availableSeats);

        // Create ticket
        Ticket ticket = new Ticket();
        ticket.setShow(show);
        ticket.setSeats(
                availableSeats.stream().map(ShowSeat::getSeat).collect(Collectors.toList())
        );
        ticket.setTimeOfBooking(new Date());
        Ticket savedTicket = ticketRepository.save(ticket);

        // Prepare response
        BookTicketResponseDTO response = new BookTicketResponseDTO();
        response.setTicketId(savedTicket.getId());
        response.setShowId(savedTicket.getShow().getId());
        response.setBookedSeats(
                savedTicket.getSeats().stream().map(Seat::getName).collect(Collectors.toList())
        );
        response.setStatus("SUCCESS");
        response.setMessage("Seats successfully blocked. Complete payment within 15 minutes.");

        return response;
    }
}
