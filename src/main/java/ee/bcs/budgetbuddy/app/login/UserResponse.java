package ee.bcs.budgetbuddy.app.login;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponse implements Serializable {
    private Integer userId;
}
