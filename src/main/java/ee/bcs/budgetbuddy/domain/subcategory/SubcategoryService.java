package ee.bcs.budgetbuddy.domain.subcategory;

import ee.bcs.budgetbuddy.domain.category.Category;
import ee.bcs.budgetbuddy.domain.category.CategoryRelation;
import ee.bcs.budgetbuddy.domain.category.CategoryRelationService;
import ee.bcs.budgetbuddy.domain.category.CategoryService;
import ee.bcs.budgetbuddy.domain.standardSubcategory.StandardSubcategory;
import ee.bcs.budgetbuddy.domain.standardSubcategory.StandardSubcategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service

public class SubcategoryService {

    @Resource
    private StandardSubcategoryService standardSubcategoryService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryRelationService categoryRelationService;

    @Resource
    private SubcategoryMapper subcategoryMapper;

    @Resource
    private SubcategoryRepository subcategoryRepository;


    public List<Subcategory> createAndSaveSubcategories() {
        List<StandardSubcategory> standardSubcategories = standardSubcategoryService.findAllSubcategories();
        List<Subcategory> subcategories = subcategoryMapper.standardSubcategoriesToSubcategories(standardSubcategories);
        subcategoryRepository.saveAll(subcategories);
        return subcategories;
    }

    @Transactional
    public void addSubcategory(Integer categoryId, String subcategoryName) {
        Category category = categoryService.findById(categoryId);
        Subcategory subcategory = createNewSubcategory(subcategoryName, category);
        categoryRelationService.addCategoryRelation(category, subcategory);
    }

    private Subcategory createNewSubcategory(String subcategoryName, Category category) {
        Subcategory subcategory = new Subcategory();
        subcategory.setName(subcategoryName);
        subcategory.setSequence(getNextSequenceNumber());
        subcategory.setType(category.getType());
        subcategoryRepository.save(subcategory);
        return subcategory;
    }

    private Integer getNextSequenceNumber() {
        return subcategoryRepository.findFirstByOrderBySequenceDesc().getSequence() + 1;
    }

    public void updateSubcategoryName(Integer subcategoryId, String subcategoryName) {
        Subcategory subcategory = subcategoryRepository.getReferenceById(subcategoryId);
        subcategory.setName(subcategoryName);
        subcategoryRepository.save(subcategory);
    }

}
