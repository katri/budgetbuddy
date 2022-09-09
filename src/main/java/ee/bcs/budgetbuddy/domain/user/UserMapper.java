package ee.bcs.budgetbuddy.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")

public interface UserMapper {
    User userRequestToUser(UserRequest request);

    UserResponse userToUserResponse(User user);
}
