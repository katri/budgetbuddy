package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.app.setup.SubcategoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRelationRepository extends JpaRepository<CategoryRelation, Integer> {

    @Query("select c from CategoryRelation c where c.category.id = ?1 and c.isActive = true order by c.category.sequence")
    List<CategoryRelation> findSubCategoriesBy(Integer categoryId);


    @Query("select c from CategoryRelation c where c.category.id = ?1")
    List<CategoryRelation> findByCategory(Integer id);

    @Query("select c from CategoryRelation c where c.subcategory.id = ?1")
    CategoryRelation findBySubcategory(Integer id);


    @Query("select c from CategoryRelation c where c.category.user.id = ?1 and c.isActive = true order by c.category.sequence")
    List<CategoryRelation> findSubcategories(Integer id);





}