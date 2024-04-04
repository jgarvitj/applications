package org.example.strategy.impl;

import org.example.exception.BattleException;
import org.example.exception.BattleShipError;
import org.example.model.Player;
import org.example.strategy.PlayerLoopStrategy;

import java.util.List;
import java.util.Objects;

public class RoundRobinPlayerLoopStrategy implements PlayerLoopStrategy {
    @Override
    public Player findNextPlayer(List<Player> activePlayer, Player currPlayer) throws BattleException {
        if(Objects.isNull(currPlayer) || Objects.isNull(activePlayer) || activePlayer.isEmpty() || activePlayer.size() < 2) {
            throw  new BattleException(BattleShipError.UNABLE_TO_SELECT_NEXT_PLAYER);
        }
        for(int i = 0; i < activePlayer.size(); i++) {
            if(currPlayer.getId().equals(currPlayer.getId())) {
                if(i == activePlayer.size() - 1) {
                    return activePlayer.get(0);
                } else {
                    return activePlayer.get(i+1);
                }
            }
        }
        throw new BattleException(BattleShipError.PLAYER_NOT_FOUND);
    }
}
