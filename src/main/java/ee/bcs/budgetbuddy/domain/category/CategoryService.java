package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryService;
import ee.bcs.budgetbuddy.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class CategoryService {

    @Resource
    private StandardCategoryService standardCategoryService;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryRepository categoryRepository;

    public List<Category> createAndSaveCategories(User user) {
        List<StandardCategory> standardCategories = standardCategoryService.findAllStandardCategories();
        List<Category> categories = categoryMapper.standardCategoriesToCategories(standardCategories);
        addUserToAllCategories(categories, user);
        categoryRepository.saveAll(categories);
        return categories;
    }

    private void addUserToAllCategories(List<Category> categories, User user) {
        for (Category category : categories) {
            category.setUser(user);
        }
    }

}
