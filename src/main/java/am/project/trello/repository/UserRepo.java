package am.project.trello.repository;

import am.project.trello.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmailAndPassword(String email, String password);

    Optional<UserEntity> findById(int id);

    boolean existsByEmail(String email);

}
