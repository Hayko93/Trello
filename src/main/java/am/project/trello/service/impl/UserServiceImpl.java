package am.project.trello.service.impl;

import am.project.trello.entity.UserEntity;
import am.project.trello.repository.UserRepo;
import am.project.trello.repository.redis.UserRedis;
import am.project.trello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserRedis userRedis;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserRedis userRedis) {
        this.userRepo = userRepo;
        this.userRedis = userRedis;
    }

    @Override
    public Optional<UserEntity> get(int id) {
        Optional<UserEntity> userEntity = this.userRedis.getUser(id + "");
        if (!userEntity.isPresent()) {
            userEntity = this.userRepo.findById(id);
            if (userEntity.isPresent()) {
                this.userRedis.addUser(id + "", userEntity.get(), 100000);
            }
        }
        return this.userRepo.findById(id);
    }

    @Override
    public Optional<UserEntity> get(String email, String password) {
        return this.userRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public void add(UserEntity userEntity) {
        this.userRepo.save(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return this.userRepo.findAll();
    }

    @Override
    public void delete(int id) {
        this.userRepo.deleteById(id);
    }

    @Override
    public boolean existByEmail(String email) {
        return this.userRepo.existsByEmail(email);
    }
}
