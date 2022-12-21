package dev.cigana.hrpayroll.controllers;

import dev.cigana.hrpayroll.domain.Payment;
import dev.cigana.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/worker/{id}/days/{days}")
    public ResponseEntity<Payment> getNewPayment(@PathVariable("id") Long id,
                                                 @PathVariable("days") Integer days){
        return ResponseEntity.ok(paymentService.getPayment(id, days));
    }


}
