package se2.project.antimonopoly.dto;


import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentRequestDTO implements Serializable {

    private int paymentID;
    private int amount;

    private int gameID;
    private int fromPlayerID;
    private int toPlayerID;

}
