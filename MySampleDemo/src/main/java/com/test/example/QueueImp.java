package com.test.example;

import java.util.LinkedList;

/**
 * Created by sujitagarwal on 31/03/17.
 */
public class QueueImp<T> {
    LinkedList<T> ts=new LinkedList<T>();
    public void enqueue(T element)
    {
        ts.addLast(element);
    }

    public T deque()
    {
        return ts.poll();
    }

    public static void main(String[] args) {
        QueueImp<String> stringQueueImp=new QueueImp<String>();
        stringQueueImp.enqueue("sujit");
        stringQueueImp.enqueue("agarwal");
        System.out.println(stringQueueImp.deque());
    }
}
