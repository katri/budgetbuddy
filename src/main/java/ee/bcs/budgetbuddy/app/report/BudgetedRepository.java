package ee.bcs.budgetbuddy.app.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BudgetedRepository extends JpaRepository<Budgeted, Integer> {


    @Query("select b from Budgeted b where b.year = ?1 and b.month.id = ?2 and b.subcategory.id = ?3")
    Budgeted findBudgetedSumBy(Integer year, Integer month, Integer subcategoryId);


    @Query("select b from Budgeted b where b.year = ?1 and b.month.id = ?2 and b.user.id = ?3 and b.isActive = true")
    List<Budgeted> displayBudgetedSumsBy(Integer year, Integer month, Integer userId);


      @Query("select b from Budgeted b where b.user.id = ?1")
    List<Budgeted> findBudgetedSumsBy(Integer userId);

}