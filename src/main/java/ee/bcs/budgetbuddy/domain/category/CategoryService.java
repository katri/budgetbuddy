package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.app.setup.CategoryInfo;
import ee.bcs.budgetbuddy.app.setup.SetupResponse;
import ee.bcs.budgetbuddy.app.setup.SubcategoryInfo;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryService;
import ee.bcs.budgetbuddy.domain.user.User;
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
    private CategoryRelationRepository categoryRelationRepository;

    @Resource
    private CategoryRelationsMapper categoryRelationsMapper;

//    public  void updateCategoryInfo(CategoryChangeRequest request) {
//
//        CategoryRelation categoryRelation = categoryRelationsMapper.changeRequestToCategoryRelation(request);
//    }


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


}
