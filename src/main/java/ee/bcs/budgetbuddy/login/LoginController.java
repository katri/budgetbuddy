package ee.bcs.budgetbuddy.login;

import ee.bcs.budgetbuddy.domain.user.UserRequest;
import ee.bcs.budgetbuddy.domain.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/register/user")
    @Operation(summary = "Uue kasutaja lisamine")
    public UserResponse registerNewUser(@RequestBody UserRequest request) {
        return loginService.registerNewUser(request);
    }

}
