package se2.project.antimonopoly.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RedisHash("users")
public class UserRedis extends User implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userID;

    private String userName;

    private Integer games_played;

    public UserRedis(String userName) {
        super(userName);
    }

    // ACHTUNG -> org.springframework.data.annotation.Id !

}
