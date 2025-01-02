package com.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Theatre extends BaseModel {
    @Column(nullable = false)
    private String name;

    private String address;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;
}
