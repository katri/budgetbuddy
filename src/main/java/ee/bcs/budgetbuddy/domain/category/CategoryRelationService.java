package ee.bcs.budgetbuddy.domain.category;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryRelationService {
    @Resource
    private CategoryRelationRepository categoryRelationRepository;


    public void saveCategoryRelations(List<CategoryRelation> categoryRelations) {
        categoryRelationRepository.saveAll(categoryRelations);
    }
}
