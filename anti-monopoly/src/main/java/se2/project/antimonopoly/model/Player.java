package se2.project.antimonopoly.model;


import lombok.*;
import se2.project.antimonopoly.entity.User;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Player {

    private int id;
    private String name;
    private int balance;
    private PlayerRole playerRole;
    private int gameID;
    private User user;

    public Player(User user){
           this.user = user;
    }

}
