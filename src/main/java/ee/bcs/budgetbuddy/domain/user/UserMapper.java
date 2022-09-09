package ee.bcs.budgetbuddy.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(constant = "2", target = "role.id")
    User userRequestToUser(UserRequest request);

    @Mapping(source = "id", target = "userId")
    UserResponse userToUserResponse(User user);
}
