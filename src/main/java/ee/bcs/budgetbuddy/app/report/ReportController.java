package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.app.transaction.TransactionInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @GetMapping("")
    @Operation(summary = "Ühe kuu lõikes valitud subkategooria tulude või kulude summa leidmine")
    public Float calculateSubcategorySumInMonth(Integer month, Integer subcategoryId) {
            return reportService.calculateSubcategorySumInMonth(month, subcategoryId);
    }



}
