package se2.project.antimonopoly.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se2.project.antimonopoly.dao.jpa.UserJPADAO;
import se2.project.antimonopoly.dto.UserDTO;
import se2.project.antimonopoly.entity.UserJPA;
import se2.project.antimonopoly.exception.ResourceNotFoundException;
import se2.project.antimonopoly.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for User entity using JPA repository
 */
@Service
public class UserJPAService implements UserService {

    private final UserJPADAO userJPADAO;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserJPAService(UserJPADAO userJPADAO) {
        if (userJPADAO == null) {
            throw new IllegalArgumentException("userJPADAO must not be null");
        }
        this.userJPADAO = userJPADAO;
    }

    /**
     * Test method for creating a user with a given username
     * @param userName String
     * @return UserDTO object
     */
    public UserDTO createUser(String userName) {
        if( userName == null) {
            throw new IllegalArgumentException("userName must not be null");
        }
        UserJPA user = UserMapper.mapToUserJPA(new UserDTO(userName));
        UserJPA savedUser = userJPADAO.save(user);
        return UserMapper.mapUserJPAToUserDTO(savedUser);
    }

    /**
     * Method for creating a user with a given UserDTO object
     * @param userDTO UserDTO object
     * @return UserDTO object
     */
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if( userDTO == null) {
            throw new IllegalArgumentException("userName must not be null");
        }
        //UserJPA user = UserMapper.mapToUserJPA(userDTO);
        //UserJPA savedUser = userJPADAO.save(user);
        //return UserMapper.mapUserJPAToUserDTO(savedUser);
        //UserDTO userDTO = modelMapper.map(userDTO, UserDTO.class);
        UserJPA user = modelMapper.map(userDTO, UserJPA.class);
        userJPADAO.save(user);
        return userDTO;
    }

    /**
     * Method for getting a user by id
     * @param id String
     * @return UserDTO object
     */
    @Override
    public UserDTO getUserById(String id) {
        // Test Long.valueOf(id) --> for postgres
        if(id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        UserJPA user = userJPADAO.findById(Integer.valueOf(id)).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + id + " not found"));
        return UserMapper.mapUserJPAToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserJPA> users = userJPADAO.findAll();
        return users.stream().map(UserMapper::mapUserJPAToUserDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        userJPADAO.findById(Integer.valueOf(id)).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + id + " not found")
        );
        userJPADAO.deleteById(Integer.valueOf(id));
    }
}
