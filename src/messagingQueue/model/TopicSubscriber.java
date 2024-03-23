package messagingQueue.model;

import messagingQueue.service.Subscriber;

import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber {

    public final AtomicInteger offset;
    private  final Subscriber subscriber;

    public TopicSubscriber(Subscriber subscriber) {
        this.offset = new AtomicInteger(0);
        this.subscriber = subscriber;
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }
}
