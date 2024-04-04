package org.example.service.impl;

import org.example.exception.BattleException;
import org.example.exception.BattleShipError;
import org.example.model.Block;
import org.example.model.Player;
import org.example.service.PlayerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerServiceImpl implements PlayerService {

    Set<String> playerSet;
    List<Player> activePlayers;

    @Override
    public void init() {
        playerSet = new HashSet<>();
        activePlayers = new ArrayList<>();
    }

    @Override
    public synchronized void addPlayer(String id) throws BattleException {
        if(playerSet.contains(id)) {
            throw new BattleException(BattleShipError.PLAYER_ALREADY_EXISTS);
        }
        playerSet.add(id);
    }

    @Override
    public void addShip(Block startBlock, int size) throws BattleException {

    }

    @Override
    public void hitNextPlayer() {

    }

    private void checkWinner() {

    }

    @Override
    public void getHit() {

    }
}
