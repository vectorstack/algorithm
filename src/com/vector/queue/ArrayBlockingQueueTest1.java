package com.vector.queue;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by 12345 on 2018-6-14.
 */
public class ArrayBlockingQueueTest1 {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        queue.add("1");
        queue.offer("2");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.element();
        System.out.println(queue.peek());
        System.out.println("123");
        queue.take();
        queue.put("3");
        Iterator<String> iterator = queue.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
