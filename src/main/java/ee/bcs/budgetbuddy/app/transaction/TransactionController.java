package ee.bcs.budgetbuddy.app.transaction;

import ee.bcs.budgetbuddy.domain.account.AccountRequest;
import ee.bcs.budgetbuddy.domain.account.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/add")
    @Operation(summary = "Uue konto lisamine kasutajale",
            description = "Lisab kasutajale uue konto vastavalit sisestatud andmetele")
    public void addNewAccount(@RequestBody AccountRequest accountRequest) {
        accountService.addNewAccount(accountRequest);
    }

    @PatchMapping("/account/update")
    @Operation(summary = "Konto nime muutmine",
            description = "")
    public void updateAccountName(Integer accountId, String accountName) {
        accountService.updateAccountName(accountId, accountName);
    }

//    @PostMapping("/account/add")
//    @Operation(summary = "Uue kande lisamine kasutajale",
//            description = "Lisab kasutajale uue kande vastavalit sisestatud andmetele")
//    public void addNewTransaction(@RequestBody TransactionRequest transactionRequest) {
//
//    }
}
