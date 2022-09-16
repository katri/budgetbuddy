package ee.bcs.budgetbuddy.app.transaction;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransactionService {

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private TransactionRepository transactionRepository;

    public List<TransactionInfo> findTransactions(Integer accountId) {
        List<Transaction> transactions = transactionRepository.findTransactionsBy(accountId);
        return transactionMapper.transactionsToTransactionInfos(transactions);
    }

    public List<Transaction> findTransactionsBy(Integer month, Integer subcategoryId) {
        return transactionRepository.findTransactionsBy(month, subcategoryId);
    }
}
