package ee.bcs.budgetbuddy.domain.account;

import org.mapstruct.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {


    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "accountType.id", source = "accountTypeId")
    Account accountRequestToAccount(AccountRequest accountRequest);

    Account accountInfoToAccount(AccountInfo accountInfo);

    @Mapping(target = "accountName", source = "name")
    @Mapping(target = "accountId", source = "id")
    AccountInfo accountToAccountInfo(Account account);

   List<AccountInfo> accountsToAccountInfos(List<Account> accounts);
}
