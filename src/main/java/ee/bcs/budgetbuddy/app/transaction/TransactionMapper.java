package ee.bcs.budgetbuddy.app.transaction;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "senderAccount.id", target = "senderAccountId")
    @Mapping(source = "receiverAccount.id", target = "receiverAccountId")
    @Mapping(source = "subcategory.id", target = "subcategoryId")
    TransactionInfo transactionToTransactionInfo(Transaction transaction);
    List<TransactionInfo> transactionsToTransactionInfos(List<Transaction> transactions);


}
