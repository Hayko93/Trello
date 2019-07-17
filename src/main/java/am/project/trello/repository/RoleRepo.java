package am.project.trello.repository;

import am.project.trello.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByRole(String role);
}
