package ee.bcs.budgetbuddy.app.report;

import ee.bcs.budgetbuddy.domain.category.CategoryRelation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BudgetedMapper {

    List<PlanningInfo> budgetedSumsToPlanningInfos(List<Budgeted> budgetedSums);


    @Mapping(target = "month", ignore = true)
    Budgeted planningInfoToBudgetedSum(PlanningInfo planningInfo);

    List<Budgeted> planningInfosToBudgetedSums(List<PlanningInfo> planningRequest);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "amount", constant = "0F")
    Budgeted categoryRelationsToBudgetedSums(CategoryRelation categoryRelation);

    List<Budgeted> categoryRelationsToBudgetedSums(List<CategoryRelation> categoryRelations);
}
