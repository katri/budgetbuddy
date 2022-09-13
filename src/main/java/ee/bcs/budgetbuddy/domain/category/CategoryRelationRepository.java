package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.domain.subcategory.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRelationRepository extends JpaRepository<CategoryRelation, Integer> {

    @Query("select c from CategoryRelation c where c.category.id = ?1 order by c.category.sequence")
    List<CategoryRelation> findSubCategoriesBy(Integer categoryId);

}