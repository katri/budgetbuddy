package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.app.transaction.Transaction;
import ee.bcs.budgetbuddy.app.transaction.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReportService {

    @Resource
    private TransactionService transactionService;

    public Float calculateSubcategorySumInMonth(Integer month, Integer subcategoryId) {
        List<Transaction> transactions = transactionService.findTransactionsBy(month, subcategoryId);
        Float monthSubcategorySum = 0F;
        for (Transaction transaction : transactions) {
            monthSubcategorySum = monthSubcategorySum + transaction.getAmount();
        }
        return monthSubcategorySum;
    }
}
