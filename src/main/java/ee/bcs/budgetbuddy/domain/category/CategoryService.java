package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.app.setup.CategoryInfo;
import ee.bcs.budgetbuddy.app.setup.SetupResponse;
import ee.bcs.budgetbuddy.app.setup.SubcategoryInfo;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryService;
import ee.bcs.budgetbuddy.domain.subcategory.Subcategory;
import ee.bcs.budgetbuddy.domain.subcategory.SubcategoryRepository;
import ee.bcs.budgetbuddy.domain.user.User;
import ee.bcs.budgetbuddy.domain.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    private CategoryRelationRepository categoryRelationRepository;

    @Resource
    private CategoryRelationsMapper categoryRelationsMapper;

    @Resource
    private SubcategoryRepository subcategoryRepository;

    @Resource
    private UserRepository userRepository;


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
        List<CategoryRelation> categoryRelations = categoryRelationRepository.findSubCategoriesBy(categoryInfo.getCategoryId());
        List<SubcategoryInfo> subcategories = categoryRelationsMapper.categoryRelationsToSubcategoryInfos(categoryRelations);
        categoryInfo.setSubcategories(subcategories);
    }

    @Transactional
    public void addSubcategory(Integer categoryId, String subcategoryName) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        Subcategory subcategory = createNewSubcategory(subcategoryName, category);
        createNewCategoryRelation(category, subcategory);
    }

    private Subcategory createNewSubcategory(String subcategoryName, Optional<Category> category) {
        Subcategory subcategory = new Subcategory();
        subcategory.setName(subcategoryName);

        // TODO: https://stackoverflow.com/questions/50871759/spring-data-get-last-record-from-the-table
        // TODO: leidsin lahenduse googledades "java jpa repository last id"
        subcategory.setSequence(getNextSequenceNumber()); // kuidas seda saada?
        subcategory.setType(category.get().getType());
        subcategoryRepository.save(subcategory);
        return subcategory;
    }

    private Integer getNextSequenceNumber() {
        Subcategory lastSubCategory = subcategoryRepository.findFirstByOrderByIdDesc();
        return lastSubCategory.getSequence() + 1;
    }

    private void createNewCategoryRelation(Optional<Category> category, Subcategory subcategory) {
        CategoryRelation categoryRelation = new CategoryRelation();
        categoryRelation.setCategory(category.get());
        categoryRelation.setSubcategory(subcategory);
        categoryRelation.setIsActive(true);
        categoryRelationRepository.save(categoryRelation);
    }

    public void addIncomeCategory(Integer userId, String categoryName) {
        Optional<User> user = userRepository.findById(userId);
        createNewCategory(categoryName, user, INCOME);
    }

    public void addExpenseCategory(Integer userId, String categoryName) {
        Optional<User> user = userRepository.findById(userId);
        createNewCategory(categoryName, user, EXPENSE);
    }

    private void createNewCategory(String categoryName, Optional<User> user, String type) {
        Category category = new Category();
        category.setUser(user.get());
        category.setName(categoryName);
        category.setSequence(100); // kuidas seda saada?
        category.setType(type);
        categoryRepository.save(category);
    }

}
