package dev.cigana.hrworker.controllers;

import dev.cigana.hrworker.domain.Worker;
import dev.cigana.hrworker.domain.dtos.WorkerDTO;
import dev.cigana.hrworker.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/{id}")
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(workerService.findById(id));
    }

}
