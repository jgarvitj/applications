package battleship.service.impl;

import battleship.models.BattleShipBlock;
import battleship.models.Ship;
import battleship.service.Board;

import java.util.List;

public class BoardImpl implements Board {

    Integer size;
    List<List<Ship>> shipLocations;
    BattleShipBlock[] board;

    public BoardImpl(int boardSize) {

    }

    public Integer getSize() {
        return size;
    }

    public List<List<Ship>> getShipLocations() {
        return shipLocations;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String addShip() {
        return null;
    }

    public void destroyShip() {

    }
}
