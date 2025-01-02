package com.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Screen extends BaseModel {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Theatre theatre;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
}
