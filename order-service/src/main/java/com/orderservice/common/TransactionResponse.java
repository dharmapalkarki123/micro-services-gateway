package com.orderservice.common;

import com.orderservice.model.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
   private OrderEntity order;
   private String transactionId;
   private double price;
   private String message;

    public TransactionResponse(OrderEntity order, double price, String transactionId, String message) {
        this.order = order;
        this.price = price;
        this.transactionId = transactionId;
        this.message = message;
    }
}
