package se2.project.antimonopoly.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import se2.project.antimonopoly.dao.redis.UserRedisDAO;
import se2.project.antimonopoly.dto.UserDTO;
import se2.project.antimonopoly.entity.UserRedis;
import se2.project.antimonopoly.exception.ResourceNotFoundException;
import se2.project.antimonopoly.mapper.UserMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserRedisService implements UserService{

    private final UserRedisDAO userRedisDAO;

    private RedisTemplate<String, UserRedis> redisTemplate;

    private HashOperations<String,String,UserRedis> hashOperations;

    private static final String TABLE_NAME = "users";


    @Autowired
    public UserRedisService(UserRedisDAO userRedisDAO, RedisTemplate<String, UserRedis> redisTemplate) {
        if (userRedisDAO == null) {
            throw new IllegalArgumentException("userRedisDAO must not be null");
        }
        this.userRedisDAO = userRedisDAO;
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void saveUser(UserRedis user) {
        userRedisDAO.save(user);
    }

    @Cacheable("users")
    public Optional<UserRedis> findById(String id) {
        return userRedisDAO.findById(id);
    }

    public UserRedis getUserById(long id) {
        //return hashOperations.get(TABLE_NAME, id);
        //return getUserRepository().findById(id);
        return userRedisDAO.findById(String.valueOf(id)).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + id + " not found")
        );
    }

    public List<UserRedis> getAll() {
        //return hashOperations.values(TABLE_NAME);
        return userRedisDAO.findAll();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserRedis user = UserMapper.mapToUserRedis(userDTO);
        UserRedis savedUser = userRedisDAO.save(user);
        return UserMapper.mapUserRedisToUserDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(String id) {
        // Test Long.valueOf(id) --> for postgres
        UserRedis user = userRedisDAO.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + id + " not found")
        );
        return UserMapper.mapUserRedisToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserRedis> users = userRedisDAO.findAll();
        return users.stream().map(UserMapper::mapUserRedisToUserDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(String id) {
        userRedisDAO.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + id + " not found")
        );
        userRedisDAO.deleteById(id);
    }
}