package ee.bcs.budgetbuddy.domain.subcategory;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {
    Subcategory findFirstByOrderBySequenceDesc();

}