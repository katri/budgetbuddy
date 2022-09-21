package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.domain.Month;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlanningInfo implements Serializable {
    private Integer userId;
    private Integer year;
    private Integer month;
    private Float amount;
    private Integer subcategoryId;
    private String subcategoryName;
    private Boolean isActive;
}
