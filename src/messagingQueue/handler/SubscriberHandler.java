package messagingQueue.handler;

import messagingQueue.model.Message;
import messagingQueue.model.Topic;
import messagingQueue.model.TopicSubscriber;

public class SubscriberHandler implements Runnable {
    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberHandler(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    public Topic getTopic() {
        return topic;
    }

    public TopicSubscriber getTopicSubscriber() {
        return topicSubscriber;
    }

    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int curOffset = topicSubscriber.getOffset().get();
                while(curOffset >= topic.getMessageList().size()) {
                    try {
                        topicSubscriber.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Message message = topic.getMessageList().get(curOffset);
                try {
                    topicSubscriber.getSubscriber().consume(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                topicSubscriber.getOffset().compareAndSet(curOffset, curOffset  + 1);
            } while(true);
        }
    }

    synchronized public void wakeUpIfNeed() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
