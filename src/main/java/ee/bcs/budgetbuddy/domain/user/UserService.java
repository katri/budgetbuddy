package ee.bcs.budgetbuddy.domain.user;

import ee.bcs.budgetbuddy.app.login.LoginRequest;
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


    public User addUser(UserRequest request) {
        boolean userExists = userRepository.existsByUsername(request.getUsername());
        ValidationService.validateUserExists(userExists, request.getUsername());
        User user = userMapper.userRequestToUser(request);
        userRepository.save(user);
        return user;
    }

    public User findById(Integer userId) {
        return userRepository.findById(userId).get();
    }

    public User userRequestToUser(LoginRequest request) {
        return userMapper.loginRequestToUser(request);
    }
}