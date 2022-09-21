package ee.bcs.budgetbuddy.app.report;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BudgetedService {

    @Resource
    private BudgetedMapper budgetedMapper;

    @Resource
    private BudgetedRepository budgetedRepository;

    public Float findBudgetedSumInMonth(Integer year, Integer month, Integer subcategoryId) {
       return budgetedRepository.findBudgetedSumBy(year, month, subcategoryId).getAmount();
    }

    public List<PlanningInfo> displayBudgetedSumsForMonth(PlanningRequest request) {
        List<Budgeted> budgetedSums = budgetedRepository.displayBudgetedSumsBy(request.getYear(), request.getMonth(), request.getUserId());
        return budgetedMapper.budgetedSumsToPlanningInfos(budgetedSums);
    }

    public void saveBudgetedSumsForMonth(List<PlanningInfo> planningRequest) {
        List<Budgeted> budgetedSums = budgetedMapper.planningInfosToBudgetedSums(planningRequest);
    }
}
