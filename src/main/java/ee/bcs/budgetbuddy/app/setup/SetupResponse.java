package ee.bcs.budgetbuddy.app.setup;

import lombok.Data;

import java.util.List;

@Data
public class SetupResponse {
    private List<CategoryInfo> categories;
}
