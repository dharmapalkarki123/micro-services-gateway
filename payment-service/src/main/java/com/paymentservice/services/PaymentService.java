package com.paymentservice.services;

import com.paymentservice.model.Payment;
import com.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service

public class PaymentService {

    private PaymentRepository paymentRepository;
     public PaymentService(PaymentRepository paymentRepository){
         this.paymentRepository = paymentRepository;
     }


     public Payment savePayment(Payment payment){


         payment.setPaymentStatus(paymentProcessing());
         payment.setTransactionId(UUID.randomUUID().toString());

         return paymentRepository.save(payment);
     }


     public String paymentProcessing(){
        return new Random().nextBoolean()?"success":"false";
     }

}
