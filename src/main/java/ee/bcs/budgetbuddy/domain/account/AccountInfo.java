package ee.bcs.budgetbuddy.domain.account;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountInfo implements Serializable {
    private Integer id;
    private String accountName;
    private Float balance;
    private Boolean isActive;
}
