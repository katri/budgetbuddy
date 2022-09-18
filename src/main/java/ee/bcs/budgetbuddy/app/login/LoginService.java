package ee.bcs.budgetbuddy.app.login;

import com.sun.xml.bind.v2.TODO;
import ee.bcs.budgetbuddy.domain.account.Account;
import ee.bcs.budgetbuddy.domain.account.AccountInfo;
import ee.bcs.budgetbuddy.domain.account.AccountService;
import ee.bcs.budgetbuddy.domain.category.Category;
import ee.bcs.budgetbuddy.domain.category.CategoryRelationService;
import ee.bcs.budgetbuddy.domain.category.CategoryService;
import ee.bcs.budgetbuddy.domain.subcategory.Subcategory;
import ee.bcs.budgetbuddy.domain.subcategory.SubcategoryService;
import ee.bcs.budgetbuddy.domain.user.*;
import ee.bcs.budgetbuddy.validation.ValidationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private SubcategoryService subcategoryService;

    @Resource
    private CategoryRelationService categoryRelationService;

    @Resource
    private AccountService accountService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Transactional
    public UserResponse registerNewUser(UserRequest request) {
        User user = userService.addUser(request);
        createAndSaveCategoriesFromTemplate(user);
        return userMapper.userToUserResponse(user);
    }

    public void createAndSaveCategoriesFromTemplate(User user) {
        List<Category> categories = categoryService.createAndSaveCategories(user);
        List<Subcategory> subcategories = subcategoryService.createAndSaveSubcategories();
        categoryRelationService.createAndSaveCategoryRelations(categories, subcategories);
    }

    public UserInfo logIn(LoginRequest request) {
        User user = userRepository.findUserBy(request.getUsername(), request.getPassword());
        ValidationService.validatePasswordUserExists(user);
        return createUserInfo(user);
    }

    private UserInfo createUserInfo(User user) {
        UserInfo userInfo = userMapper.userToUserInfo(user);
        List<AccountInfo> accounts = accountService.findAllAccountsBy(user.getId());
        userInfo.setAccounts(accounts);
        return userInfo;
    }
}
