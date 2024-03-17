package SnakesAndLadders.util;

import Logger.LogConstants;
import Logger.LogProcessor;
import Logger.impl.InfoLog;

public class DiceService {

    public static LogProcessor logProcessor = new LogProcessor();

    public static int diceRoll() {
        int roll =  (int) (Math.random()*6);
        if(roll == 6) {
            return roll;
        } else {
            logProcessor.log(LogConstants.INFO, "Roll is " + (roll + 1));
            return roll + 1;
        }
    }
}
