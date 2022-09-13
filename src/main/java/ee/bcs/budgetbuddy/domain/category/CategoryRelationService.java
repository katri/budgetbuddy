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
        List<CategoryRelation> categoryRelations = createCategoryRelations(categories, subcategories);
        categoryRelationRepository.saveAll(categoryRelations);
    }

    private List<CategoryRelation> createCategoryRelations(List<Category> categories, List<Subcategory> subcategories) {
        List<CategoryRelation> categoryRelations = new ArrayList<>();

        List<StandardCategoryRelation> standardRelations = standardCategoryRelationRepository.findAll();
        for (StandardCategoryRelation standardRelation : standardRelations) {
            Category category = getCategory(categories, standardRelation);
            Subcategory subcategory = getSubcategory(subcategories, standardRelation);
            CategoryRelation categoryRelation = createCategoryRelation(category, subcategory);
            categoryRelations.add(categoryRelation);
        }

        return categoryRelations;
    }

    private Category getCategory(List<Category> categories, StandardCategoryRelation standardRelation) {
        String categoryName = standardRelation.getStandardCategory().getName();
        Category category = getCategoryByName(categories, categoryName);
        return category;
    }

    private Category getCategoryByName(List<Category> categories, String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return category;
            }
        }
        throw new RuntimeException("ERROR (Create Custom Categories From Template) Could not get category by name: " + categoryName);
    }


    private Subcategory getSubcategory(List<Subcategory> subcategories, StandardCategoryRelation standardRelation) {
        String subcategoryName = standardRelation.getStandardSubcategory().getName();
        Subcategory subcategory = getSubcategoryByName(subcategories, subcategoryName);
        return subcategory;
    }

    private Subcategory getSubcategoryByName(List<Subcategory> subcategories, String subcategoryName) {
        // põhimõtteliselt sama  mõte mis on getCategoryByName() meetodiga
        for (Subcategory subcategory : subcategories) {
            if (subcategory.getName().equals(subcategoryName)) {
                return subcategory;
            }
        }
        throw new RuntimeException("ERROR (Create Custom Categories From Template) Could not get subcategory by name: " + subcategoryName);
    }

    private static CategoryRelation createCategoryRelation(Category category, Subcategory subcategory) {
        CategoryRelation categoryRelation = new CategoryRelation();
        categoryRelation.setCategory(category);
        categoryRelation.setSubcategory(subcategory);
        categoryRelation.setIsActive(true);
        return categoryRelation;
    }

}
