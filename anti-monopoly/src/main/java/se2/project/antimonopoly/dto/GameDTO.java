package se2.project.antimonopoly.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameDTO implements Serializable {

    private int gameID;
    private String gameCode;
    private List<PlayerDTO> playerList;

}
