package se2.project.antimonopoly.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import se2.project.antimonopoly.dao.redis.RedisDAO;

import java.util.List;
import java.util.Set;

@Repository
public class RedisRepository implements RedisDAO {

    private final RedisTemplate<String, Object> redisTemplate;

    // TODO: Fix this
    private HashOperations hashOperations;
    //private HashOperations<String, Integer, UserRedis> hashOperations;

    @Autowired
    public RedisRepository(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void addHash(String key, String hashKey, String value) {

    }

    @Override
    public void addList(String key, String value) {

    }

    @Override
    public void addSet(String key, String value) {

    }

    @Override
    public void addSortedSet(String key, String value, double score) {

    }

    @Override
    public void addString(String key, String value) {
        hashOperations.put("strings",key,value);
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public String getHash(String key, String hashKey) {
        return "";
    }

    @Override
    public List<String> getList(String key) {
        return List.of();
    }

    @Override
    public Set<String> getSet(String key) {
        return Set.of();
    }

    @Override
    public Set<String> getSortedSet(String key) {
        return Set.of();
    }

    @Override
    public String getString(String key) {
        return "";
    }
}