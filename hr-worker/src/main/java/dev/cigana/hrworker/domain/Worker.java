package dev.cigana.hrworker.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_worker")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private BigDecimal dailyIncome;

}
