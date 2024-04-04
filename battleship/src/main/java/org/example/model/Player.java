package org.example.model;

import java.util.List;

public class Player {
    private String id;
    private PlayArea playArea;

    public Player(String id, PlayArea playArea) {
        this.id = id;
        this.playArea = playArea;
    }
    public String getId() {
        return id;
    }

    public PlayArea getPlayArea() {
        return playArea;
    }
}
