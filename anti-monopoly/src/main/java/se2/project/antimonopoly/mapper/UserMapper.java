package se2.project.antimonopoly.mapper;

import se2.project.antimonopoly.dto.UserDTO;
import se2.project.antimonopoly.entity.UserJPA;
import se2.project.antimonopoly.entity.UserRedis;

public class UserMapper {

    public static UserDTO mapUserRedisToUserDTO(UserRedis user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setGames_played(user.getGames_played());
        return userDTO;
    }

    public static UserRedis mapToUserRedis(UserDTO userDTO) {
        UserRedis user = new UserRedis(userDTO.getUserName());
        user.setGames_played(userDTO.getGames_played());
        return user;
    }

    public static UserDTO mapUserJPAToUserDTO(UserJPA user) {
        UserDTO userDTO = new UserDTO(user.getUserID(),user.getUserName(), user.getGames_played());
        return userDTO;
    }

    public static UserJPA mapToUserJPA(UserDTO userDTO) {
        UserJPA user = new UserJPA(userDTO.getUserID(),userDTO.getUserName(), userDTO.getGames_played());
        return user;
    }



}
