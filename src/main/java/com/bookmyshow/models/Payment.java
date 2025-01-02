package com.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Payment extends BaseModel {
    @Column(nullable = false)
    private String transactionId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentMode mode;

    @Column(nullable = false)
    private Date timestamp;
}
