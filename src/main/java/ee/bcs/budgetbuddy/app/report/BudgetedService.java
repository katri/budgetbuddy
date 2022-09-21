package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.domain.category.CategoryRelation;
import ee.bcs.budgetbuddy.domain.category.CategoryRelationService;
import ee.bcs.budgetbuddy.domain.category.CategoryService;
import ee.bcs.budgetbuddy.domain.user.UserService;
import ee.bcs.budgetbuddy.domain.user.month.MonthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class BudgetedService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private UserService userService;

    @Resource
    private MonthService monthService;


    @Resource
    private CategoryRelationService categoryRelationService;


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

    public void fillNewMonthBudgetedDataWithZeros(Integer userId, Integer year, Integer month) {
        List<CategoryRelation> categoryRelations = categoryRelationService.findAllRelationsForUser(userId);
        List<Budgeted> budgetedSums = budgetedMapper.categoryRelationsToBudgetedSums(categoryRelations);
        Integer count =0;
        for (Budgeted budgetedSum : budgetedSums) {
            CategoryRelation categoryRelation = categoryRelations.get(count);
            budgetedSum.setMonth(monthService.findById(month));
            budgetedSum.setYear(year);
            budgetedSum.setUser(userService.findById(userId));
            budgetedSum.setSubcategory(categoryRelation.getSubcategory());
            count ++;
        }
        budgetedRepository.saveAll(budgetedSums);
    }
}

