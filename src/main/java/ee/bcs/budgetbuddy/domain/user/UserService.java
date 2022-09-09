package ee.bcs.budgetbuddy.domain.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User addUser(UserRequest request) {
        User user = userMapper.userRequestToUser(request);
        return null;
    }
}
