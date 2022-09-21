package ee.bcs.budgetbuddy.domain.user.month;

import ee.bcs.budgetbuddy.domain.Month;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MonthService {
    @Resource
    private MonthRepository monthRepository;

    public Month findById(Integer month) {
        return monthRepository.findById(month).get();
    }
}
