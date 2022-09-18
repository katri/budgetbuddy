package ee.bcs.budgetbuddy.app.setup;
import lombok.Data;
import java.io.Serializable;


@Data
public class CategoryChangeRequest implements Serializable {
    private Integer categoryId;
    private String categoryName;
    private Boolean isActive;


}
