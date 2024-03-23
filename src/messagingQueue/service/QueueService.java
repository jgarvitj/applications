package messagingQueue.service;

import messagingQueue.handler.TopicHandler;
import messagingQueue.model.Message;
import messagingQueue.model.Topic;
import messagingQueue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QueueService {

    private final Map<String, TopicHandler> topicHandlerMap;

    public QueueService() {
        this.topicHandlerMap = new HashMap<>();
    }

    public Topic createTopic(String topicName) {
        Topic topic = new Topic(UUID.randomUUID().toString(), topicName);
        topicHandlerMap.put(topic.getTopicId(), new TopicHandler(topic));
        return topic;
    }

    public void subscribe(Subscriber subscriber, Topic topic) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
    }

    public void publish(Topic topic, Message message) {
        topic.addMessage(message);
        new Thread(() -> topicHandlerMap.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffset(Topic topic, Subscriber subscriber, Integer offset) {
        for(TopicSubscriber topicSubscriber : topic.getTopicSubscribers()) {
            if(topicSubscriber.getSubscriber().getId().equals(subscriber.getId())) {
                topicSubscriber.getOffset().set(offset);
                new Thread(() -> topicHandlerMap.get(topic.getTopicId()).publish()).start();
                break;
            }
        }
    }
}
