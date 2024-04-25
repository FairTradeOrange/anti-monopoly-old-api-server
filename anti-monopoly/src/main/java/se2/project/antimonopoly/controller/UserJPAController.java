package se2.project.antimonopoly.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se2.project.antimonopoly.dto.UserDTO;
import se2.project.antimonopoly.service.UserJPAService;

import java.util.List;


/**
 * This class is a controller for the User JPA service.
 * It handles RESTful API endpoints for the User JPA service.
 *
 *
 * ->  While @RequestParams extract values from the query string, @PathVariables extract values from the URI path:
 * @see <a href="https://www.baeldung.com/spring-requestparam-vs-pathvariable">Link</a>
 * PathVariables : /api/jpa/user/1
 * RequestParam  : /api/jpa/users?id=1
 */
@RestController
@RequestMapping("/api/jpa")
public class UserJPAController {

    @Autowired
    private UserJPAService userJPAService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(@RequestParam(required = false) String name) {
        List<UserDTO> users = userJPAService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Get a user by id.
     * @param id  : id of the user
     * @return : UserDTO
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        if (id == null) {
            ResponseEntity.badRequest().body("id must not be null");
            throw new IllegalArgumentException("id must not be null");
        }
        UserDTO user = userJPAService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        if (user == null) {
            ResponseEntity.badRequest().body("user must not be null");
            throw new IllegalArgumentException("user must not be null");
        }
        UserDTO createdUser = userJPAService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

}
