package ee.bcs.budgetbuddy.app.transaction;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BudgetService {

   @Resource
   private TransactionService transactionService;

    public List<TransactionInfo> findTransactions(Integer accountId) {
        return transactionService.findTransactions(accountId);
    }
}
