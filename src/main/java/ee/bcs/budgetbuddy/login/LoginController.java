package ee.bcs.budgetbuddy.login;

import ee.bcs.budgetbuddy.domain.user.UserRequest;
import ee.bcs.budgetbuddy.domain.user.UserResponse;
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

    // Palun töötage see info rida-realt, sõna-sõnalt mitmeid kordi korralikult läbi.


    //  Lisage kõik uued klassid domain package alla. Teeme hiljem koos selle strukuuri korda.


    // TODO: EESMÄRGID (A,B,C) - Kanda üle kõik andmed tabelist:
        //  A)  STANDARD_CATEGORY           ->  CATEGORY
        //  B)  STANDARD_SUBCATEGORY        ->  SUBCATEGORY
        //  C)  STANDARD_CATEGORY_RELATION  ->  CATEGORY_RELATION

    // TODO: jätka meetodi createCustomCategoriesFromTemplate(User user) implementeerimi st (lahenduse loomist)

    //  Selle meetodi sees pead ära tegema kõik A,B,C tegevused
        //  1) leia StandardCategoryService -> StandardCategoryRepository kaudu andmebaasist tabeli STANDARD_CATEGORY KÕIK!!!! read.
        //  (vihje: repository interface klasse saab luua IntelliJ abiga - new -> Spring Data Repository)
        //  Repository abiga saad sa teha List<StandardCategory> 'standardCategories' objektide listi (vihje: findAll() meetod).
        //  Andmebaasi mõttes, saad sa nii kätte kõik standard "STANDARD_CATEGORY" read

        //  2) Järgmise sammuna pead sa 'standardCategories' listist tegema listi 'categories', mis on siis list Category klassi objektides (ka entity)
        //  Andmebaasi mõistes, pead sa ette valimistama tabeli "CATEGORY" read

        //  Seda tegevust oleks kõige mõistlikum teha mäpperi abil:
            //  Loo CategoryMapper klassi üksik entity mäpper.
                // andmebaasi tabelite mõttes mäpiks see ära ühe rea tabelitest: standard_category ->  category

                    //  väljad/veerud 'name', 'sequence' ja 'type' on mõlemal tabelil/objektil samad
                    //  Need suudab mapsStruct ise ära mäppida
                    //  'id' välja jaoks on tähtis mäppida "ingore = true". Neid väärtusi me ei taha ise lisada/mäppida (peavad jääma 'null'iks).
                    //  Need id-d tulevad ise hiljem kui kõik need read maha salvestame

            //  lisage List versioon sellest mapperist

            // Kutsuge nüüd selle createCustomCategoriesFromTemplate(User user) meetodi sees välja seda List versiooni mäpperit ning looge list 'categories'

        //  3) Nüüd on vaja lahendada ära see probleem ära, et saaks kenasti 'categories' listi objektidele ka kõik userid külge
        //  Tehke üks LoginService alla üks uus meetod updateCategoriesWithUser(List<Category> categories, User user)
        //  Sellesse meetodisse antakse kaasa 'categories' list ja 'user'
        //  Selle meetodid sees käige for tsükkliga see 'categories' läbi
        //  ja lisage igale 'category' objektile külge see siia meetodisse kaasa antud 'user'
        //  Andmebaasi mõistes täidetakse ära user_id aga Java mõistes on nüüd Category klassi objektidel küljes 'user' objekt


        //  4) Nüüd saate CategoryService -> CategoryRepository kaudu need read maha salvestada (Vihje: saveAll() meetod)
        //  Andmebaasi mõistes täidetakse CATEGORY tabelis ära 'id' väärtused
            // Java mõistes on nüüd Category klassi objektidel küljes 'id' väärtused


    // TODO: peale seda tehke põhimõtteliselt sama asi ära aga 'standardCategories' ->  'subcategories'
        //  Ikka sama muster/süsteem (v.a seda osa, et SUBCATEGORY tabelis pole meil user_id, sega pole vaja listi 'user'iga updateda)
            //  StandardSubcategoryRepository et saada kätte kõik standardSubcategories read (findAll)
            //  SubcategoryMapper-isse vastavad mäpperid ( 'standardSubcategories' -> 'subcategories')
            //  Salvestage SubcategoryService -> SubcategoryRepository kaudu 'subcategories' andmed andmebaasi maha

    // TODO: Eesmärgid A ja B peaksid olema nüüd siinkohal täidetud.

    // TODO: Jääb vaid veel see eesmärk C
    //  Aga see on teie jaoks veitsa liiga keeruline teema, seega ma aitan teil selle teil ise ära progeda :)
    //  All pool on väljakommenteeritud meetodid, mille te peaksite lisama LoginService klassi
    //  Kui need meetodid on seal kenasti olemas siis peaksite veel tegema viimased 2 sammu

        // 1) kutsuge ikka selles samas createCustomCategoriesFromTemplate() meetodi sees välja createCategoryRelations(categories, subcategories) meetod
        //  andes sisendiks kaasa 'categories' ja 'subcategories' listid
        //  See createCategoryRelations() meetod siis tagastab listi 'categoryRelations'

        // 2) Nüüd saate CategoryRelationService -> CategoryRelationRepository kaudu need read ('categoryRelations'= maha salvestada (Vihje: saveAll() meetod)


    // TODO: Kui nüüd kõik on super optimaalselt hästi tehtud,
    //  siis on teil seal LoginService klassis lisaks minu antud meetoditele järgnevad meetodid:

    // public UserResponse registerNewUser(UserRequest request)                     -   3 rida koodi
    // public void createCustomCategoriesFromTemplate(User user)                    -   9 rida koodi
    // public void updateCategoriesWithUser(List<Category> categories, User user)   -   3 rida koodi


    // TODO: Lisa need meetodid LoginService klassi (PEALE SEDA KUI OLETE A ja B ära teinud.
//
//    private List<CategoryRelation> createCategoryRelations(List<Category> categories, List<Subcategory> subcategories) {
//        // loome tühja CategoryRelation listi, mida see meetod lõpuks peab tagastama.
//        List<CategoryRelation> result = new ArrayList<>();
//
//        // otsime ülesse kõik standard_category_relation tabeli read
//        List<StandardCategoryRelation> standardRelations = standardCategoryRelationRepository.findAll();
//
//        // teeme for tsükli nendest ridadest
//        for (StandardCategoryRelation standardRelation : standardRelations) {
//
//            // otsime ülesse KONKREETSE rea kategooria ja alamkategooria nime
//            String categoryName = standardRelation.getStandardCategory().getName();
//            String subcategoryName = standardRelation.getStandardSubcategory().getName();
//
//            // otsime ülesse nende nimede järgi ülesse konkreetsed kategooria ja alamkategooria objektid
//            Category category = getCategoryByName(categories, categoryName);
//            Subcategory subcategory = getSubcategoryByName(subcategories, subcategoryName);
//
//            // loome ühe CATEGORY_RELATION tabeli rea objekti
//            CategoryRelation categoryRelation = new CategoryRelation();
//
//
//            // Põhimõtteliselt täidame ära CATEGORY_RELATION tabeli veerud category_id, subcategory_id, is_active
//            // Aga seda siis Java mõistes teeme seda ikka vastavate objektidega.
//            categoryRelation.setCategory(category);
//            categoryRelation.setSubcategory(subcategory);
//            categoryRelation.setIsActive(true);
//
//            // andmebaasi mõistes lisame selle meetodi tagastatavasse 'result' listi
//            // ühe CATEGORY_RELATION tabeli rea
//            result.add(categoryRelation);
//        }
//
//        return result;
//    }
//
//    private Category getCategoryByName(List<Category> categories, String categoryName) {
//        // andmebaasi mõistes käime for tsükkliga kõik CATEGORY tabeli read ükshaaval läbi
//        for (Category category : categories) {
//            // (andmebaasi mõttes) kui leiame sellise CATEGORY tabeli rea mille 'name' klapib otsitava nimega,
//            if (category.getName().equals(categoryName)) {
//                // siis me tagastame selle rea. Java mõttes siis tagastame 'category' objekti
//                return category;
//            }
//        }
//        // Kui mingi ime läbi me ei leia vastet (idee järgi ei tohiks seda kuidagi juhtuda, siis viskame ülesse süsteemi vea.
//        // Päris elus logitakse selliine viga kuhugi logi faili ka maha.
//        throw new RuntimeException("ERROR (Create Custom Categories From Template) Could not get category by name: " + categoryName);
//    }
//
//    private Subcategory getSubcategoryByName(List<Subcategory> subcategories, String subcategoryName) {
//        for (Subcategory subcategory : subcategories) {
//            if (subcategory.getName().equals(subcategoryName)) {
//                return subcategory;
//            }
//        }
//        throw new RuntimeException("ERROR (Create Custom Categories From Template) Could not get subcategory by name: " + subcategoryName);
//    }







































}
