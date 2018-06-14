package com.vector.queue;

import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * Created by vector on 2018-6-14.
 */
public class BlockingQueueTest {
    public static class Basket{
        BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

        public void produce() throws InterruptedException {
            basket.put("An apple");
        }

        public String consume() throws InterruptedException {
            String apple = basket.take();
            return apple;
        }

        public int getAppleCount(){
            return basket.size();
        }
    }

    public static void testBasket(){
        final Basket basket = new Basket();

        class Produce implements Runnable{

            @Override
            public void run() {
                try {
                    while(true){

                            System.out.println("������׼������ƻ�� :"+ System.currentTimeMillis());
                            basket.produce();
                            System.out.println("����������ƻ����� :"+ System.currentTimeMillis());
                            System.out.println("���������ƻ����"+basket.getAppleCount()+"��");
                            Thread.sleep(300);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        class Consumer implements Runnable{
            @Override
            public void run() {
                try {
                    while(true){
                        System.out.println("������׼������ƻ����"+System.currentTimeMillis());
                        basket.consume();
                        System.out.println("����������ƻ����ϣ�"+System.currentTimeMillis());
                        System.out.println("���������ƻ����"+basket.getAppleCount()+"��");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        Produce produce = new Produce();
        Consumer consumer = new Consumer();
        executorService.submit(produce);
        executorService.submit(consumer);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }

    public static void main(String[] args) {
        BlockingQueueTest.testBasket();
    }
}
