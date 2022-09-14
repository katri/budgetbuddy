package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.app.setup.CategoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface CategoryRepository extends JpaRepository<ee.bcs.budgetbuddy.domain.category.Category, Integer> {

    @Query("select c from Category c where c.user.id = ?1 and c.type = ?2 order by c.sequence")
    List<Category> findCategoriesBy(Integer id, String type);

}