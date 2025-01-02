package com.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Ticket extends BaseModel {
    @ManyToOne
    private Show show;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Seat> seats;

    private Date timeOfBooking;
}
