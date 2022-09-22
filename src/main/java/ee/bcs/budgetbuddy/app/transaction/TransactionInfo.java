package ee.bcs.budgetbuddy.app.transaction;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TransactionInfo implements Serializable {
    private Integer transactionId;
    private Integer userId;
    private Integer senderAccountId;
    private String senderAccountName;
    private Integer receiverAccountId;
    private String receiverAccountName;
    private LocalDate date;
    private Integer subcategoryId;
    private String subcategoryName;
    private String description;
    private Float amount;
    private String type;
    private Boolean isActive;
}
