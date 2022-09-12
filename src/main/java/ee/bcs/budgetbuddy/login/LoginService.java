package ee.bcs.budgetbuddy.login;

import ee.bcs.budgetbuddy.domain.category.Category;
import ee.bcs.budgetbuddy.domain.category.CategoryService;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryService;
import ee.bcs.budgetbuddy.domain.user.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private StandardCategoryService standardCategoryService;
    //
    @Resource
    private CategoryService categoryService;

    public UserResponse registerNewUser(UserRequest request) {
        User user = userService.addUser(request);
        createCustomCategoriesFromTemplate(user);
        return userMapper.userToUserResponse(user);

    }

    public void createCustomCategoriesFromTemplate(User user) {
        // see meetod vajab implementeerimist / ära lahendamist
        List<StandardCategory> standardCategories = standardCategoryService.findAllCategories();
        List<Category> categories = categoryService.createCategoriesForUser(standardCategories);
        updateCategoriesWithUser(categories, user);
        categoryService.saveCategoriesToDatabase(categories);
    }

    public void updateCategoriesWithUser(List<Category> categories, User user) {
        for (Category category : categories) {
            category.setUser(user);
        }
    }


}
