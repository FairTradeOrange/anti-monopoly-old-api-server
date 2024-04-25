package se2.project.antimonopoly.service;

import se2.project.antimonopoly.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(String id);

    List<UserDTO> getAllUsers();

    void deleteUser(String id);

}
