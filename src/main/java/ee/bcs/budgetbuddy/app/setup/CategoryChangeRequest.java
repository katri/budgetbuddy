package ee.bcs.budgetbuddy.app.setup;

import java.io.Serializable;

public class CategoryChangeRequest implements Serializable {
    private Integer categoryId;
    private String categoryName;
    private Boolean isActive;


}
