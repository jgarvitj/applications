package org.example.strategy.impl;

import org.example.exception.BattleException;
import org.example.exception.BattleShipError;
import org.example.model.Block;
import org.example.strategy.FireStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomFire implements FireStrategy {
    @Override
    public Block fire(List<Block> opponentBoard) throws BattleException {
        if(Objects.isNull(opponentBoard) || opponentBoard.isEmpty()) {
            throw new BattleException(BattleShipError.NO_BLOCKS_TO_FIRE);
        }
        List<Block> eligibleBlocks = new ArrayList<>();
        for(Block block : opponentBoard) {
            if(block.isHit()) {
                eligibleBlocks.add(block);
            }
        }
        if(eligibleBlocks.isEmpty()) {
            throw new BattleException(BattleShipError.NO_BLOCKS_TO_FIRE);
        }
        Random random = new Random();
        return eligibleBlocks.get(random.nextInt(eligibleBlocks.size()));
    }
}
