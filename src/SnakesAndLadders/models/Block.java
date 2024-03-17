package SnakesAndLadders.models;

public class Block {

    private int id;
    private int value;

    public Block() {
        this.value = 1;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
