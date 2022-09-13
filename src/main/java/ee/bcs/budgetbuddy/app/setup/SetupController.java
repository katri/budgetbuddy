package ee.bcs.budgetbuddy.app.setup;

import ee.bcs.budgetbuddy.domain.category.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/setup")
public class SetupController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/categories/income")
    public SetupResponse getIncomeCategoriesSetup(Integer userId) {
        SetupResponse setupResponse = categoryService.getIncomeCategoriesSetup(userId);

        return setupResponse;
        // return createIncomeMockData();
    }

//    private SetupResponse createIncomeMockData() {
//        ArrayList<SubcategoryInfo> subcategoriesActive = createActiveSubcategoryInfos(1);
//        ArrayList<SubcategoryInfo> subcategoriesPassive = createPassiveSubcategoryInfos(2);
//
//        CategoryInfo categoryInfo1 = createCategoryInfo("Aktiivne tulu", 1, subcategoriesActive);
//        CategoryInfo categoryInfo2 = createCategoryInfo("Passiivne tulu", 2, subcategoriesPassive);
//
//        List<CategoryInfo> categories = new ArrayList<>();
//        categories.add(categoryInfo1);
//        categories.add(categoryInfo2);
//
//        SetupResponse setupResponse = new SetupResponse();
//        setupResponse.setCategories(categories);
//        return setupResponse;
//    }
//
//    private static ArrayList<SubcategoryInfo> createActiveSubcategoryInfos(int categoryId) {
//        ArrayList<SubcategoryInfo> subcategories = new ArrayList<>();
//        SubcategoryInfo subcategoryInfo1 = createSubcategoryInfo( categoryId,1, "Palk");
//        SubcategoryInfo subcategoryInfo2 = createSubcategoryInfo(categoryId,2, "Lastetoetus");
//        SubcategoryInfo subcategoryInfo3 = createSubcategoryInfo(categoryId,3, "Tööampsud");
//
//        subcategories.add(subcategoryInfo1);
//        subcategories.add(subcategoryInfo2);
//        subcategories.add(subcategoryInfo3);
//        return subcategories;
//    }
//    private static ArrayList<SubcategoryInfo> createPassiveSubcategoryInfos(int categoryId) {
//        ArrayList<SubcategoryInfo> subcategories = new ArrayList<>();
//        SubcategoryInfo subcategoryInfo1 = createSubcategoryInfo(categoryId,4, "Dividendid");
//        SubcategoryInfo subcategoryInfo2 = createSubcategoryInfo(categoryId,5, "Intressid");
//        SubcategoryInfo subcategoryInfo3 = createSubcategoryInfo(categoryId,6, "Üüritulu");
//
//        subcategories.add(subcategoryInfo1);
//        subcategories.add(subcategoryInfo2);
//        subcategories.add(subcategoryInfo3);
//        return subcategories;
//    }
//
//    private static SubcategoryInfo createSubcategoryInfo(int categoryId, int subcategoryId, String subcategoryName) {
//        SubcategoryInfo subcategoryInfo = new SubcategoryInfo();
//        subcategoryInfo.setCategoryId(categoryId);
//        subcategoryInfo.setSubcategoryId(subcategoryId);
//        subcategoryInfo.setSubcategoryName(subcategoryName);
//        subcategoryInfo.setIsActive(true);
//        return subcategoryInfo;
//    }
//
//    private static CategoryInfo createCategoryInfo(String categoryName, int categoryId, ArrayList<SubcategoryInfo> subcategories) {
//        CategoryInfo categoryInfo = new CategoryInfo();
//        categoryInfo.setCategoryName(categoryName);
//        categoryInfo.setCategoryId(categoryId);
//        categoryInfo.setSubcategories(subcategories);
//        return categoryInfo;
//    }

    @GetMapping("/categories/expense")
    public SetupResponse getExpenseCategoriesSetup(Integer userId) {
        return null;
    }
}
