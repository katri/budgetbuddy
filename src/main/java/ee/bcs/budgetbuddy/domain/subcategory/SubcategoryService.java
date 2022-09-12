package ee.bcs.budgetbuddy.domain.subcategory;

import ee.bcs.budgetbuddy.domain.standardSubcategory.StandardSubcategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class SubcategoryService {
    @Resource
    private SubcategoryMapper subcategoryMapper;
    @Resource
    private SubcategoryRepository subcategoryRepository;

    public List<Subcategory> createSubcategoriesForUser(List<StandardSubcategory> standardSubcategories) {
       return subcategoryMapper.standardSubcategoriesToSubcategories(standardSubcategories);
    }

    public void saveSubcategoriesToDatabase(List<Subcategory> subcategories) {
        subcategoryRepository.saveAll(subcategories);
    }
}
