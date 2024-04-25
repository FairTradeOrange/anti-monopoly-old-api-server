package se2.project.antimonopoly.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se2.project.antimonopoly.service.RedisService;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

@RestController
@RequestMapping("/api/redis")
public class RedisController {

    private RedisService redisService;
    private RedisTemplate<String, String> template;


    @GetMapping("/ping")
    public String ping() {
        return "Ok";
    }

    @PostMapping("/strings")
    @ResponseStatus(HttpStatus.CREATED)
    public Map.Entry<String, String> setString(@RequestBody Map<String, String> kvp) {
        String key = kvp.get("key");
        String value = kvp.get("value");
        template.opsForValue().set(key, value);
        return new SimpleEntry<>(key, value);
    }

    @GetMapping("/strings/{key}")
    public Map.Entry<String, String> getString(@PathVariable("key") String key) {
        String value = template.opsForValue().get(key);

        if (value == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "key not found");
        }
        return new SimpleEntry<String, String>(key, value);
    }


    @GetMapping(path = "/get")
    public String get(@RequestParam(name = "key") String key, @RequestParam(name = "hashkey") String hashkey){
        return (String) redisService.get(key, hashkey);
    }

    //@CacheEvict - Delete from Cache. Use it with DeleteMapping
    //@CachePut - Update a Cache. Use it with PutMapping
}