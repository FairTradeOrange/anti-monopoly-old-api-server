package se2.project.antimonopoly.dto;


import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LobbyDTO {

    private int lobbyID;
    private String lobbyCode;
    private List<PlayerDTO> playerList;
    private int numberOfPlayers;
    private PlayerDTO host;

}
