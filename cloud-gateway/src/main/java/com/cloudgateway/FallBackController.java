package com.cloudgateway;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rollback")
public class FallBackController {


    @PostMapping("/orderFallback")
    public String orderFallBack() {
        return "Order Operation has failed. Please try again later.";
    }

    @PostMapping("/paymentFallback")
    public String paymentFallBack() {
        return "Payment Operation has failed. Please try again later.";
    }

}
