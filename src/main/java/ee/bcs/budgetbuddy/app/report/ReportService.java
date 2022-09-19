package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.app.setup.BudgetInfo;
import ee.bcs.budgetbuddy.app.setup.CategoryInfo;
import ee.bcs.budgetbuddy.app.setup.SubcategoryInfo;
import ee.bcs.budgetbuddy.app.transaction.Transaction;
import ee.bcs.budgetbuddy.app.transaction.TransactionService;
import ee.bcs.budgetbuddy.domain.category.Category;
import ee.bcs.budgetbuddy.domain.category.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReportService {

    @Resource
    private TransactionService transactionService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private BudgetedService budgetedService;

    public Float calculateSubcategorySumInMonth(Integer year, Integer month, Integer subcategoryId) {
        List<Transaction> transactions = transactionService.findActiveTransactionsBy(year, month, subcategoryId);
        return calculateSumof(transactions);
    }

    private static Float calculateSumof(List<Transaction> transactions) {
        Float monthSubcategorySum = 0F;
        for (Transaction transaction : transactions) {
            monthSubcategorySum = monthSubcategorySum + transaction.getAmount();
        }
        return monthSubcategorySum;
    }
    public BudgetInfo getBudgetInfoIncome(Integer year, Integer month, Integer userId) {
        BudgetInfo budgetInfo = categoryService.getIncomeCategoriesSetup(userId);
        mapBudgetInfo(year, month, budgetInfo);
        return budgetInfo;
    }
    public BudgetInfo getBudgetInfoExpense(Integer year, Integer month, Integer userId) {
        BudgetInfo budgetInfo = categoryService.getExpenseCategoriesSetup(userId);
        mapBudgetInfo(year, month, budgetInfo);
        return budgetInfo;
    }

    private void mapBudgetInfo (Integer year, Integer month, BudgetInfo budgetInfo) {
        List<CategoryInfo> categories = budgetInfo.getCategories();
        Float totalSubcategorySum = 0F;
        Float totalBudgetedSum = 0F;
        for (CategoryInfo category : categories) {
            List<SubcategoryInfo> subcategories = category.getSubcategories();

            Float categorySum = 0F;
            Float categoryBudgetedSum = 0F;

            for (SubcategoryInfo subcategory : subcategories) {
                Float subcategorySum = calculateSubcategorySumInMonth(year, month, subcategory.getSubcategoryId());
                subcategory.setSubcategorySum(subcategorySum);
                categorySum = categorySum + subcategorySum;
                totalSubcategorySum = totalSubcategorySum + subcategorySum;

                Float budgetedSum = budgetedService.findBudgetedSumInMonth(year, month, subcategory.getSubcategoryId());
                subcategory.setSubcategoryBudgetedSum(budgetedSum);
                categoryBudgetedSum = categoryBudgetedSum + budgetedSum;
                totalBudgetedSum = totalBudgetedSum + budgetedSum;
            }


            category.setCategorySum(categorySum);
            category.setCategoryBudgetedSum(categoryBudgetedSum);

        }

        budgetInfo.setTotalSum(totalSubcategorySum);
        budgetInfo.setTotalBudgetedSum(totalBudgetedSum);
    }


}
