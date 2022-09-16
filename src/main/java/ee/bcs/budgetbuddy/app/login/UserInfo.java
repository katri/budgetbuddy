package ee.bcs.budgetbuddy.app.login;

import ee.bcs.budgetbuddy.domain.account.AccountInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserInfo implements Serializable {
    private Integer userId;
    private List<AccountInfo> accounts;

}