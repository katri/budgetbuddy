package ee.bcs.budgetbuddy.app.transaction;

import ee.bcs.budgetbuddy.app.report.PlanningInfo;
import ee.bcs.budgetbuddy.app.report.PlanningRequest;
import ee.bcs.budgetbuddy.domain.account.AccountInfo;
import ee.bcs.budgetbuddy.domain.account.AccountRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {


    @Resource
    private BudgetService budgetService;

    @PostMapping("/account/add")
    @Operation(summary = "Uue konto lisamine kasutajale",
            description = "Lisab kasutajale uue konto vastavalt sisestatud andmetele")
    public void addNewAccount(@RequestBody AccountRequest accountRequest) {
        budgetService.addNewAccount(accountRequest);
    }

    @PatchMapping("/account/update")
    @Operation(summary = "Konto nime muutmine",
            description = "")
    public void updateAccountName(Integer accountId, String accountName) {
        budgetService.updateAccountName(accountId, accountName);
    }

    @PatchMapping("/account/status")
    @Operation(summary = "Konto staatuse muutmine",
            description = "Muudab andmebaasis konto isActive staatuse false-ks")
    public void updateAccountStatus(Integer accountId, Boolean isActive) {
        budgetService.updateAccountStatus(accountId, isActive);
    }

    @GetMapping("/transaction/account/all")
    @Operation(summary = "Kõikide kannete listi kuvamine")
    public List<TransactionInfo> findTransactions(Integer accountId) {
        return budgetService.findTransactions(accountId);
    }

    @PostMapping("/transaction/add")
    @Operation(summary = "Uue kande lisamine kasutajale",
            description = "Lisab kasutajale uue kande vastavalt sisestatud andmetele. Tagastab samasuguse listi, " +
                    "nagu findTransactions teenus, lisandunud on ka uus transaction")
    public List<TransactionInfo> addNewTransaction(@RequestBody TransactionInfo request) {
        return budgetService.addNewTransaction(request);
    }

    @GetMapping("/account/all")
    @Operation(summary = "Kõikide kontode listi kuvamine")
    public List<AccountInfo> findAccounts(Integer userId) {
        return budgetService.findAccounts(userId);
    }

    @PatchMapping("/transaction/status")
    @Operation(summary = "Ühe kande kustutamine (transaction isActive staatuse muutmine)")
    public void updateTransactionStatus(Integer transactionId, Boolean isActive) {
         budgetService.updateTransactionStatus(transactionId, isActive);
    }

    @GetMapping("/planning/month/all")
    @Operation(summary = "Kuu eelarvestatud summade toomine andmebaasist")
    public List<PlanningInfo> displayBudgetedSumsForMonth(Integer userId, Integer year, Integer month) {
        return budgetService.displayBudgetedSumsForMonth(userId, year,month);
    }

    @PatchMapping("/planning/month/update")
    @Operation(summary = "Kuu eelarvestatud summade salvestamine")
    public void saveBudgetedSumsForMonth(@RequestBody List<PlanningInfo> planningInfos) {
        budgetService.saveBudgetedSumsForMonth(planningInfos);
    }
}
