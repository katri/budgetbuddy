package ee.bcs.budgetbuddy.domain.user.role;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;

}
