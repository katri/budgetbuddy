package ee.bcs.budgetbuddy.domain.subcategory;

import ee.bcs.budgetbuddy.app.setup.CategoryInfo;
import ee.bcs.budgetbuddy.app.setup.SubcategoryInfo;
import ee.bcs.budgetbuddy.domain.category.Category;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import ee.bcs.budgetbuddy.domain.standardSubcategory.StandardSubcategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SubcategoryMapper {
    @Mapping(target = "id", ignore = true)
    Subcategory standardSubcategoryToSubcategory(StandardSubcategory standardSubcategory);

    List<Subcategory> standardSubcategoriesToSubcategories(List<StandardSubcategory> standardSubcategories);


}
