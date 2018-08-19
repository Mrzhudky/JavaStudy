package com.company;
import java.util.*;

/**
 * 作者：筱茜
 * 链接：https://www.nowcoder.com/discuss/74859
 * 来源：牛客网
 *
 * 实现生产者消费者模型（60分钟）
 *
 * 需求描述：
 *
 * 在一个系统中，存在生产者和消费者两种角色，他们通过内存缓冲区进行通信，
 * 生产者生产消费者需要的资料，消费者把资料做成产品，先要求模拟实现一个生产者消费者模型，具体要求如下： 
 * 生产者与消费者线程独立，通过不同线程实现
 * 内存缓冲区为空的时候消费者必须等待，而内存缓冲区满的时候，生产者必须等待
 * 多线程对临界区资源的操作时候必须保证在读写中只能存在一个线程
 *
 *考查知识点：
 * Java多线程的概念及其基本使用方法
 * 并发同步与互斥基础
 * 集合类与并发集合的高级特性
 *
 * 参考知识点：《java基础入门》第5章、第7章
 */
public class Main {

    private int queueSize = 10;
    //非阻塞队列
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

    // 生产者
    class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true){
                synchronized(queue){
                    while (queue.size() == queueSize){
                        try{
                            System.out.println("队列满，等待空余空间！");
                            queue.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();;
                            queue.notify();
                        }
                    }
                    queue.offer(1);//插入一个元素
                    queue.notify();
                    System.out.println("插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                }
            }
        }
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            consume();
        }
        private void consume(){
            while (true){
                synchronized(queue){
                    while (queue.size() == 0){
                        try{
                            System.out.println("队列空，等待插入元素！");
                            queue.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("删除一个元素，队列剩余空间：" + (queueSize - queue.size()));
                }
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        Producer producer = m.new Producer();
        Consumer consumer = m.new Consumer();
        producer.start();
        consumer.start();
    }


}
