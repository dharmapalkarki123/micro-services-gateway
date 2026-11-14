package com.paymentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Payment_Tb")
@AllArgsConstructor
@NoArgsConstructor

public class Payment {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer paymentId;
    private String paymentStatus;
    private String transactionId;
    private Integer orderId;
    private Double price;
}
