package com.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel {
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    private Screen screen;
}
