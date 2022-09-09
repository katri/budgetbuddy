package ee.bcs.budgetbuddy.login;

import ee.bcs.budgetbuddy.domain.user.User;
import ee.bcs.budgetbuddy.domain.user.UserRequest;
import ee.bcs.budgetbuddy.domain.user.UserResponse;
import ee.bcs.budgetbuddy.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    public UserResponse registerNewUser(UserRequest request) {
        return userService.addUser(request);
    }
}
