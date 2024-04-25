package se2.project.antimonopoly.dao.redis;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RedisDAO {

    void addHash(String key, String hashKey, String value);
    void addList(String key, String value);
    void addSet(String key, String value);
    void addSortedSet(String key, String value, double score);
    void addString(String key, String value);
    void delete(String key);

    String getHash(String key, String hashKey);
    List<String> getList(String key);
    Set<String> getSet(String key);
    Set<String> getSortedSet(String key);
    String getString(String key);


}