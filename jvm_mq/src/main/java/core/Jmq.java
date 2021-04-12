package core;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author yun.lu
 * @date 2021/4/12 21:48
 * @desc
 */
@Getter
@Setter
public final class Jmq {
    private String topic;

    private int capacity;

    private LinkedBlockingQueue<JmqMessage> queue;

    public Jmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new LinkedBlockingQueue<>();
    }

    public boolean send(JmqMessage jmqMessage) {
        return queue.offer(jmqMessage);
    }

    public JmqMessage poll() {
        return queue.poll();
    }

    @SneakyThrows
    public JmqMessage poll(long timeOut) {
        return queue.poll(timeOut, TimeUnit.MILLISECONDS);
    }
}
