package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.domain.subcategory.SubcategoryService;
import ee.bcs.budgetbuddy.domain.user.UserService;
import ee.bcs.budgetbuddy.domain.user.month.MonthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BudgetedService {

    @Resource
    private MonthService monthService;

    @Resource
    private UserService userService;

    @Resource
    private SubcategoryService subcategoryService;

    @Resource
    private BudgetedMapper budgetedMapper;

    @Resource
    private BudgetedRepository budgetedRepository;

    public Float findBudgetedSumInMonth(Integer year, Integer month, Integer subcategoryId) {
        return budgetedRepository.findBudgetedSumBy(year, month, subcategoryId).getAmount();
    }


    public void saveBudgetedSumsForMonth(List<PlanningInfo> planningInfos) {
        Integer userId = planningInfos.get(0).getUserId();
        List<Budgeted> budgetedSums = budgetedRepository.findBudgetedSumsBy(userId);
        budgetedMapper.planningInfosToBudgetedSums(planningInfos);
        Integer count = 0;
        for (Budgeted budgetedSum : budgetedSums) {
            PlanningInfo planningInfo = planningInfos.get(count);
            budgetedSum.setAmount(planningInfo.getAmount());
            count++;
        }
        budgetedRepository.saveAll(budgetedSums);
    }

    public List<PlanningInfo> displayBudgetedSumsForMonth(Integer userId, Integer year, Integer month) {
        List<Budgeted> budgetedSums = budgetedRepository.displayBudgetedSumsBy(userId, year, month);
        return budgetedMapper.budgetedSumsToPlanningInfos(budgetedSums);
    }

}

