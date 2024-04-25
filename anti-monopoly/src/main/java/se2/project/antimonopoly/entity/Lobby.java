package se2.project.antimonopoly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Lobby is a JPA entity that represents a lobby.
 * One User can create a lobby and invite other users to join the lobby. ( key / pin )
 * If all Players are ready, the lobby starts the game.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LOBBIES")
public class Lobby implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lobby_id")
    private long lobbyID;


    /**
     * One Lobby can have multiple Users.
     */
    @OneToMany(
            mappedBy = "lobby"
    )
    private Set<UserJPA> users = new HashSet<>();


    /**
     * One Lobby must have one Game.
     */
    @OneToOne(
            mappedBy = "lobby"
    )
    private Game game;

}
