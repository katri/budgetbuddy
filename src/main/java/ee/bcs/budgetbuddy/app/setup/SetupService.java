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
    private SubcategoryService subcategoryService;

    @Resource
    private CategoryRelationService categoryRelationService;

    public void addSubcategory(Integer categoryId, String subcategoryName) {
        subcategoryService.addSubcategory(categoryId, subcategoryName);
    }

    public void updateCategoryIsActiveStatus(Integer categoryId, Boolean isActive) {
        categoryService.updateCategoryIsActiveStatus(categoryId, isActive);
    }

    public void updateSubcategoryIsActiveStatus(Integer subcategoryId, Boolean isActive) {
        categoryRelationService.updateSubcategoryIsActiveStatus(subcategoryId, isActive);
    }

    public void updateSubcategoryName(Integer subcategoryId, String subcategoryName) {
        subcategoryService.updateSubcategoryName(subcategoryId, subcategoryName);
    }

    public BudgetInfo getIncomeCategoriesSetup(Integer userId) {
        return categoryService.getIncomeCategoriesSetup(userId);
    }

    public BudgetInfo getExpenseCategoriesSetup(Integer userId) {
        return categoryService.getExpenseCategoriesSetup(userId);
    }

    public void addIncomeCategory(Integer userId, String categoryName) {
        categoryService.addIncomeCategory(userId, categoryName);
    }

    public void addExpenseCategory(Integer userId, String categoryName) {
        categoryService.addExpenseCategory(userId, categoryName);
    }

    public void updateCategoryName(Integer categoryId, String categoryName) {
        categoryService.updateCategoryName(categoryId, categoryName);
    }
}
