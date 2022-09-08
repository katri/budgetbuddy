package ee.bcs.budgetbuddy.app;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    // TODO: Koodi kirjutades vahetage pidevalt tiimiliiget, kes on klaviatuuri taga.

    // TODO: lasta andmebaasis peale uuesti create_tables.sql ja create_data.sql

    // TODO: lisa näidisandmeid tabelitesse standard_category, standard_subcategory, standard_category_relation
    //  salvesta insert laused create_data.sql'i
    //  type väärtused siis 'i' (incoming/tulud) ja 'o' (outgoing/kulud)
    //  Ei pea väga palju näidise andmeid kohe alguses lisama. Saate hiljem täiendada.


    // TODO: lisada kontroller uue kasutaja registreerimiseks
    //  /register/user
    //  sisse tulev request DTO info: username, password, email
    //  lisada kontrollerile klassile vastav service klass: LoginService
    //  LoginService klassi sees saad vajadusel Resource abil ligi teistele teenustele UserService, UserMapper, RoleService, jne
    //  lisada domain package alla uus package: user
    //  sinna user package sisse lisada: entity User, UserService, UserRepository
    //  Lisada user package sisse uus package: role
    //  Sinna role package sisse lisada: entity Role, RoleService, RoleRepository
    //  Enne kui saab uut 'user'it lisada peaks kontrollimia UserService -> UserRepositori kaudu,
    //  et kas selline username on juba kasutusel (vihje: 'exists')
    //  Tee validationService alla üks meetod, mis võtab sisse boolean'i ja username ning kui väärtus on 'true',
    //  siis tuleb vistata Business exception, stiilis, et "Selline kasutaja 'username' on juba kasutusel
    //  Loo useri sisse UserMapper ja lisa mäpper, mis loob DTO põhjal uue 'user' objekti
    //  Saad kõik asjad 'user'i külge ära mäppida, välja arvatud 'role'
    //  'role' saad kätte kasutades RoleService -> RoleRepository
    //  'role' saad otsida siis kas id '2', järgi, või siis name 'customer' järgi.
    //  nüüd kui 'role' on käes, siis tuleks see 'user'ile külge panna
    //  Nüüd saab RoleService-RoleRepository kaudu uue useri lisada/salvestada
    //  Seda 'user'it läheb sul veel vaja.
    //  Järgmise tegevusena tuleb LoginService alla luua meetod 'createCustomCategoryFromStandardTemplate(int month, int year, User user)'
    //  See meetod käivitatakse kohe, kui uus kasutaja 'user' on maha salvestatud. Esialgu võib seda meetodit kutsuda välja nii,
    //  et sisendid on koodi sisse kirjutatud 9 ja 2022

    // TODO:  createCustomCategoryFromStandardTemplate(int month, int year, User user)
    //  tee kõik vajalikud packaged ja struktuur, et paigutada ära kõik klassid
    //  StandardCategory, StandardCategoryRelation, StandardSubcategory
    //  Category, CategoryRelation, Subcategory
    //  leia StandardCategoryRelationService->StandardCategoryRelationRepository kaudu andmebaasist kõik
    //  List<StandardCategoryRelation> 'standardCategoryRelations' objektide list
    //  Loo CategoryMapper üksik objekti mäpper standardCategoryRelationToCategory()
    //  Mäppige ära väljad 'name', 'sequence' ja 'type'
    //  'id' välja jaoks on tähtis mäppida ingore = true. Neid väärtusi me ei taha ise lisada/mäppida (peavad jääma 'null'iks).
    //  Need id-d tulevad ise hiljem kui kõik need read maha salvestame
    //  lisage List versioon mapperist standardCategoriesToCategories
    //  Kasutage seda List mäpperit ning looge list 'categories'
    //  Tehke üks uus meetod updateCategoryWithUser(List<Category> categories, User user)
    //  Selle meetodid sees käige see list for tsükkliga läbi ja lisage igale category objektile see user külge
    //  Nüüd saate CategoryService->CategoryRepository kaudu need read maha salvestada
    //  Vihje: saveAll ;-)

    // TODO: peale seda tehke põhimõtteliselt sama asi ära aga 'standardCategoryRelations' to Subcategories

    // TODO: tuleks veel mäppida standard_category_relation andmed mäppida category_relation tabeli andmete jaoks ära
    //  Aga see on teie jaoks veitsa liiga keeruline teema, seega ma aitan teil selle teil ise ära progeda :)

}
