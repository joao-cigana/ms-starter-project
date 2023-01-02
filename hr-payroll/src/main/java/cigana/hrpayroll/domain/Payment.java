package cigana.hrpayroll.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private String name;
    private Integer daysWorked;
    private BigDecimal totalPayment;

   public Payment(Worker worker, Integer daysWorked){
       this.name = worker.getName();
       this.daysWorked = daysWorked;
       this.totalPayment = worker.getDailyIncome().multiply(BigDecimal.valueOf(daysWorked));
   }
}
