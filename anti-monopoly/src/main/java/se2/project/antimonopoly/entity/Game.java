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
 * Game entity
 * @author ottzoeke
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GAMES")
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer gameID;

    @Column(name = "game_name")
    private String name;

    @Column(name = "game_status")
    private String status;

    /**
     * One Game must have one Lobby.
     */
    @OneToOne(optional = false) //     must specify a lobby before creating a game
    @JoinColumn(name = "lobby_id")
    private Lobby lobby;

    /**
     * One Game can have multiple Users.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(
            name = "GAME_USER_MAPPING",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserJPA> users = new HashSet<>();



    public Game(Lobby lobby) {
        this.lobby = lobby;
    }

    public Game(UserJPA user) {
        this.name = user.getUserName() + "'s game";
    }

    // Idee für Zug
    //public void nextPlayer() {
    //    currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
    //}

    //public Player getPlayer() {
    //    return playerList.get(currentPlayerIndex);
    //}

}