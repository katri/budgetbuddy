package ee.bcs.budgetbuddy.app.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("select t from Transaction t " +
            "where t.senderAccount.id = ?1 " +
            "or t.receiverAccount.id = ?1 " +
            "and t.isActive = true order by t.date, t.type DESC, t.amount DESC")
    List<Transaction> findTransactionsBy(Integer accountId);

    @Query("select t from Transaction t where EXTRACT(MONTH from t.date) =?1 " +
            "AND t.subcategory.id =?2")
    List<Transaction> findTransactionsBy(Integer month, Integer subcategoryId);
}