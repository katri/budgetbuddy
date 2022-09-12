package ee.bcs.budgetbuddy.domain.standardCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StandardCategoryRepository extends JpaRepository<StandardCategory, Integer> {
}