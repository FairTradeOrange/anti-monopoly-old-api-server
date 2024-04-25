package se2.project.antimonopoly.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 * UserDTO is a data transfer object that represents a user.
 * DTO represents the data that will be sent from or to API-client
 * @see <a href="https://martinfowler.com/eaaCatalog/dataTransferObject.html">...</a>
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {

    private Integer userID;

    @NotBlank(message = "Benutzername darf nicht leer sein")
    @Size(min = 3, max = 20, message = "Benutzername muss zwischen 3 und 20 Zeichen lang sein")
    private String userName;
    private int games_played;


    public UserDTO(String userName) {
        this.userName = userName;
    }
}
