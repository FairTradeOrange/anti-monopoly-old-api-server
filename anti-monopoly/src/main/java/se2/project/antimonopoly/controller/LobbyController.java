package se2.project.antimonopoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import se2.project.antimonopoly.service.LobbyService;

@Controller
@RequestMapping("/api/jpa")
public class LobbyController {

    private final LobbyService lobbyService;

    // Todo : PlayerService ?
    // Todo: GameStateService ?

    @Autowired
    public LobbyController(LobbyService lobbyService) {
        if (lobbyService == null) {
            throw new IllegalArgumentException("lobbyService must not be null");
        }
        this.lobbyService = lobbyService;
    }

    @MessageMapping("/lobby/join")
    @SendTo("/topic/lobby")
    public String joinLobby(String playerName) {
        // Spieler zur Lobby hinzufügen
        return playerName + " ist der Lobby beigetreten";
    }

    // Weitere Methoden für das Verlassen der Lobby, das Aktualisieren der Spielerliste usw.
}