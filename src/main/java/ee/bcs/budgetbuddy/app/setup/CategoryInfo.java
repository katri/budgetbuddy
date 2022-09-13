package ee.bcs.budgetbuddy.app.setup;

import lombok.Data;

import java.util.List;
@Data
public class CategoryInfo {
    private Integer categoryId;
    private String categoryName;
    private List<SubcategoryInfo> subcategories;
}
