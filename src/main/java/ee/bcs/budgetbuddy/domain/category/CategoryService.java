package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.app.setup.CategoryInfo;
import ee.bcs.budgetbuddy.app.setup.SetupResponse;
import ee.bcs.budgetbuddy.app.setup.SubcategoryInfo;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryService;
import ee.bcs.budgetbuddy.domain.subcategory.Subcategory;
import ee.bcs.budgetbuddy.domain.subcategory.SubcategoryMapper;
import ee.bcs.budgetbuddy.domain.subcategory.SubcategoryRepository;
import ee.bcs.budgetbuddy.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        List<CategoryInfo> categoryInfos = createCategoryInfos(userId, "i");
        for (CategoryInfo categoryInfo : categoryInfos) {
            addSubcategory(categoryInfo);
        }
        SetupResponse setupResponse = new SetupResponse();
        setupResponse.setCategories(categoryInfos);
        return setupResponse;
    }

    public SetupResponse getExpenseCategoriesSetup(Integer userId) {
        List<CategoryInfo> categoryInfos = createCategoryInfos(userId, "o");
        for (CategoryInfo categoryInfo : categoryInfos) {
            addSubcategory(categoryInfo);
        }
        SetupResponse setupResponse = new SetupResponse();
        setupResponse.setCategories(categoryInfos);
        return setupResponse;
    }

    private List<CategoryInfo> createCategoryInfos(Integer userId, String type) {
        List<Category> categories = categoryRepository.findCategoriesBy(userId, type);
        List<CategoryInfo> categoryInfos = categoryMapper.CategoriesToCategoryInfos(categories);
        return categoryInfos;
    }


    private void addSubcategory(CategoryInfo categoryInfo) {
        List<CategoryRelation> categoryRelations = categoryRelationRepository.findSubCategoriesBy(categoryInfo.getCategoryId());
        List<SubcategoryInfo> subcategories = categoryRelationsMapper.CategoryRelationsToSubcategoryInfos(categoryRelations);
        categoryInfo.setSubcategories(subcategories);
    }


}
