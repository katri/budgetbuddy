package ee.bcs.budgetbuddy.domain.user;

import ee.bcs.budgetbuddy.domain.user.role.Role;
import ee.bcs.budgetbuddy.domain.user.role.RoleService;
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

    public UserResponse addUser(UserRequest request) {
        User user = userMapper.userRequestToUser(request);
        userRepository.save(user);
        UserResponse userResponse = userMapper.userToUserResponse(user);
        return userResponse;

    }


}