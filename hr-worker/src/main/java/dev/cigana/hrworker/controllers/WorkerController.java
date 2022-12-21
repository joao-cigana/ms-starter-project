package dev.cigana.hrworker.controllers;

import dev.cigana.hrworker.domain.dtos.WorkerDTO;
import dev.cigana.hrworker.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private Logger log = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerService workerService;

    @GetMapping("/{id}")
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
        log.info("PORT = " + environment.getProperty("local.server.port"));
        return ResponseEntity.ok(workerService.findById(id));
    }

}
