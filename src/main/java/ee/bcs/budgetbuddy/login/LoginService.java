package ee.bcs.budgetbuddy.login;

import ee.bcs.budgetbuddy.domain.category.Category;
import ee.bcs.budgetbuddy.domain.category.CategoryRelationService;
import ee.bcs.budgetbuddy.domain.category.CategoryService;
import ee.bcs.budgetbuddy.domain.subcategory.Subcategory;
import ee.bcs.budgetbuddy.domain.subcategory.SubcategoryService;
import ee.bcs.budgetbuddy.domain.user.*;
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
    private UserMapper userMapper;

    public UserResponse registerNewUser(UserRequest request) {
        User user = userService.addUser(request);
        createAndSaveCustomCategoriesForUser(user);
        return userMapper.userToUserResponse(user);
    }

    @Transactional
    public void createAndSaveCustomCategoriesForUser(User user) {
        List<Category> categories = categoryService.createAndSaveCategories(user);
        List<Subcategory> subcategories = subcategoryService.createAndSaveSubcategories();
        categoryRelationService.createAndSaveCategoryRelations(categories, subcategories);
    }

}
