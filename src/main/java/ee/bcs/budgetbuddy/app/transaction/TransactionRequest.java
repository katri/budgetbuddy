package ee.bcs.budgetbuddy.app.transaction;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TransactionRequest implements Serializable {
    private Integer userId;
    private Integer senderAccountId;
    private Integer receiverAccountId;
    private LocalDate date;
    private Integer subcategoryId;
    private String description;
    private Integer amount;
    private String type;
    private Boolean isActive;
}
