package com.orderservice.services;

import com.orderservice.common.Payment;
import com.orderservice.common.TransactionRequest;
import com.orderservice.common.TransactionResponse;
import com.orderservice.model.OrderEntity;
import com.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {

    private OrderRepository repository;

    private RestTemplate restTemplate;

    public OrderService(OrderRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }


    public TransactionResponse saveOrder(TransactionRequest request){


        String message="";
        OrderEntity order=request.getOrder();

        Payment payment=request.getPayment();
        payment.setOrderId(order.getOrderId());
        payment.setPrice(order.getPrice());

        //rest Api call

        Payment paymentResponse= restTemplate.postForObject("http://Payment-Service/payment/doPayment", payment, Payment.class);

      message= paymentResponse.getPaymentStatus().equals("success")?"payment processing is sucessful":"Something went wrong";
         repository.save(order);
    return new TransactionResponse(order,paymentResponse.getPrice(),paymentResponse.getTransactionId(),message);
    }

}
