package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Block {
    private int x;
    private int y;
    private boolean hasHit;
    public Block(int x, int y) {
        hasHit = false;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isHit() {
        return hasHit;
    }

    public void hit() {
        this.hasHit = true;
    }
}
