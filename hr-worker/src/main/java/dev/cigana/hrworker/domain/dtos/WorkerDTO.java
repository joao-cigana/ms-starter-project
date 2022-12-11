package dev.cigana.hrworker.domain.dtos;

import dev.cigana.hrworker.domain.Worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkerDTO {

    private String name;

    private BigDecimal dailyIncome;

    public WorkerDTO (Worker worker){
        this.name = worker.getName();
        this.dailyIncome = worker.getDailyIncome();
    }

}
