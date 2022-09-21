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

    public List<PlanningInfo> displayBudgetedSumsForMonth(PlanningRequest request) {
        List<Budgeted> budgetedSums = budgetedRepository.displayBudgetedSumsBy(request.getYear(), request.getMonth(), request.getUserId());
        return budgetedMapper.budgetedSumsToPlanningInfos(budgetedSums);
    }

    public void saveBudgetedSumsForMonth(List<PlanningInfo> planningInfos) {
        Integer userId = planningInfos.get(0).getUserId();
        List<Budgeted> budgetedSums = budgetedRepository.findBudgetedSumsBy(userId);
                budgetedMapper.planningInfosToBudgetedSums(planningInfos);
        for (Budgeted budgetedSum : budgetedSums) {
            Integer count = 0;
            PlanningInfo planningInfo = planningInfos.get(count);
            budgetedSum.setMonth(monthService.findById(planningInfo.getMonth()));
            budgetedSum.setUser(userService.findById(planningInfo.getUserId()));
            budgetedSum.setSubcategory(subcategoryService.findById(planningInfo.getSubcategoryId()));
            count++;
        }
        budgetedRepository.saveAll(budgetedSums);
    }
}
