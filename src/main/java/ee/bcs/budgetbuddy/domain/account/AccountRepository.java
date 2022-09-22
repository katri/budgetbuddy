package ee.bcs.budgetbuddy.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("select a from Account a where a.user.id = ?1 and a.isActive = true order by a.name ASC")
    List<Account> findAllAccountsBy(Integer id);


}