package ee.bcs.budgetbuddy.domain.account;

import ee.bcs.budgetbuddy.domain.category.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public void updateAccountStatus(Integer accountId, Boolean isActive) {
        Account account = accountRepository.getReferenceById(accountId);
        account.setIsActive(isActive);
        accountRepository.save(account);
    }

    public List<AccountInfo> findAllAccountsBy(Integer userId) {
        List<Account> accounts = accountRepository.findAllAccountsBy(userId);
        return accountMapper.accountsToAccountInfos(accounts);
    }

    public void updateAccountBalance(Integer accountId, Float amount) {
        Account account = accountRepository.getReferenceById(accountId);
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }

    public Account findById(Integer accountId) {
        return accountRepository.getReferenceById(accountId);
    }
}

