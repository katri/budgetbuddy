package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.app.setup.CategoryInfo;
import ee.bcs.budgetbuddy.app.setup.SetupResponse;
import ee.bcs.budgetbuddy.app.setup.SubcategoryInfo;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryService;
import ee.bcs.budgetbuddy.domain.subcategory.Subcategory;
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

    private SubcategoryRepository subcategoryRepository;

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
        List<Category> categories = categoryRepository.findCategoriesBy(userId, "i");
        for (Category category : categories) {
            Integer categoryId = category.getId();

            List<CategoryRelation> categoryRelations = categoryRelationRepository.findSubCategoriesBy(categoryId);
//        Optional<CategoryRelation> categoryRelations;
//        categoryRelations = categoryRelationRepository.findById(categories.get().getId());
            ArrayList<Subcategory> subcategories = new ArrayList<>();
            for (CategoryRelation categoryRelation : categoryRelations) {
                Subcategory subcategory = categoryRelation.getSubcategory();
                subcategories.add(subcategory);

            }
        }
        List<CategoryInfo> categoryInfos = categoryMapper.CategoriesToCategoryInfos(categories);
        for (CategoryInfo categoryInfo : categoryInfos) {
            SubcategoryInfo subcategoryInfo =


        }

        SetupResponse setupResponse = new SetupResponse();
        setupResponse.setCategories(categoryInfos);
        return setupResponse;
    }


    private ArrayList<SubcategoryInfo> createActiveSubcategoryInfos(Integer categoryId, Subcategory subcategory) {
        ArrayList<SubcategoryInfo> subCategoryInfos = new ArrayList<>();
        for (SubcategoryInfo subcategoryInfo : subCategoryInfos) {
            createSubcategoryInfo(categoryId, subcategory);
            subCategoryInfos.add(subcategoryInfo);
        }
        return subCategoryInfos;

    }


    private SubcategoryInfo createSubcategoryInfo(Integer categoryId, Subcategory subcategory) {
        SubcategoryInfo subcategoryInfo = new SubcategoryInfo();
        subcategoryInfo.setCategoryId(categoryId);
        subcategoryInfo.setSubcategoryId(subcategory.getId());
        subcategoryInfo.setSubcategoryName(subcategory.getName());
        subcategoryInfo.setIsActive(true);
        return subcategoryInfo;
    }


}




