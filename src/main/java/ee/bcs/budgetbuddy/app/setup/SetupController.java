package ee.bcs.budgetbuddy.app.setup;

import ee.bcs.budgetbuddy.domain.category.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/setup")
public class SetupController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/categories/income")
    @Operation(summary = "Ühe kasutaja tulukategooriate ja subkategooriate kuvamine",
            description = "Võetakse sisse kasutaja info, leitakse üles kasutaja kõik tulukategooriad (type i), " +
                    "seejärel leitakse CategoryMapperi abil subkategooriad ja tagastatakse kogu info SetupResponse sõnumis")
    public SetupResponse getIncomeCategoriesSetup(Integer userId) {
        return categoryService.getIncomeCategoriesSetup(userId);
    }

    @GetMapping("/categories/expense")
    @Operation(summary = "Ühe kasutaja kulukategooriate ja subkategooriate kuvamine",
            description = "Võetakse sisse kasutaja info, leitakse üles kasutaja kõik kulukategooriad (type o), " +
                    "seejärel leitakse CategoryMapperi abil subkategooriad ja tagastatakse kogu info SetupResponse sõnumis")
    public SetupResponse getExpenseCategoriesSetup(Integer userId) {
        return categoryService.getExpenseCategoriesSetup(userId);
    }

    @PostMapping("subcategory/add")
    @Operation(summary = "Uue subkategooria lisamine kasutajale kategooria alla",
            description = "Võtab sisendiks kategooriaId ja kasutaja pandud subkategooria nime. Loob kategooria ja subkategooria seose CategoryRelations tabelissse")
    public void addSubcategory(Integer categoryId, String subcategoryName) {
        categoryService.addSubcategory(categoryId, subcategoryName);
    }

    @PostMapping("income/category/add")
    @Operation(summary = "Uue tulukategooria lisamine kasutajale",
            description = "Võtab sisendiks kasutaja id ja kasutaja pandud tulugrupi nime, salvestab uue Category andmebaasi")
    public void addIncomeCategory(Integer userId, String categoryName) {
        categoryService.addIncomeCategory(userId, categoryName);
    }

    @PostMapping("expense/category/add")
    @Operation(summary = "Uue kulukategooria lisamine kasutajale",
            description = "Võtab sisendiks kasutaja id ja kasutaja pandud kulugrupi nime, salvestab uue Category andmebaasi")
    public void addExpenseCategory(Integer userId, String categoryName) {
        categoryService.addExpenseCategory(userId, categoryName);
    }

    
    
//    public void updateCategoryInfo(@RequestBody CategoryChangeRequest request) {
//        categoryService.updateCategoryInfo(request);
//    }
}


// return createIncomeMockData();
// return createIncomeMockData();

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


