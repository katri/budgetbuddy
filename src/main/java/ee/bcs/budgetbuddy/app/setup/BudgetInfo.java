package ee.bcs.budgetbuddy.app.setup;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BudgetInfo implements Serializable {
    private List<CategoryInfo> categories;
    private Float totalBudgetedSum;
    private Float totalSum;
}
