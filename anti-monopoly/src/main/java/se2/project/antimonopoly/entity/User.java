package se2.project.antimonopoly.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public abstract class User {

    private String userID;

    private String userName;

    private Integer games_played;

    public User(String userName){
        this.userName = userName;
        this.games_played = 0;
    }
}
