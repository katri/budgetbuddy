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
import java.util.Optional;

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
        Optional<Category> category = categoryRepository.findById(userId);
        Optional<CategoryRelation> categoryRelation = categoryRelationRepository.findById(category.get().getId());
        Subcategory subcategory = categoryRelation.get().getSubcategory();

        subcategoryRepository.


        //   List<Category> categories = categoryRepository.findCategoriesBy(userId, "i");

        List<CategoryInfo> categoryInfos = categoryMapper.CategoriesToCategoryInfos(categories);

    //    categoryRelationRepository.findSubcategoriesBy()

        ArrayList<SubcategoryInfo> subCategoryInfos = new ArrayList<>();

        // List<Subcategory> subcategories = subcategoryRepository.findSubcategories




        SetupResponse setupResponse = new SetupResponse();
        setupResponse.setCategories(categoryInfos);
        return setupResponse;


//        private void addUserToAllCategories(List<Category> categories, User user) {
//            for (Category category : categories) {
//                category.setUser(user);
//            }
//        }

//        CategoryInfos.add(CategoryInfos);
//
//        setupResponse.setCategories(CategoryInfos);
//
//        ArrayList<SubcategoryInfo> subcategories = new ArrayList<>();
//
//        ArrayList<SubcategoryInfo> subcategories = createActiveSubcategoryInfos(1);


//        ArrayList<SubcategoryInfo> subcategoriesActive = createActiveSubcategoryInfos(1);
//        ArrayList<SubcategoryInfo> subcategoriesPassive = createPassiveSubcategoryInfos(2);
//
//        CategoryInfo categoryInfo1 = createCategoryInfo("Aktiivne tulu", 1, subcategoriesActive);
//        CategoryInfo categoryInfo2 = createCategoryInfo("Passiivne tulu", 2, subcategoriesPassive);
//
//        List<CategoryInfo> CategoryInfos = new ArrayList<>();
//        CategoryInfos.add(categoryInfo1);
//        CategoryInfos.add(categoryInfo2);
//
//        SetupResponse setupResponse = new SetupResponse();
//        setupResponse.setCategories(CategoryInfos);
//        return setupResponse;


    }
}
