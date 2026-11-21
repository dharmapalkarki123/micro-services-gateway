package com.orderservice.services;

import com.orderservice.common.Payment;
import com.orderservice.common.TransactionRequest;
import com.orderservice.common.TransactionResponse;
import com.orderservice.model.OrderEntity;
import com.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RefreshScope
public class OrderService {

    private OrderRepository repository;

    @Lazy
    private RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String EndpointUrl;

    public OrderService(OrderRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }


    public TransactionResponse saveOrder(TransactionRequest request){


        String message="";
        OrderEntity order=request.getOrder();

        //1.Save Order first
        repository.save(order);

        //2.Set generated Id in Payment
        Payment payment=request.getPayment();
        payment.setOrderId(order.getOrderId());
        payment.setPrice(order.getPrice());

        //rest Api call

        Payment paymentResponse= restTemplate.postForObject(EndpointUrl, payment, Payment.class);

      message= paymentResponse.getPaymentStatus().equals("success")?"payment processing is sucessful":"Something went wrong";

    return new TransactionResponse(order,paymentResponse.getPrice(),paymentResponse.getTransactionId(),message);
    }

}
