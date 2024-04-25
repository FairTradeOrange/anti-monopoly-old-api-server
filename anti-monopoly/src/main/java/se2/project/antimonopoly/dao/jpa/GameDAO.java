package se2.project.antimonopoly.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se2.project.antimonopoly.entity.Game;

@Repository
public interface GameDAO extends JpaRepository<Game, Integer> {

   // Game createGame(Game game);

    //List<Game> getAllGames();

   // Game getGameById(Integer id);
}
