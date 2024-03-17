package Logger.impl;

import Logger.LogConstants;
import Logger.LogProcessor;

public class DebugLog extends LogProcessor {

    public DebugLog(LogProcessor nextPossessor) {
        super(nextPossessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel == LogConstants.DEBUG) {
            System.out.println("DEBUG: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
