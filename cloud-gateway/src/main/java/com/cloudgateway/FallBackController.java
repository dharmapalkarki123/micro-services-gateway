package com.cloudgateway;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rollback")
public class FallBackController {
    @PostMapping("/orderFallback")
    public Mono<String> OrderFallBack(){
        return Mono.just("Order Operation is faield");
    }

    @PostMapping("/paymentFallBack")
    public Mono<String> paymentFallBack(){
        return Mono.just("Payment Operation is faield");
    }

}
