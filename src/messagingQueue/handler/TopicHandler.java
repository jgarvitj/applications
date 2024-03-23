package messagingQueue.handler;

import messagingQueue.model.Topic;
import messagingQueue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {

    private final Topic topic;
    private final Map<String, SubscriberHandler> subscriberHandlerMap;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberHandlerMap = new HashMap<>();
    }

    public void publish() {
        for(TopicSubscriber topicSubscriber : topic.getTopicSubscribers()) {
            startSubscriberWorker(topicSubscriber);
        }
    }

    private void startSubscriberWorker(TopicSubscriber topicSubscriber) {
        final String subId = topicSubscriber.getSubscriber().getId();
        if(!subscriberHandlerMap.containsKey(subId)) {
            SubscriberHandler subscriberHandler = new SubscriberHandler(topic, topicSubscriber);
            subscriberHandlerMap.put(subId, subscriberHandler);
            new Thread(subscriberHandler).start();
        }
        SubscriberHandler subscriberHandler = subscriberHandlerMap.get(subId);
        subscriberHandler.wakeUpIfNeed();

    }
}
