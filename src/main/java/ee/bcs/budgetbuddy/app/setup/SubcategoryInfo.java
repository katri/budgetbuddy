package ee.bcs.budgetbuddy.app.setup;

import lombok.Data;

@Data
public class SubcategoryInfo {
    private Integer categoryId;
    private Integer subcategoryId;
    private String subcategoryName;
    private Boolean isActive;
}
