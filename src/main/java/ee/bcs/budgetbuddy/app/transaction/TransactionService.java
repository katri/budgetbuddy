package ee.bcs.budgetbuddy.app.transaction;

import ee.bcs.budgetbuddy.domain.account.AccountService;
import ee.bcs.budgetbuddy.domain.subcategory.SubcategoryService;
import ee.bcs.budgetbuddy.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionService {

    @Resource
    private AccountService accountService;

    @Resource
    private UserService userService;

    @Resource
    private SubcategoryService subcategoryService;

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

    @Transactional
    public List<TransactionInfo> addNewTransaction(TransactionInfo request) {
        Boolean receiverAccountExists = true;
        if (request.getReceiverAccountId() == null) {
            receiverAccountExists = false;
        }
        Transaction transaction = saveTransactionToDatabase(request, receiverAccountExists);
        updateAccountBalances(transaction, receiverAccountExists);
        return findTransactions(transaction.getSenderAccount().getId());
    }

    private Transaction saveTransactionToDatabase(TransactionInfo request, Boolean receiverAccountExists) {
        Transaction transaction = transactionMapper.transactionAddRequestToTransaction(request);
        transaction.setUser(userService.findById(request.getUserId()));
        transaction.setSenderAccount(accountService.findById(request.getSenderAccountId()));
        if (receiverAccountExists) {
            transaction.setReceiverAccount(accountService.findById(request.getReceiverAccountId()));
        }
        transaction.setSubcategory(subcategoryService.findById(request.getSubcategoryId()));
        transactionRepository.save(transaction);
        return transaction;
    }

    @Transactional
    public void updateAccountBalances(Transaction transaction, Boolean senderAccountExists) {
        accountService.updateAccountBalance(transaction.getSenderAccount().getId(), transaction.getAmount());
        if (senderAccountExists) {
            accountService.updateAccountBalance(transaction.getReceiverAccount().getId(), -1 * transaction.getAmount());
        }
    }
}
