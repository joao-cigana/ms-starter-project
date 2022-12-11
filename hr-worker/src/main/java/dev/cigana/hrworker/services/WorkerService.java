package dev.cigana.hrworker.services;

import dev.cigana.hrworker.domain.Worker;
import dev.cigana.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public Worker findById(Long id){
        return workerRepository.findById(id)
                .orElseThrow(() ->new RuntimeException(""));
    }

}
