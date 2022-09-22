package ee.bcs.budgetbuddy.app.setup;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubcategoryInfo implements Serializable {
    private Integer categoryId;
    private Integer subcategoryId;
    private String subcategoryName;
    private Float subcategoryBudgetedSum;
    private Integer subcategoryBudgetedSumId;
    private Float subcategorySum;
    private Boolean isActive;

}
