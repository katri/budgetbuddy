package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.app.setup.CategoryInfo;
import ee.bcs.budgetbuddy.app.setup.SetupResponse;
import ee.bcs.budgetbuddy.app.setup.SubcategoryInfo;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryService;
import ee.bcs.budgetbuddy.domain.subcategory.SubcategoryService;
import ee.bcs.budgetbuddy.domain.user.User;
import ee.bcs.budgetbuddy.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static ee.bcs.budgetbuddy.app.CategoryType.EXPENSE;
import static ee.bcs.budgetbuddy.app.CategoryType.INCOME;

@Service
public class CategoryService {


    @Resource
    private StandardCategoryService standardCategoryService;


    @Resource
    private CategoryRelationService categoryRelationService;

    @Resource
    private UserService userService;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryRelationsMapper categoryRelationsMapper;

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

    public SetupResponse getIncomeCategoriesSetup(Integer userId) {
        List<CategoryInfo> categoryInfos = createCategoryInfos(userId, INCOME);
        addSubcategorytoCategoryInfos(categoryInfos);
        SetupResponse setupResponse = new SetupResponse();
        setupResponse.setCategories(categoryInfos);
        return setupResponse;
    }

    public SetupResponse getExpenseCategoriesSetup(Integer userId) {
        List<CategoryInfo> categoryInfos = createCategoryInfos(userId, EXPENSE);
        addSubcategorytoCategoryInfos(categoryInfos);
        SetupResponse setupResponse = new SetupResponse();
        setupResponse.setCategories(categoryInfos);
        return setupResponse;
    }

    public void addIncomeCategory(Integer userId, String categoryName) {
        User user = userService.findById(userId);
        createNewCategory(categoryName, user, INCOME);
    }

    public void addExpenseCategory(Integer userId, String categoryName) {
        User user = userService.findById(userId);
        createNewCategory(categoryName, user, EXPENSE);
    }

    public Category findById(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public void updateCategoryName(Integer categoryId, String categoryName) {
        Category category = categoryRepository.getReferenceById(categoryId);
        category.setName(categoryName);
        categoryRepository.save(category);
    }

    public void updateCategoryIsActiveStatus(Integer categoryId, Boolean isActive) {
        List<CategoryRelation> categoryRelations = categoryRelationService.findAllRelationsForCategory(categoryId);
        for (CategoryRelation categoryRelation : categoryRelations) {
            categoryRelation.setIsActive(isActive);
        }
        categoryRelationService.saveAll(categoryRelations);
    }


    private void addSubcategorytoCategoryInfos(List<CategoryInfo> categoryInfos) {
        for (CategoryInfo categoryInfo : categoryInfos) {
            addSubcategory(categoryInfo);
        }
    }

    private List<CategoryInfo> createCategoryInfos(Integer userId, String type) {
        List<Category> categories = categoryRepository.findCategoriesBy(userId, type);
        return categoryMapper.categoriesToCategoryInfos(categories);
    }

    private void addSubcategory(CategoryInfo categoryInfo) {
        List<CategoryRelation> categoryRelations = categoryRelationService.findSubCategoriesBy(categoryInfo.getCategoryId());
        List<SubcategoryInfo> subcategories = categoryRelationsMapper.categoryRelationsToSubcategoryInfos(categoryRelations);
        categoryInfo.setSubcategories(subcategories);
    }

    private void createNewCategory(String categoryName, User user, String type) {
        Category category = new Category();
        category.setUser(user);
        category.setName(categoryName);
        category.setSequence(getNextSequenceNumber());
        category.setType(type);
        categoryRepository.save(category);
    }

    private Integer getNextSequenceNumber() {
        Category lastCategory = categoryRepository.findFirstByOrderBySequenceDesc();
        return lastCategory.getSequence() + 1;
    }
}
