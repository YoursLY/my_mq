package demo;

import core.JmqBroker;
import core.JmqConsumer;
import core.JmqMessage;
import core.JmqProducer;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;

/**
 * @author yun.lu
 * @date 2021/4/12 22:51
 * @desc
 */
public class JmqDemo {
    @SneakyThrows
    public static void main(String[] args) {
        //在broker中注册topic
        String topic = "topic01";
        JmqBroker broker = new JmqBroker();
        broker.createTopic(topic);

        //生产消息
        JmqProducer producer = broker.createProducer();
        for (int i = 0; i < 1000; i++) {
            Order order = new Order(i, "81840" + RandomUtils.nextInt(10000, 100000), RandomUtils.nextInt(0, 9) + "", RandomUtils.nextInt());
            HashMap<String, Object> head = new HashMap<>();
            head.put("head", "tou");
            producer.send(topic, new JmqMessage(head, order));
        }
        Thread.sleep(500);

        //consumer订阅topic
        JmqConsumer consumer = broker.createConsumer();
        consumer.subscribe(topic);
        //消费消息
        new Thread(() -> {
            while (true) {
                JmqMessage message = consumer.poll(1000);
                if (message == null) {
                    System.out.println("所有消息已经消费,退出消费");
                    break;
                }
                System.out.println("本次消息内容为:" + message.getBody());
            }
        }).start();


    }

}
