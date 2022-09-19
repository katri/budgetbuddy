package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.domain.Budgeted;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BudgetedService {

    @Resource
    private BudgetedRepository budgetedRepository;

    public Float findBudgetedSumInMonth(Integer year, Integer month, Integer subcategoryId) {
       return budgetedRepository.findBudgetedSumBy(year, month, subcategoryId).getAmount();
    }
}
