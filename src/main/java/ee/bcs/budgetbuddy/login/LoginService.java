package ee.bcs.budgetbuddy.login;

import ee.bcs.budgetbuddy.domain.category.Category;
import ee.bcs.budgetbuddy.domain.category.CategoryRelation;
import ee.bcs.budgetbuddy.domain.category.CategoryService;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryRelation;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryRelationRepository;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryService;
import ee.bcs.budgetbuddy.domain.standardSubcategory.StandardSubcategory;
import ee.bcs.budgetbuddy.domain.standardSubcategory.StandardSubcategoryService;
import ee.bcs.budgetbuddy.domain.subcategory.Subcategory;
import ee.bcs.budgetbuddy.domain.subcategory.SubcategoryService;
import ee.bcs.budgetbuddy.domain.user.*;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private StandardCategoryService standardCategoryService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private StandardSubcategoryService standardSubcategoryService;
    @Resource
    private SubcategoryService subcategoryService;

    @Resource
    private StandardCategoryRelationRepository standardCategoryRelationRepository;

    public UserResponse registerNewUser(UserRequest request) {
        User user = userService.addUser(request);
        createCustomCategoriesFromTemplate(user);
        createCustomSubcategoriesFromTemplate(user);
        return userMapper.userToUserResponse(user);
    }

    public void createCustomCategoriesFromTemplate(User user) {
        List<StandardCategory> standardCategories = standardCategoryService.findAllCategories();
        List<Category> categories = categoryService.createCategoriesForUser(standardCategories);
        updateCategoriesWithUser(categories, user);
        categoryService.saveCategoriesToDatabase(categories);
    }

    public void updateCategoriesWithUser(List<Category> categories, User user) {
        for (Category category : categories) {
            category.setUser(user);
        }
    }

    public void createCustomSubcategoriesFromTemplate(User user) {
        List<StandardSubcategory> standardSubcategories = standardSubcategoryService.findAllSubcategories();
        List<Subcategory> subcategories = subcategoryService.createSubcategoriesForUser(standardSubcategories);
        //updateSubcategoriesWithUser(subcategories);
        subcategoryService.saveSubcategoriesToDatabase(subcategories);
    }

    private List<CategoryRelation> createCategoryRelations(List<Category> categories, List<Subcategory> subcategories) {
        List<CategoryRelation> result = new ArrayList<>();
//
//        // otsime ülesse kõik standard_category_relation tabeli read
        List<StandardCategoryRelation> standardRelations = standardCategoryRelationRepository.findAll();
//
//        // teeme for tsükli nendest ridadest
        for (StandardCategoryRelation standardRelation : standardRelations) {
//
//            // otsime ülesse KONKREETSE rea kategooria ja alamkategooria nime
            String categoryName = standardRelation.getStandardCategory().getName();
            String subcategoryName = standardRelation.getStandardSubcategory().getName();
//
//            // otsime ülesse nende nimede järgi ülesse konkreetsed kategooria ja alamkategooria objektid
            Category category = getCategoryByName(categories, categoryName);
            Subcategory subcategory = getSubcategoryByName(subcategories, subcategoryName);
//
//            // loome ühe CATEGORY_RELATION tabeli rea objekti
            CategoryRelation categoryRelation = new CategoryRelation();
//
//
//            // Põhimõtteliselt täidame ära CATEGORY_RELATION tabeli veerud category_id, subcategory_id, is_active
//            // Aga seda siis Java mõistes teeme seda ikka vastavate objektidega.
            categoryRelation.setCategory(category);
            categoryRelation.setSubcategory(subcategory);
            categoryRelation.setIsActive(true);
//
//            // andmebaasi mõistes lisame selle meetodi tagastatavasse 'result' listi
//            // ühe CATEGORY_RELATION tabeli rea
            result.add(categoryRelation);
        }
//
        return result;
    }

    private Category getCategoryByName(List<Category> categories, String categoryName) {
//        // andmebaasi mõistes käime for tsükkliga kõik CATEGORY tabeli read ükshaaval läbi
        for (Category category : categories) {
//            // (andmebaasi mõttes) kui leiame sellise CATEGORY tabeli rea mille 'name' klapib otsitava nimega,
            if (category.getName().equals(categoryName)) {
//                // siis me tagastame selle rea. Java mõttes siis tagastame 'category' objekti
                return category;
            }
        }
//        // Kui mingi ime läbi me ei leia vastet (idee järgi ei tohiks seda kuidagi juhtuda, siis viskame ülesse süsteemi vea.
//        // Päris elus logitakse selliine viga kuhugi logi faili ka maha.
        throw new RuntimeException("ERROR (Create Custom Categories From Template) Could not get category by name: " + categoryName);
    }

    //
    private Subcategory getSubcategoryByName(List<Subcategory> subcategories, String subcategoryName) {
        for (Subcategory subcategory : subcategories) {
            if (subcategory.getName().equals(subcategoryName)) {
                return subcategory;
            }
        }
        throw new RuntimeException("ERROR (Create Custom Categories From Template) Could not get subcategory by name: " + subcategoryName);
    }


    //private void updateSubcategoriesWithUser(List<Subcategory> subcategories, User user) {
    // for (Subcategory subcategory : subcategories){
    // subcategory.setUser
    // }


}
