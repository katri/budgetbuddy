package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.app.setup.BudgetInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @GetMapping("/subcategory/sum")
    @Operation(summary = "Ühe kuu lõikes valitud subkategooria tulude või kulude summa leidmine")
    public Float calculateSubcategorySumInMonth(Integer year, Integer month, Integer subcategoryId) {
            return reportService.calculateSubcategorySumInMonth(year, month, subcategoryId);
    }

    @GetMapping("/budget/income")
    @Operation(summary = "Tulude raport - kuu / aasta valik. Raport töötab: year 2022, month 8 ja user 1")
    public BudgetInfo getBudgetInfoIncome(Integer year, Integer month, Integer userId) {
        return reportService.getBudgetInfoIncome(year, month, userId);
    }
    @GetMapping("/budget/expense")
    @Operation(summary = "Kulude raport - kuu / aasta valik..Raport töötab: year 2022, month 8 ja user 1 ")
    public BudgetInfo getBudgetInfoExpense(Integer year, Integer month, Integer userId) {
            return reportService.getBudgetInfoExpense(year, month, userId);
    }








}
