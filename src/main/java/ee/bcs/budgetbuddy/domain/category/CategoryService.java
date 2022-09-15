package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.app.setup.CategoryChangeRequest;
import ee.bcs.budgetbuddy.app.setup.CategoryInfo;
import ee.bcs.budgetbuddy.app.setup.SetupResponse;
import ee.bcs.budgetbuddy.app.setup.SubcategoryInfo;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryService;
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
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryRepository categoryRepository;

    @Resource
    private CategoryRelationService categoryRelationService;

    @Resource
    private CategoryRelationsMapper categoryRelationsMapper;

    @Resource
    private UserService userService;


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
        for (CategoryInfo categoryInfo : categoryInfos) {
            addSubcategory(categoryInfo);
        }
        SetupResponse setupResponse = new SetupResponse();
        setupResponse.setCategories(categoryInfos);
        return setupResponse;
    }

    public SetupResponse getExpenseCategoriesSetup(Integer userId) {
        List<CategoryInfo> categoryInfos = createCategoryInfos(userId, EXPENSE);
        for (CategoryInfo categoryInfo : categoryInfos) {
            addSubcategory(categoryInfo);
        }
        SetupResponse setupResponse = new SetupResponse();
        setupResponse.setCategories(categoryInfos);
        return setupResponse;
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

    public void addIncomeCategory(Integer userId, String categoryName) {
        User user = userService.findById(userId);
        createNewCategory(categoryName, user, INCOME);
    }

    public void addExpenseCategory(Integer userId, String categoryName) {
        User user = userService.findById(userId);
        createNewCategory(categoryName, user, EXPENSE);
    }

    private void createNewCategory(String categoryName, User user, String type) {
        Category category = new Category();
        category.setUser(user);
        category.setName(categoryName);
        category.setSequence(getNextSequenceNumber());
        category.setType(type);
        categoryRepository.save(category);
    }

    public Category findById(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    private Integer getNextSequenceNumber() {
        Category lastCategory = categoryRepository.findFirstByOrderBySequenceDesc();
        return lastCategory.getSequence() + 1;
    }

    public void changeCategoryName(CategoryChangeRequest request) {
        Category categoryData = categoryMapper.categoryChangeRequestToCategory(request);
        Integer categoryId = categoryData.getId();
        Category category = categoryRepository.getReferenceById(categoryId);
        category.setName(categoryData.getName());
        categoryRepository.save(category);
    }

//    public void deleteCategory(CategoryChangeRequest request) {
//        //  Category category = categoryMapper.categoryChangeRequestToCategory(request);
////         List<CategoryRelation> categoryRelations = categoryRelationsMapper.categoryChangeRequestToCategories(request);
//         CategoryRelation categoryRelation = categoryRelationsMapper.categoryChangeRequestToCategory(request);
//        for (CategoryRelation categoryRelation : categoryRelations) {
//            categoryRelation.setIsActive(false); // kuidas ma tegelikult selle siit sõnumist kätte saan?
//        }
//        categoryRelationService.saveAll(categoryRelations);
//    }
}
