package com.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Movie extends BaseModel {
    @Column(nullable = false)
    private String name;

    private String director;

    private String cast;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Date releaseDate;

    private int durationInMinutes;
}
