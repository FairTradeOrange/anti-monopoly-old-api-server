package se2.project.antimonopoly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * UserJPA is a JPA entity that represents a user.
 * JPA entity represents the data that will be stored in the database
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "APPUSERS")
public class UserJPA extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userID;

    @NotNull
    @Column(name = "user_name", nullable = false, updatable = false, unique = true)
    private String userName;

    @Column(name = "games_played")
    private Integer games_played;

    @ManyToOne
    @JoinColumn(name = "lobby_id")
    private Lobby lobby;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "GAME_USER_MAPPING", joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
   private Set<Game> games = new HashSet<>();

    public UserJPA(Integer userID,String userName, Integer games_played) {
        super(userName);
        this.games_played = games_played;
    }

}
