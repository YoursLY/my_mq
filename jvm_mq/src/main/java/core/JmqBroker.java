package core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yun.lu
 * @date 2021/4/12 22:29
 * @desc
 */
public class JmqBroker {
    public static final int CAPACITY = 10000;
    private final Map<String, Jmq> jmqMap = new ConcurrentHashMap<>(64);

    public void createTopic(String topic) {
        jmqMap.putIfAbsent(topic, new Jmq(topic, CAPACITY));
    }

    public Jmq findJmq(String topic) {
        return this.jmqMap.get(topic);
    }

    public JmqProducer createProducer() {
        return new JmqProducer(this);
    }

    public JmqConsumer createConsumer() {
        return new JmqConsumer(this);
    }
}
