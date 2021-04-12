package core;

import lombok.AllArgsConstructor;

/**
 * @author yun.lu
 * @date 2021/4/12 22:31
 * @desc
 */
@AllArgsConstructor
public class JmqProducer {
    private JmqBroker broker;

    public boolean send(String topic, JmqMessage jmqMessage) {
        Jmq jmq = this.broker.findJmq(topic);
        if (null == jmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        return jmq.send(jmqMessage);
    }

}
