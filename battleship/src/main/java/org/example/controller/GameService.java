package org.example.controller;

import org.example.exception.BattleException;
import org.example.exception.BattleShipError;
import org.example.model.Block;
import org.example.service.BoardService;
import org.example.service.PlayerService;

import java.util.List;

public class GameService {

    private BoardService boardService;
    private PlayerService playerService;

    public GameService(BoardService boardService, PlayerService playerService) {
        this.boardService = boardService;
        this.playerService = playerService;
    }

    public void init(int size, int playerCount) throws BattleException {
        if(size%playerCount != 0) {
            throw new BattleException(BattleShipError.INCORRECT_BOARD_SIZE);
        }
        initBoard(size, playerCount);
        addPlayers(size, playerCount);

    }

    private void addPlayers(int size, int playerCount) {
    }

    public void init(int size) throws BattleException {
        init(size, 2);
    }
    private void initBoard(int size, int playerCount) {}

    public void addShips(int size, List<Block> startBlocks) {

    }
    public void playGame() {};
}
