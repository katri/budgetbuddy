package ee.bcs.budgetbuddy.app.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("select t from Transaction t where t.senderAccount.id = ?1 order by t.date, t.type DESC, t.amount DESC")
    List<Transaction> findTransactionsBy(Integer accountId);
}