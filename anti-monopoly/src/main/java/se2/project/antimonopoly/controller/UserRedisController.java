package se2.project.antimonopoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se2.project.antimonopoly.entity.UserRedis;
import se2.project.antimonopoly.service.UserRedisService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/redis/")
public class UserRedisController {

    @Autowired
    private UserRedisService userRedisService;

    public UserRedisController(UserRedisService userRedisService) {
        this.userRedisService = userRedisService;
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<UserRedis> getUserById(@PathVariable("id") String id) {
        Optional<UserRedis> userRedisData = userRedisService.findById(id);

        if (userRedisData.isPresent()) {
            return new ResponseEntity<>(userRedisData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/users/create")
    @ResponseBody
    public String create(String name) {
        UserRedis user = null;
        try {
            user = new UserRedis(name);
            userRedisService.saveUser(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User successfully created! (id = " + user.getUserID() + ")";
    }

    /**
     * This method returns all users in the database.
     * @return List of all users in the database
     */
    @GetMapping("/users")
    public List<UserRedis> getAllUsers() {
        return userRedisService.getAll();
    }

}
