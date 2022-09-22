package ee.bcs.budgetbuddy.app.setup;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/setup")
public class SetupController {

    @Resource
    private SetupService setupService;

    @GetMapping("/categories/income")
    @Operation(summary = "Ühe kasutaja tulukategooriate ja subkategooriate kuvamine",
            description = "Võetakse sisse kasutaja info, leitakse üles kasutaja kõik tulukategooriad (type i), " +
                    "seejärel leitakse CategoryMapperi abil subkategooriad ja tagastatakse kogu info SetupResponse sõnumis")
    public BudgetInfo getIncomeCategoriesSetup(Integer userId) {
        return setupService.getIncomeCategoriesSetup(userId);
    }

    @GetMapping("/categories/expense")
    @Operation(summary = "Ühe kasutaja kulukategooriate ja subkategooriate kuvamine",
            description = "Võetakse sisse kasutaja info, leitakse üles kasutaja kõik kulukategooriad (type o), " +
                    "seejärel leitakse CategoryMapperi abil subkategooriad ja tagastatakse kogu info SetupResponse sõnumis")
    public BudgetInfo getExpenseCategoriesSetup(Integer userId) {
        return setupService.getExpenseCategoriesSetup(userId);
    }

    @PostMapping("/subcategory/add")
    @Operation(summary = "Uue subkategooria lisamine kasutajale kategooria alla",
            description = "Võtab sisendiks kategooriaId ja kasutaja pandud subkategooria nime. Loob kategooria ja subkategooria seose CategoryRelations tabelissse")
    public void addSubcategory(Integer categoryId, String subcategoryName) {
        setupService.addSubcategory(categoryId, subcategoryName);
    }

    @PostMapping("/category/income/add")
    @Operation(summary = "Uue tulukategooria lisamine kasutajale",
            description = "Võtab sisendiks kasutaja id ja kasutaja pandud tulugrupi nime, salvestab uue Category andmebaasi")
    public void addIncomeCategory(Integer userId, String categoryName) {
        setupService.addIncomeCategory(userId, categoryName);
    }

    @PostMapping("/category/expense/add")
    @Operation(summary = "Uue kulukategooria lisamine kasutajale",
            description = "Võtab sisendiks kasutaja id ja kasutaja pandud kulugrupi nime, salvestab uue Category andmebaasi")
    public void addExpenseCategory(Integer userId, String categoryName) {
        setupService.addExpenseCategory(userId, categoryName);
    }

    @PatchMapping("/category/update")
    @Operation(summary = "Kategooria nime muutmine",
            description = "")
    public void updateCategoryName(Integer categoryId, String categoryName) {
        setupService.updateCategoryName(categoryId, categoryName);
    }

    @PatchMapping("/subcategory/update")
    @Operation(summary = "Subkategooria nime muutmine",
            description = "")
    public void updateSubcategoryName(Integer subcategoryId, String subcategoryName) {
        setupService.updateSubcategoryName(subcategoryId, subcategoryName);
    }

    @PatchMapping("/category/status")
    @Operation(summary = "Kategooria kustutamine kasutaja jaoks",
            description = "Muudab andmebaasis kategooria isActive staatuse false-ks")
    public void updateCategoryIsActiveStatus(Integer categoryId, Boolean isActive) {
        setupService.updateCategoryIsActiveStatus(categoryId, isActive);
    }

    @PatchMapping("/subcategory/status")
    @Operation(summary = "Subkategooria kustutamine kasutaja jaoks",
            description = "Muudab andmebaasis kategooria isActive staatuse false-ks")
    public void updateSubcategoryIsActiveStatus(Integer subcategoryId, Boolean isActive) {
        setupService.updateSubcategoryIsActiveStatus(subcategoryId, isActive);
    }

    @GetMapping("/subcategories/all")
    @Operation(summary = "Valitud kasutaja kõikide alamkategooriate kuvamine listina")
    public List<SubcategoryInfo> findSubcategories(Integer userId) {
        return setupService.findSubcategories(userId);
    }
}



