package messagingQueue.service;

import Logger.LogConstants;
import Logger.LogProcessor;
import messagingQueue.model.Message;

public class Sub1 implements  Subscriber {

    private String id;
    private LogProcessor logProcessor;

    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        logProcessor.log(LogConstants.INFO, "Sub: " + id + " Message: " + message.getMessage());
        Thread.sleep(10000);
        logProcessor.log(LogConstants.INFO, "MESSAGE CONSUMED Sub: " + id + " Message: " + message.getMessage());
    }
}
