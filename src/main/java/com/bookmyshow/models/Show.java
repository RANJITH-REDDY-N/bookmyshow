package com.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "shows")
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;

    @Column(nullable = false)
    private Date startTime;

    @Column(nullable = false)
    private Date endTime;

    @ManyToOne
    private Screen screen;

    @ElementCollection
    private List<Feature> features;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;
}
