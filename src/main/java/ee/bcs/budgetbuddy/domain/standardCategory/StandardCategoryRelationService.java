package ee.bcs.budgetbuddy.domain.standardCategory;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StandardCategoryRelationService {
    @Resource
    private StandardCategoryRelationRepository standardCategoryRelationRepository;

    public List<StandardCategoryRelation> findAll() {
        return standardCategoryRelationRepository.findAll();
    }
}
