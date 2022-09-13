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
        // leiame adnmebaasist tabeli 'standard_categories' read
        List<StandardCategory> standardCategories = standardCategoryService.findAllStandardCategories();

        // valmistame ette 'categories' tabeli read
        List<Category> categories = categoryMapper.standardCategoriesToCategories(standardCategories);

        // uuendame 'categories' read 'user_id' infoga
        updateCategoriesWithUser(categories, user);

        // salvestame categories read
        categoryRepository.saveAll(categories);

        // tagastame categories read (neid läheb veel tarvis 'category_relation' tabeli täitmisel)
        return categories;
    }

    private void updateCategoriesWithUser(List<Category> categories, User user) {
        for (Category category : categories) {
            category.setUser(user);
        }
    }

}
