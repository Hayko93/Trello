package am.project.trello.service;

import am.project.trello.entity.TaskEntity;

import java.util.Optional;

public interface TaskService {

    Optional<TaskEntity> get(int id);

    Optional<TaskEntity> get(String title);

    void delete(int id);

    void delete(String title);

    void add(TaskEntity taskEntity);

}
