package com.zhudky.demo.recketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.Base64;

/**
 * @author : zhumengqing001
 * @date : Create in 2020/6/26 11:33 上午
 */

@Slf4j
public class Consumer {
    private String namesrvAddr = "10.26.28.165:9876";

    public void consume() throws Exception {
        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ExampleConsumer");
        consumer.setNamesrvAddr(namesrvAddr);
        // 订阅Topics
        consumer.subscribe("TopicTest", "*");
        // 注册消息监听者
        consumer.registerMessageListener((MessageListenerConcurrently) (messages, context) -> {
            System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + messages + "%n");
            for (MessageExt message : messages) {
                // Print approximate delay time period
                log.info("[Consume]Receive message[msgId={}] {} ms later: {}", message.getMsgId(), System.currentTimeMillis() - message.getStoreTimestamp(), new String(message.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        // 启动消费者
        consumer.start();
    }
}
