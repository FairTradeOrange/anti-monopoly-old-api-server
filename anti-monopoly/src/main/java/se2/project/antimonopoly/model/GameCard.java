package se2.project.antimonopoly.model;


import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Spielkarte")
@Data
public class GameCard {

    @Id
    private Long id;
    private String name;
    private String description;

}
