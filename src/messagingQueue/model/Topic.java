package messagingQueue.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private final String topicName;
    private final String topicId;
    private final List<TopicSubscriber> topicSubscribers;
    private final List<Message> messageList;

    public Topic(String topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicSubscribers = new ArrayList<>();
        this.messageList = new ArrayList<>();
    }

    public synchronized void addMessage(Message message) {
        messageList.add(message);
    }

    public void addSubscriber(TopicSubscriber topicSubscriber) {
        topicSubscribers.add(topicSubscriber);
    }

    public String getTopicName() {
        return topicName;
    }

    public String getTopicId() {
        return topicId;
    }

    public List<TopicSubscriber> getTopicSubscribers() {
        return topicSubscribers;
    }

    public List<Message> getMessageList() {
        return messageList;
    }
}
