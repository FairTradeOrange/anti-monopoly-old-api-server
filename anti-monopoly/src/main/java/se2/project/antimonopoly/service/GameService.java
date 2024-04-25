package se2.project.antimonopoly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se2.project.antimonopoly.dao.jpa.GameDAO;
import se2.project.antimonopoly.entity.Game;
import se2.project.antimonopoly.entity.Lobby;
import se2.project.antimonopoly.exception.ResourceNotFoundException;

@Service
public class GameService  {

    private final GameDAO gameDAO;

    @Autowired
    public GameService(GameDAO gameDAO) {
        if (gameDAO == null) {
            throw new IllegalArgumentException("gameDAO must not be null");
        }
        this.gameDAO = gameDAO;
    }

    public Game updateGame(Game game) {
        return gameDAO.save(game);
    }

    public Game createGame(Lobby lobby) {
        return gameDAO.save(new Game(lobby));
    }

    //public List<Game> getAllGames() {
    //    return gameDAO.getAllGames();
    // }

    public Game getGameById(Integer id) {
        return gameDAO.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Game with id " + id + " not found"));
    }

}
