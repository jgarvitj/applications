package SnakesAndLadders.service.impl;

import SnakesAndLadders.models.Player;
import SnakesAndLadders.models.PlayerLL;
import SnakesAndLadders.service.PlayerHandler;

import java.util.List;

public class PlayerHandlerRR implements PlayerHandler {

    private PlayerLL playerLL;
    private int size;

    public PlayerHandlerRR(Player p) {
        this.playerLL = PlayerLL.init(p);
    }

    @Override
    public Player nextPlayer(Player currentPlayer) {
        if(!currentPlayer.isActive()) {
            //inactive player
            return null;
        }
        this.playerLL.setCurr(this.playerLL.getNext());
        return this.playerLL.getCurr();
    }

    @Override
    public Player addPlayer(Player player) {
        Player currNext = this.playerLL.getNext();
        this.playerLL.setNext(player);
        this.playerLL.setCurr(this.playerLL.getNext());
        this.playerLL.setNext(currNext);
        return this.playerLL.getCurr();
    }

    @Override
    public PlayerLL getItr() {
        return this.playerLL;
    }
}
