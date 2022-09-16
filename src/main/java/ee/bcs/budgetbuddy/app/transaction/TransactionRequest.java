package ee.bcs.budgetbuddy.app.transaction;

import ee.bcs.budgetbuddy.domain.account.Account;
import ee.bcs.budgetbuddy.domain.subcategory.Subcategory;
import ee.bcs.budgetbuddy.domain.user.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
