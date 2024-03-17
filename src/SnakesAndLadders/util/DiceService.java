package SnakesAndLadders.util;

public class DiceService {

    public static int diceRoll() {
        int roll =  (int) (Math.random()*6);
        if(roll == 6) {
            return roll;
        } else {
            System.out.println("Roll is " + (roll + 1));
            return roll + 1;
        }
    }
}
