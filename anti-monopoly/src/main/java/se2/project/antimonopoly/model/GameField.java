package se2.project.antimonopoly.model;


import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("GameField")
@Data
public class GameField {

    @Id
    private Long id;
    private String name;
    private String description;
    private String type;
    private int price;
    private int rent;
    private int housePrice;
    private int hotelPrice;
    private int numberOfHouses;
    private int numberOfHotels;
    private Player owner;
    private GameGroup group;
    private int position;

}