package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.domain.Month;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BudgetedMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "month.id", target = "month")
    @Mapping(source = "subcategory.id", target = "subcategoryId")
    @Mapping(source = "subcategory.name", target = "subcategoryName")
    PlanningInfo budgetedSumToPlanningInfo(Budgeted budgetedSum);

    List<PlanningInfo> budgetedSumsToPlanningInfos(List<Budgeted> budgetedSums);


    @Mapping(target = "month", ignore = true)
    Budgeted planningInfoToBudgetedSum(PlanningInfo planningInfo);

    List<Budgeted> planningInfosToBudgetedSums(List<PlanningInfo> planningRequest);

}
