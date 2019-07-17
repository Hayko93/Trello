package am.project.trello.repository;

import am.project.trello.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity, Integer> {

    Optional<TaskEntity> findByTitle(String title);

    Optional<TaskEntity> findById(int id);


}
