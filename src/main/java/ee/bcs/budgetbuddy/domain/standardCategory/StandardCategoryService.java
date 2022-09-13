package ee.bcs.budgetbuddy.domain.standardCategory;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StandardCategoryService {

    @Resource
    private StandardCategoryRepository standardCategoryRepository;


    public List<StandardCategory> findAllStandardCategories() {
       return standardCategoryRepository.findAll();
    }
}
