package ee.bcs.budgetbuddy.app.transaction;

import ee.bcs.budgetbuddy.app.report.Budgeted;
import ee.bcs.budgetbuddy.app.report.BudgetedService;
import ee.bcs.budgetbuddy.app.report.PlanningInfo;
import ee.bcs.budgetbuddy.app.report.PlanningRequest;
import ee.bcs.budgetbuddy.domain.account.AccountInfo;
import ee.bcs.budgetbuddy.domain.account.AccountRequest;
import ee.bcs.budgetbuddy.domain.account.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BudgetService {

    @Resource
    private TransactionService transactionService;

    @Resource
    private AccountService accountService;

    @Resource
    private BudgetedService budgetedService;

    public List<TransactionInfo> findTransactions(Integer accountId) {
        return transactionService.findTransactions(accountId);
    }

    public void addNewAccount(AccountRequest accountRequest) {
        accountService.addNewAccount(accountRequest);
    }

    public void updateAccountName(Integer accountId, String accountName) {
        accountService.updateAccountName(accountId, accountName);
    }

    public void updateAccountStatus(Integer accountId, Boolean isActive) {
        accountService.updateAccountStatus(accountId, isActive);
    }

    public List<TransactionInfo> addNewTransaction(TransactionInfo request) {
        return transactionService.addNewTransaction(request);
    }

    public List<AccountInfo> findAccounts(Integer userId) {
        return accountService.findAllAccountsBy(userId);
    }

    public void updateTransactionStatus(Integer transactionId, Boolean isActive) {
        transactionService.updateTransactionStatus(transactionId, isActive);
    }

    public void saveBudgetedSumsForMonth(List<PlanningInfo> planningInfos) {
        budgetedService.saveBudgetedSumsForMonth(planningInfos);

    }

    public List<PlanningInfo> displayBudgetedSumsForMonth(Integer userId, Integer year, Integer month) {
        return budgetedService.displayBudgetedSumsForMonth(userId, year, month);
    }

    public void fillNewMonthBudgetedDataWithZeros(Integer userId, Integer year, Integer month) {
        budgetedService.fillNewMonthBudgetedDataWithZeros(userId, year, month);
    }
}
