package com.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class City extends BaseModel {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres;
}
