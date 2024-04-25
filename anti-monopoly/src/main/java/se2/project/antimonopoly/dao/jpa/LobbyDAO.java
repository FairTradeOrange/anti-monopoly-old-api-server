package se2.project.antimonopoly.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se2.project.antimonopoly.entity.Lobby;

@Repository
public interface LobbyDAO extends JpaRepository<Lobby, Integer> {

       // Lobby updateLobby(Lobby lobby);

       // Lobby createLobby(User user);

       // List<Lobby> getAllLobbys();

       // Lobby getLobbyByID(Integer id);

}
