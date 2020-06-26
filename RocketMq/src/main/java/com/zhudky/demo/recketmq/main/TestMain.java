package com.zhudky.demo.recketmq.main;

import com.zhudky.demo.recketmq.consumer.Consumer;
import com.zhudky.demo.recketmq.producer.Producer;
import javafx.print.PageOrientation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.processing.ProcessingEnvironment;

/**
 * @author : zhumengqing001
 * @date : Create in 2020/6/26 11:34 上午
 */
public class TestMain {
    TaskThread thread = new TaskThread();

    public TestMain(Producer producerService, Consumer consumerService) {
        thread.setConsumer(consumerService);
        thread.setProducer(producerService);
        thread.start();
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        TestMain testMain = new TestMain(producer, consumer);
    }

    @Slf4j
    @Data
    static class TaskThread extends Thread {
        private Producer producer;
        private Consumer consumer;

        @Override
        public void run() {
            try {

                log.info("----produce start----");
                producer.produce();
                log.info("----produce end----");
                log.info("----consume start----");
                consumer.consume();
                log.info("----consume end----");
            } catch (Exception e) {
                log.error("Exception:", e);
            }
        }
    }
}
