package am.project.trello.service;

import am.project.trello.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserEntity> get(int id);

    Optional<UserEntity> get(String email, String password);

    void add(UserEntity userEntity);

    List<UserEntity> getAll();

    void delete(int id);

    boolean existByEmail(String email);

}
