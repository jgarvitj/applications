package SnakesAndLadders.models;

public class PlayerLL {

    private Player curr;
    private Player next;
    private Player pre;
    private static PlayerLL playerLL;

    private PlayerLL(Player curr) {
        this.curr = curr;
        this.next = curr;
        this.pre = curr;
    }

    public static PlayerLL init(Player p) {
        if(playerLL == null) {
            playerLL = new PlayerLL(p);
        }
        return playerLL;
    }

    public Player getCurr() {
        return curr;
    }

    public void setCurr(Player curr) {
        this.curr = curr;
    }

    public Player getNext() {
        return next;
    }

    public void setNext(Player next) {
        this.next = next;
    }

    public Player getPre() {
        return pre;
    }

    public void setPre(Player pre) {
        this.pre = pre;
    }
}
