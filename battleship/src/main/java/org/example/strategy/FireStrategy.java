package org.example.strategy;

import org.example.exception.BattleException;
import org.example.model.Block;

import java.util.List;

public interface FireStrategy {

    public Block fire(List<Block> opponentBoard) throws BattleException;

}
