package ee.bcs.budgetbuddy.app.transaction;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "id", target = "transactionId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "senderAccount.id", target = "senderAccountId")
    @Mapping(source = "senderAccount.name", target = "senderAccountName")
    @Mapping(source = "receiverAccount.id", target = "receiverAccountId")
    @Mapping(source = "receiverAccount.name", target = "receiverAccountName")
    @Mapping(source = "subcategory.id", target = "subcategoryId")
    @Mapping(source = "subcategory.name", target = "subcategoryName")
    TransactionInfo transactionToTransactionInfo(Transaction transaction);

    List<TransactionInfo> transactionsToTransactionInfos(List<Transaction> transactions);


    @Mapping(target = "receiverAccount", ignore = true)
    Transaction transactionAddRequestToTransaction(TransactionInfo request);
}
