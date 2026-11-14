package com.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER-TB")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderEntity {
    @Id
    private Integer orderId;
    private String  name;
    private  int quantity;
    private double price;
}
