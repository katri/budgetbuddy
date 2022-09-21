package ee.bcs.budgetbuddy.domain.user.month;

import ee.bcs.budgetbuddy.domain.Month;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthRepository extends JpaRepository<Month, Integer> {
}