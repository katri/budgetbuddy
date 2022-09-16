package ee.bcs.budgetbuddy.domain.category;

import ee.bcs.budgetbuddy.app.setup.CategoryChangeRequest;
import ee.bcs.budgetbuddy.app.setup.CategoryInfo;
import ee.bcs.budgetbuddy.domain.standardCategory.StandardCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    Category standardCategoryToCategory(StandardCategory standardCategory);

    List<Category> standardCategoriesToCategories(List<StandardCategory> standardCategories);

    @Mapping(target = "categoryId", source = "id")
    @Mapping(target = "categoryName", source = "name")
    CategoryInfo CategoryToCategoryInfo(Category category);

    List<CategoryInfo> categoriesToCategoryInfos(List<Category> categories);

    @Mapping(target = "id", source = "categoryId")
    @Mapping(target = "name", source = "categoryName")
    Category categoryChangeRequestToCategory(CategoryChangeRequest request);

}
