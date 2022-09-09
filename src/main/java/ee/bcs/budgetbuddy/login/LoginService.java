package ee.bcs.budgetbuddy.login;

import ee.bcs.budgetbuddy.domain.user.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;
//

    public UserResponse registerNewUser(UserRequest request) {
        User user = userService.addUser(request);
        createCustomCategoriesFromTemplate(user);
        return userMapper.userToUserResponse(user);
    }

    public void createCustomCategoriesFromTemplate(User user) {
        // see meetod vajab implementeerimist / ära lahendamist
    }


}
