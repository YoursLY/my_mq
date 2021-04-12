package core;

/**
 * @author yun.lu
 * @date 2021/4/12 22:31
 * @desc
 */
public class JmqConsumer<T> {
    private final JmqBroker broker;

    private Jmq jmq;

    public JmqConsumer(JmqBroker broker) {
        this.broker = broker;
    }

    public void subscribe(String topic) {
        this.jmq = this.broker.findJmq(topic);
        if (jmq == null) {
            throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        }
    }

    public JmqMessage<T> poll(long timeout) {
        return jmq.poll(timeout);
    }
}
