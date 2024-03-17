package SnakesAndLadders.models;

public class Player {

    private int id;
    private int location;
    private boolean isActive;

    public Player() {
        this.id = 0;
        this.location = 0;
        this.isActive = true;
    }

    public Player(int id) {
        this.id = id;
        this.location = 0;
        this.isActive = true;
    }

    public void inAvtivatePlayer() {
        this.isActive = false;
    }

    public int getId() {
        return this.id;
    }

    public int getLocation() {
        return this.location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public boolean isActive() {
        return this.isActive;
    }
}
