package se2.project.antimonopoly.dto;


import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentResponseDTO implements Serializable {

    private int paymentID;
    private int amount;

    private PlayerDTO fromPlayer;
    private PlayerDTO toPlayer;

    private int toPlayerID;
    private int gameID;



}
