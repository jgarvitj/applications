package SnakesAndLadders.service;

import SnakesAndLadders.models.Block;
import SnakesAndLadders.models.Player;

import java.util.List;

public interface  Game {


    public void initBoard(int size);

    public void addPlayer(int id);
    public void inActivatePlayer(int id);
}
