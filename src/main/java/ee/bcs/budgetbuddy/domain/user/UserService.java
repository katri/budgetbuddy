package ee.bcs.budgetbuddy.domain.user;

import ee.bcs.budgetbuddy.domain.user.role.RoleService;
import ee.bcs.budgetbuddy.app.login.UserRequest;
import ee.bcs.budgetbuddy.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleService roleService;

    public User addUser(UserRequest request) {
        boolean userExists = userRepository.existsByUserName(request.getUserName());
        ValidationService.validateUserExists(userExists, request.getUserName());
        User user = userMapper.userRequestToUser(request);
        userRepository.save(user);
        return user;
    }

}