package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.domain.Month;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlanningInfo implements Serializable {
    private Integer subcategoryBudgetedId;
    private Float amount;
}
