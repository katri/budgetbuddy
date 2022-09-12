package ee.bcs.budgetbuddy.domain.standardCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StandardCategoryRepository extends JpaRepository<StandardCategory, Integer> {
    @Query("select s from StandardCategory s where s.name = ?1 and s.sequence = ?2 and s.type = ?3 order by s.sequence")
    List<StandardCategory> findByNameAndSequenceAndTypeOrderBySequenceAsc(String name, Integer sequence, String type);

}