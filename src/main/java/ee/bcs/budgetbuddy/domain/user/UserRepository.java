package ee.bcs.budgetbuddy.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select (count(u) > 0) from User u where upper(u.username) = upper(?1)")
    boolean existsByUsername(String username);


    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    User findUserBy(String username, String password);
}