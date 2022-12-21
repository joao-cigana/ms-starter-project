package dev.cigana.hrpayroll.services;

import dev.cigana.hrpayroll.domain.Payment;
import dev.cigana.hrpayroll.domain.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeign workerFeign;

    public Payment getPayment(Long id, Integer daysWorked){
        Worker worker = workerFeign.findById(id).getBody();
        return new Payment(worker, daysWorked);
    }

}
