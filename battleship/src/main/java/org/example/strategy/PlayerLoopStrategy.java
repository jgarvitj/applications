package org.example.strategy;

import org.example.exception.BattleException;
import org.example.model.Player;

import java.util.List;

public interface PlayerLoopStrategy {
    public Player findNextPlayer(List<Player> players, Player currPlayer) throws BattleException;
}
