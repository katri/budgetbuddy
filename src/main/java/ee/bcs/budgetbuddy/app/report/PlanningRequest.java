package ee.bcs.budgetbuddy.app.report;

import lombok.Data;

import java.io.Serializable;

@Data public class PlanningRequest implements Serializable {
    private Integer userId;
    private Integer year;
    private Integer month;
}
