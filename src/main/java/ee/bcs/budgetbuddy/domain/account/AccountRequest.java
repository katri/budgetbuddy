package ee.bcs.budgetbuddy.domain.account;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AccountRequest implements Serializable {

    @NotNull
    private Integer userId;
    private Integer accountTypeId;
    @NotNull
    private String name;
    private String description;
    private Float balance;

}
