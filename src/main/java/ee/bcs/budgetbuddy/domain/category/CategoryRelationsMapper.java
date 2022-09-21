package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.app.setup.CategoryChangeRequest;
import ee.bcs.budgetbuddy.app.setup.SubcategoryInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryRelationsMapper {


    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "subcategoryId", source = "subcategory.id")
    @Mapping(target = "subcategoryName", source = "subcategory.name")
    SubcategoryInfo CategoryRelationToSubcategoryInfo(CategoryRelation categoryRelation);

    List<SubcategoryInfo> categoryRelationsToSubcategoryInfos(List<CategoryRelation> categoryRelations);


//    @Mapping(target = "category.id", source = "categoryId")
//    CategoryRelation categoryChangeRequestToCategory(CategoryChangeRequest request);
//
//    List<CategoryRelation> categoryChangeRequestToCategories(CategoryChangeRequest request);


}
