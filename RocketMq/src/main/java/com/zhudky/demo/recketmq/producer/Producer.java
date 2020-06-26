package com.zhudky.demo.recketmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @author : zhumengqing001
 * @date : Create in 2020/6/26 11:33 上午
 */
@Slf4j
public class Producer {

    private String namesrvAddr = "10.26.28.165:9876";

    public void produce() throws Exception {
        // 实例化一个生产者来产生延时消息
        DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
        producer.setNamesrvAddr(namesrvAddr);
        producer.setSendMsgTimeout(6000);

        // 启动生产者
        producer.start();
        int totalMessagesToSend = 10;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message("TopicTest", ("Hello scheduled message " + i).getBytes());
            // 设置延时等级3,这个消息将在10s之后发送(现在只支持固定的几个时间,详看delayTimeLevel)
            message.setDelayTimeLevel(3);
            // 发送消息
            producer.send(message);
            log.info("Produce:Hello scheduled message {} ", i);
        }
        // 关闭生产者
//        producer.shutdown();
    }
}
