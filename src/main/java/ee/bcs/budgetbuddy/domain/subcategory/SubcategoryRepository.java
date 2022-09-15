package ee.bcs.budgetbuddy.domain.subcategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {
    Subcategory findFirstByOrderBySequenceDesc();

}