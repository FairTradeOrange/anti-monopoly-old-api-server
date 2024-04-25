package se2.project.antimonopoly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se2.project.antimonopoly.dao.redis.RedisDAO;

@Service
public class RedisService {

    //private final RedisTemplate<String, Object> redisTemplate;

    private final RedisDAO redisDAO;

    @Autowired
    public RedisService(RedisDAO redisDAO) { // , RedisTemplate<String, Object> redisTemplate
        if (redisDAO == null) {
            throw new IllegalArgumentException("redisDAO must not be null");
        }
        this.redisDAO = redisDAO;
        //this.redisTemplate = redisTemplate;
    }


    public void set(String key, String hashkey, Object value) {
        redisDAO.addHash(key, hashkey, value.toString());
        //redisTemplate.opsForValue().set(key, value);
    }

    public Object get(String key, String hashkey) {
        //return redisTemplate.opsForValue().get(key);
        return redisDAO.getHash(key, hashkey);
    }
}