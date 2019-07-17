package am.project.trello.mapper;

import am.project.trello.dto.TaskDto;
import am.project.trello.entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<TaskEntity, TaskDto> {
}
