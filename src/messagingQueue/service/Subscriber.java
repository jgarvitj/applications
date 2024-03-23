package messagingQueue.service;

import messagingQueue.model.Message;

public interface Subscriber {
    String getId();

    void consume(Message message) throws InterruptedException;
}
