package SnakesAndLadders.service.impl;

import SnakesAndLadders.models.Block;
import SnakesAndLadders.models.Player;
import SnakesAndLadders.models.PlayerLL;
import SnakesAndLadders.service.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static SnakesAndLadders.util.DiceService.diceRoll;

public class SnakeAndLadderGame implements Game {
    private Block[] board;

    private PlayerHandlerRR playerHandlerRR;
    //we can make the list of players as a hashmap for custom id


    private SnakeAndLadderGame() {
        initBoard(100);
        Player player = new Player();
        this.playerHandlerRR = new PlayerHandlerRR(player);
    }

    @Override
    public void initBoard(int size) {
        this.board = new Block[size];
        for(int i = 0; i < size; i++) {
            this.board[i] = new Block();
        }
    }


    public static SnakeAndLadderGame initWithDefaultPlayer() {
        return new SnakeAndLadderGame();
    }

    public void addSnake(int i, int val) {
        this.addSkip(i, -1*Math.abs(val));
    }

    public void addLadder(int i, int val) {
        this.addSkip(i, Math.abs(val));
    }

    public void play() {

        PlayerLL itr = this.playerHandlerRR.getItr();

        while(itr.getCurr().getLocation() < this.board.length) {
            int roll = diceRoll();
            int nextIndex = itr.getCurr().getLocation() + roll;
            if(nextIndex > 100) {
                itr.setCurr(itr.getNext());
                continue;
            }
            if(nextIndex == 100) {
                System.out.println("Player " + itr.getCurr().getId() + " won");
                break;
            }
            int index = checkSnakesAndLadders(itr.getCurr().getLocation() + roll);

            itr.getCurr().setLocation(index);
            System.out.println("Player " + itr.getCurr().getId() + " to " + index);

            itr.setCurr(itr.getNext());

        }
    }

    private int checkSnakesAndLadders(int index) {
        if(board[index].getValue() != 1) {
            if(board[index].getValue() > 0) {
                System.out.println("Ladder of " + board[index].getValue());
            }  else {
                System.out.println("Snake of " + board[index].getValue());
            }
            return index + board[index].getValue();
        }
        return index;
    }

    private void addSkip(int i, int val) {
        if(this.board[i].getValue() != 1 && i + val < this.board.length && i + val >= 0) {
            return;
        } else {
            this.board[i].setValue(val);
        }
    }

    @Override
    public void addPlayer(int id) {
        Player player = new Player(id);
        this.playerHandlerRR.addPlayer(player);
        //log player id is index of player
    }



    @Override
    public void inActivatePlayer(int id) {
//        if(this.players.size() > id) {
//            this.players.get(id).inAvtivatePlayer();
//        } else {
//            System.out.println("Player not found " +  id);
//        }
    }
}
