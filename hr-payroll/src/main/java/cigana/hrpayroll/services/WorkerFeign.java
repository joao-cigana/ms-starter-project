package cigana.hrpayroll.services;


import cigana.hrpayroll.domain.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeign {

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id);

}
