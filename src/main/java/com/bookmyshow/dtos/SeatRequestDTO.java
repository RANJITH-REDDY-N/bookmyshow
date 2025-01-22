package com.bookmyshow.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SeatRequestDTO {

    @NotBlank
    private String name; // Seat name, e.g., "A1"

    @NotNull
    private Integer screenId; // Link seat to a screen

    @NotBlank
    private String seatType; // SILVER, GOLD, PLATINUM, etc.

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
}
