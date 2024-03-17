package Logger.impl;

import Logger.LogConstants;
import Logger.LogProcessor;

public class ErrorLog extends LogProcessor {

    public ErrorLog(LogProcessor nextPossessor) {
        super(nextPossessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel == LogConstants.ERROR) {
            System.out.println("ERROR: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
