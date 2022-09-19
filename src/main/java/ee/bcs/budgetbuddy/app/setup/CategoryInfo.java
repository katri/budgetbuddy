package ee.bcs.budgetbuddy.app.setup;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryInfo implements Serializable {

    private Integer categoryId;
    private String categoryName;
    private Float categoryBudgetedSum;
    private Float categorySum;
    private List<SubcategoryInfo> subcategories;
}
