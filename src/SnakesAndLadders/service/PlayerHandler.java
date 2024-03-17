package SnakesAndLadders.service;

import SnakesAndLadders.models.Player;
import SnakesAndLadders.models.PlayerLL;

import java.util.List;

public interface PlayerHandler {

    public Player nextPlayer(Player currentPlayer);
    public Player addPlayer(Player player);
    public PlayerLL getItr();
}
