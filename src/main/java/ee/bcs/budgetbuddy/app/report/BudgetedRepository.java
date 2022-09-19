package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.domain.Budgeted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BudgetedRepository extends JpaRepository<Budgeted, Integer> {


    @Query("select b from Budgeted b where b.year = ?1 and b.month.id = ?2 and b.subcategory.id = ?3")
    Budgeted findBudgetedSumBy(Integer year, Integer month, Integer subcategoryId);


}