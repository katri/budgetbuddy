package ee.bcs.budgetbuddy.app.setup;

import ee.bcs.budgetbuddy.domain.category.CategoryRelationService;
import ee.bcs.budgetbuddy.domain.category.CategoryService;
import ee.bcs.budgetbuddy.domain.subcategory.SubcategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SetupService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryRelationService categoryRelationService;


    public void updateCategoryIsActiveStatus(Integer categoryId, Boolean isActive) {
        categoryService.updateCategoryIsActiveStatus(categoryId, isActive);
    }

    public void updateSubcategoryIsActiveStatus(Integer subcategoryId, Boolean isActive) {
        categoryRelationService.updateSubcategoryIsActiveStatus(subcategoryId, isActive);
    }
}
