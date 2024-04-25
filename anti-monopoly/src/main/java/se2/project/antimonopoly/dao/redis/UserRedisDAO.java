package se2.project.antimonopoly.dao.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se2.project.antimonopoly.entity.UserRedis;

import java.util.List;

/**
 * This interface is used to interact with the Redis database for the User entity.
 * Data access objects (DAO) are used to isolate the application layer from the persistence layer.
 */
@Repository
public interface UserRedisDAO extends CrudRepository<UserRedis,String> {
    List<UserRedis> findByUserName(String userName);
    List<UserRedis> findAll();
}
