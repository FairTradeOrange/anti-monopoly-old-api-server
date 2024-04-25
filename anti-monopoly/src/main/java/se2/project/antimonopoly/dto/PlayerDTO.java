package se2.project.antimonopoly.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import se2.project.antimonopoly.model.PlayerRole;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDTO implements Serializable {

    private int id;

    @NotBlank(message = "Benutzername darf nicht leer sein")
    @Size(min = 3, max = 20, message = "Benutzername muss zwischen 3 und 20 Zeichen lang sein")
    private String name;

    private int balance;

    private PlayerRole playerRole;

    @NotBlank(message = "GameID darf nicht leer sein")
    private int gameID;
}
