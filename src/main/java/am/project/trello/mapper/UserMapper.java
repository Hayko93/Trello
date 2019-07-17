package am.project.trello.mapper;

import am.project.trello.dto.UserDto;
import am.project.trello.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserEntity, UserDto> {
}
