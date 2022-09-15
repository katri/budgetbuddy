package ee.bcs.budgetbuddy.domain.account;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import javax.validation.constraints.NotNull;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {


    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "accountType.id", source = "accountTypeId")
    Account accountRequestToAccount(AccountRequest accountRequest);

}
