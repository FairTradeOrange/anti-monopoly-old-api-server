package se2.project.antimonopoly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se2.project.antimonopoly.dao.jpa.LobbyDAO;
import se2.project.antimonopoly.entity.Lobby;
import se2.project.antimonopoly.entity.UserRedis;

@Service
public class LobbyService {

    //private final RedisTemplate<String, Object> redisTemplate;

    private final LobbyDAO lobbydao;

    @Autowired
    public LobbyService(LobbyDAO lobbyDAO) { // , RedisTemplate<String, Object> redisTemplate
        if (lobbyDAO == null) {
            throw new IllegalArgumentException("lobbyDAO must not be null");
        }
        this.lobbydao = lobbyDAO;
        //this.redisTemplate = redisTemplate;
    }


    public void addPlayerToLobby(UserRedis user, Lobby lobby) {
        // Spieler zur Lobby hinzufügen
    }

    public void removePlayerFromLobby(UserRedis user, Lobby lobby) {
        // Spieler aus der Lobby entfernen

    }

    //@EventListener -> Todo: read about Events?
    public boolean checkIfGameCanStart( ) {
        // Überprüfen, ob die Bedingungen zum Starten des Spiels erfüllt sind
        return false;
    }


    // Weitere Methoden...
}
