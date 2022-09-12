package ee.bcs.budgetbuddy.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRelationRepository extends JpaRepository<CategoryRelation, Integer> {
}