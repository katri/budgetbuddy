package ee.bcs.budgetbuddy.app.login;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UserRequest implements Serializable {
    @Size(max = 255)
    @NotNull
    private String username;
    @Size(max = 255)
    @NotNull
    private String password;
    @Size(max = 255)
    @NotNull
    private String email;
}
