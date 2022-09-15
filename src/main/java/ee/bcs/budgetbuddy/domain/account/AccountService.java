package ee.bcs.budgetbuddy.domain.account;

import ee.bcs.budgetbuddy.domain.category.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountRepository accountRepository;

    public void addNewAccount(AccountRequest accountRequest) {
        Account account = accountMapper.accountRequestToAccount(accountRequest);
        accountRepository.save(account);
    }

    public void updateAccountName(Integer accountId, String accountName) {
        Account account = accountRepository.getReferenceById(accountId);
        account.setName(accountName);
        accountRepository.save(account);

    }
}
