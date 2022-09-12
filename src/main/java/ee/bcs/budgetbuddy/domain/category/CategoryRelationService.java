package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryRelation;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategoryRelationRepository;
import ee.bcs.budgetbuddy.domain.subcategory.Subcategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryRelationService {

    @Resource
    private CategoryRelationRepository categoryRelationRepository;

    @Resource
    private StandardCategoryRelationRepository standardCategoryRelationRepository;


    public void createAndSaveCategoryRelations(List<Category> categories, List<Subcategory> subcategories) {
        //valmistame ette category_relations read
        List<CategoryRelation> categoryRelations = createCategoryRelations(categories, subcategories);

        //salvestame read
        categoryRelationRepository.saveAll(categoryRelations);
    }

    private List<CategoryRelation> createCategoryRelations(List<Category> categories, List<Subcategory> subcategories) {
        // teeme valmis ühe tühja categoryRelations listi
        List<CategoryRelation> categoryRelations = new ArrayList<>();

        // otsime ülesse kõik standard_category_relation tabeli read
        List<StandardCategoryRelation> standardRelations = standardCategoryRelationRepository.findAll();

        // teeme for tsükli nendest ridadest
        for (StandardCategoryRelation standardRelation : standardRelations) {

            // otsime ülesse KONKREETSE rea kategooria ja alamkategooria nime
            // otsime ülesse nende nimede järgi ülesse konkreetsed kategooria ja alamkategooria objektid
            String categoryName = standardRelation.getStandardCategory().getName();
            Category category = getCategoryByName(categories, categoryName);
            String subcategoryName = standardRelation.getStandardSubcategory().getName();
            Subcategory subcategory = getSubcategoryByName(subcategories, subcategoryName);

            // loome ühe CATEGORY_RELATION tabeli rea objekti
            CategoryRelation categoryRelation = new CategoryRelation();

            // Põhimõtteliselt täidame ära CATEGORY_RELATION tabeli veerud category_id, subcategory_id, is_active
            // Aga seda siis Java mõistes teeme seda ikka vastavate objektidega.
            categoryRelation.setCategory(category);
            categoryRelation.setSubcategory(subcategory);
            categoryRelation.setIsActive(true);

            // andmebaasi mõistes lisame selle meetodi tagastatavasse 'categoryRelations' listi
            // ühe CATEGORY_RELATION tabeli rea
            categoryRelations.add(categoryRelation);
        }
        // tagastame tulemuse (categoryRelations listi)
        return categoryRelations;
    }

    private Category getCategoryByName(List<Category> categories, String categoryName) {

        // andmebaasi mõistes käime for tsükkliga kõik CATEGORY tabeli read ükshaaval läbi
        for (Category category : categories) {

            // (andmebaasi mõttes) kui leiame sellise CATEGORY tabeli rea mille 'name' klapib otsitava nimega,
            if (category.getName().equals(categoryName)) {

                // siis me tagastame selle rea. Java mõttes siis tagastame 'category' objekti
                return category;
            }
        }

        // Kui mingi ime läbi me ei leia vastet (idee järgi ei tohiks seda kuidagi juhtuda, siis viskame ülesse süsteemi vea.
        // Päris elus logitakse selliine viga kuhugi logi faili ka maha.
        throw new RuntimeException("ERROR (Create Custom Categories From Template) Could not get category by name: " + categoryName);
    }

    //
    private Subcategory getSubcategoryByName(List<Subcategory> subcategories, String subcategoryName) {
        // põhimõtteliselt sama  mõte mis on getCategoryByName() meetodiga
        for (Subcategory subcategory : subcategories) {
            if (subcategory.getName().equals(subcategoryName)) {
                return subcategory;
            }
        }
        throw new RuntimeException("ERROR (Create Custom Categories From Template) Could not get subcategory by name: " + subcategoryName);
    }

}
