package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private CategoryRepository categoryRepository;


    public List<Category> createCategoriesForUser(List<StandardCategory> standardCategories) {
       return categoryMapper.standardCategoriesToCategories(standardCategories);
    }

    public void saveCategoriesToDatabase(List<Category> categories) {
        categoryRepository.saveAll(categories);

    }
}
