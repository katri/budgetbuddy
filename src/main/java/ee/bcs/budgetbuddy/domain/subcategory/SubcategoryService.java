package ee.bcs.budgetbuddy.domain.subcategory;

import ee.bcs.budgetbuddy.domain.standardSubcategory.StandardSubcategory;
import ee.bcs.budgetbuddy.domain.standardSubcategory.StandardSubcategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class SubcategoryService {

    @Resource
    private StandardSubcategoryService standardSubcategoryService;

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
}
