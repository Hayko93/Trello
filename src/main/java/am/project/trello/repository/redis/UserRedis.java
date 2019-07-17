package am.project.trello.repository.redis;

import am.project.trello.entity.UserEntity;
import am.project.trello.util.JsonUtil;
import am.project.trello.util.Validator;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Optional;

@Repository
public class UserRedis {

    private final JedisPool jedisPool;
    private static Logger logger = LoggerFactory.getLogger(UserRedis.class);

    public UserRedis(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public void addUser(String key, UserEntity value, int ttlsecond) {

        try (Jedis redis = this.jedisPool.getResource()) {
            String userJsonValue = JsonUtil.serialize(value);
            redis.set(key, userJsonValue);
            redis.expire(key, ttlsecond);
        } catch (Exception e) {
            logger.error("Error", e);
        }
    }

    public Optional<UserEntity> getUser(String key) {
        try (Jedis redis = this.jedisPool.getResource()) {
            String userInfoJson = redis.get(key);
            if (!Validator.isEmpty(userInfoJson)) {
                return Optional.of(JsonUtil.deserialize(userInfoJson, new TypeReference<UserEntity>() {
                }));
            }
        } catch (Exception e) {
            logger.error("Error", e);
        }
        return Optional.empty();
    }
}
