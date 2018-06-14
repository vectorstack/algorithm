package com.vector.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 12345 on 2018-6-14.
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        class A {
            public A(){

            }

            @Override
            public String toString() {
                return "A";
            }
        }

        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        queue.add("1");
        queue.add("2");
        queue.offer("123");
        queue.offer(2);
        queue.offer(new A());
        Object[] array = queue.toArray();
        for(Object object: array){
            System.out.println(object.toString());
        }


    }
}
