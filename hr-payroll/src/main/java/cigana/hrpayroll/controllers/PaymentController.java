package cigana.hrpayroll.controllers;

import cigana.hrpayroll.services.PaymentService;
import cigana.hrpayroll.domain.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getNewPaymentFallback")
    @GetMapping("/worker/{id}/days/{days}")
    public ResponseEntity<Payment> getNewPayment(@PathVariable("id") Long id,
                                                 @PathVariable("days") Integer days){
        return ResponseEntity.ok(paymentService.getPayment(id, days));
    }

    @GetMapping
    public ResponseEntity<Payment> getNewPaymentFallback(Long id, Integer days){
        Payment payment = new Payment("Luizito", 25, BigDecimal.valueOf(250));
        return ResponseEntity.ok(payment);
    }
}
