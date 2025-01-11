package com.bookmyshow.controllers;

import com.bookmyshow.dtos.BookTicketRequestDTO;
import com.bookmyshow.dtos.BookTicketResponseDTO;
import com.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/book")
    public BookTicketResponseDTO bookTicket(@RequestBody BookTicketRequestDTO request) {
        return ticketService.bookTicket(request);
    }
}
