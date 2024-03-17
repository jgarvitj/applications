package Logger;

import Logger.impl.DebugLog;
import Logger.impl.ErrorLog;
import Logger.impl.InfoLog;

public class LogProcessor {

    private LogProcessor nextProcessor;

    public LogProcessor(LogProcessor logProcessor) {
        this.nextProcessor = logProcessor;
    }

    public LogProcessor() {
        this.nextProcessor = new ErrorLog(new InfoLog(new DebugLog(null)));
    }

    public void log(int logLevel, String message) {
        if(nextProcessor != null) {
            nextProcessor.log(logLevel, message);
        }
    }

}
