package ee.bcs.budgetbuddy.login;

import ee.bcs.budgetbuddy.domain.user.UserRequest;
import ee.bcs.budgetbuddy.domain.user.UserResponse;
import ee.bcs.budgetbuddy.domain.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")

public class LoginController {
    @Resource
    private LoginService loginService;


    @PostMapping("/register/user")
    @Operation(summary = "Uue kasutaja lisamine")
    public UserResponse registerNewUser(@RequestBody UserRequest request) {
        return loginService.registerNewUser(request);
    }










    // TODO:  createCustomCategoriesFromStandardTemplate(int month, int year, User user)

    //  tee kõik vajalikud packaged ja struktuur, et paigutada ära kõik klassid
    //  standardCategory: StandardCategory, StandardCategoryRelation, StandardSubcategory
    //  category: Category, CategoryRelation, Subcategory

    //  leia StandardCategoryRelationService->StandardCategoryRelationRepository kaudu andmebaasist kõik tabeli standard_category_relation read
    //  tee neist List<StandardCategoryRelation> 'standardCategoryRelations' objektide list
    //  Loo CategoryMapper üksik objekti mäpper standardCategoryRelationToCategory()
    //  Mäppige ära väljad 'name', 'sequence' ja 'type'
    //  'id' välja jaoks on tähtis mäppida ingore = true. Neid väärtusi me ei taha ise lisada/mäppida (peavad jääma 'null'iks).
    //  Need id-d tulevad ise hiljem kui kõik need read maha salvestame
    //  lisage List versioon mapperist standardCategoryRelationsToCategories
    //  Kasutage seda List mäpperit ning looge list 'categories'
    //  Tehke üks uus meetod updateCategoriesWithUser(List<Category> categories, User user)
    //  Selle meetodid sees käige see list for tsükkliga läbi ja lisage igale category objektile see user külge
    //  Nüüd saate CategoryService->CategoryRepository kaudu need read maha salvestada
    //  Vihje: saveAll ;-)

    // TODO: peale seda tehke põhimõtteliselt sama asi ära aga 'standardCategoryRelations' to Subcategories

    // TODO: Nüüd tuleks veel lisada andmed category_relation tabeli jaoks
    //  Aga see on teie jaoks veitsa liiga keeruline teema, seega ma aitan teil selle teil ise ära progeda :)

}
