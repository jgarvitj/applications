package Logger.impl;

import Logger.LogConstants;
import Logger.LogProcessor;

public class InfoLog extends LogProcessor {

    public InfoLog(LogProcessor nextPossessor) {
        super(nextPossessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel == LogConstants.INFO) {
            System.out.println("INFO: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}