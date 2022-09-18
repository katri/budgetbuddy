package ee.bcs.budgetbuddy.app.transaction;

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
            description = "Lisab kasutajale uue konto vastavalit sisestatud andmetele")
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

//    @PostMapping("/transaction/add")
//    @Operation(summary = "Uue kande lisamine kasutajale",
//            description = "Lisab kasutajale uue kande vastavalit sisestatud andmetele")
//    public List<TransactionInfo> addNewTransaction(@RequestBody TransactionInfo transactionRequest) {
//    }

    @GetMapping("transaction/all")
    @Operation(summary = "Kõikide kannete listi kuvamine")
    public List<TransactionInfo> findTransactions(Integer accountId) {
        return budgetService.findTransactions(accountId);
    }



}
