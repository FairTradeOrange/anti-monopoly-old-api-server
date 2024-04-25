package se2.project.antimonopoly.entity;

import lombok.Data;

@Data
public class TurnData {
    public int Turn = 0;
    public GameState NextTurnState;    // What will the turn be for the view?
}