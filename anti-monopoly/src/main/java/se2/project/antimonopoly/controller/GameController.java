package se2.project.antimonopoly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se2.project.antimonopoly.entity.Game;
import se2.project.antimonopoly.entity.GameMove;
import se2.project.antimonopoly.entity.GameState;
import se2.project.antimonopoly.entity.Lobby;
import se2.project.antimonopoly.service.GameService;
import se2.project.antimonopoly.service.UserJPAService;

/**
 * WebSocket Controller for handling game related requests
 */
@Slf4j
@RestController
@RequestMapping("/api/jpa")
public class GameController {

    private final GameService gameService;

    private final UserJPAService userJPAService;

    // Todo : PlayerService ?
    // Todo: GameStateService ?

    @Autowired
    public GameController(GameService gameService, UserJPAService userJPAService) {
        if (gameService == null) {
            throw new IllegalArgumentException("gameService must not be null");
        } else if ( userJPAService == null) {
            throw new IllegalArgumentException("userJPAService must not be null");
        }
        this.gameService = gameService;
        this.userJPAService = userJPAService;
    }

    /**
     * TODO: Implement this method to handle game moves
     * @param gameMove : the game move to be processed by the server
     * @return the updated game state
     * @throws Exception
     */
    @MessageMapping("/game/move")
    @SendTo("/topic/gamestate")
    public GameState gameState(GameMove gameMove) throws Exception {
        return null;
    }

    /**
     * Create a new game with the given lobby
     * @param lobby : the lobby to create the game from
     * @return the created game
     */
    @PostMapping("/game/create")
    public ResponseEntity<Game> create(@RequestBody Lobby lobby) {
        log.info("create game request: {}", lobby );
        Game game = gameService.createGame(lobby);
        return ResponseEntity.ok(game);
    }



    @PostMapping("/game/update")
    public Game createGame(@RequestBody Game game) {
        return gameService.updateGame(game);
    }

    //@GetMapping("games")
    //public List<Game> getAllGames() {
    //    return gameService.getAllGames();
    //}

}