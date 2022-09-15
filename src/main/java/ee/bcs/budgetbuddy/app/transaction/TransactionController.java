package ee.bcs.budgetbuddy.app.transaction;

import ee.bcs.budgetbuddy.domain.account.AccountRequest;
import ee.bcs.budgetbuddy.domain.account.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Resource
    private AccountService accountService;

    @PostMapping("/add")
    @Operation(summary = "Uue konto lisamine kasutajale",
            description = "Lisab kasutajale uue konto vastavalit sisestatud andmetele")
    public void addNewAccount(@RequestBody AccountRequest accountRequest) {
        accountService.addNewAccount(accountRequest);
    }
}
