package ee.bcs.budgetbuddy.domain.standardSubcategory;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Scanner;

@Service

public class StandardSubcategoryService {

    @Resource
    private StandardSubcategoryRepository standardSubcategoryRepository;
    public List<StandardSubcategory> findAllSubcategories() {
        return standardSubcategoryRepository.findAll();
    }
}


