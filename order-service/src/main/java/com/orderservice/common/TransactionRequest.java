package com.orderservice.common;

import com.orderservice.model.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
   private OrderEntity order;
    private Payment payment;
}
