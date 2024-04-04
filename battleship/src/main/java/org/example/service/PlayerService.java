package org.example.service;

import org.example.exception.BattleException;
import org.example.model.Block;

public interface PlayerService {

    public void init();
    public void addPlayer(String id) throws BattleException;
    public void addShip(Block startBlock, int size) throws BattleException;
    public void hitNextPlayer();
    public void getHit();

}
