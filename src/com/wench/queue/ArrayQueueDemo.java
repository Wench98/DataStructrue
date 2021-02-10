package com.wench.queue;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQueueDemo {

    /**
     * Let's have a try
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);//create a queue
        char command = ' ';//receive user input
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //simulate a user input interface
        while (loop) {
            System.out.println("s --- show queue");
            System.out.println("e --- exit");
            System.out.println("a --- enqueue");
            System.out.println("g --- dequeue");
            System.out.println("h --- head data");
            command = scanner.next().charAt(0);//receive a character
            switch (command) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("input data you want to dequeue:");
                    int data = scanner.nextInt();
                    queue.addQueue(data);
                    break;
                case 'g':
                    try {
                        int queueData = queue.getData();
                        System.out.println("The data is : " + queueData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headData = queue.headData();
                        System.out.println("The headData of the queue is : " + headData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Already exit!");
    }

}

/**
 * use an array to simulate a queue
 * so we should write a 'ArrayQueue' class
 */
class ArrayQueue {

    private int maxSize;    //  represents the maximum capacity of the array
    private int front;      //  queue head:the previous position of the queue head
    private int rear;       //  queue tail:the data of the queue tail
    private int[] array;    //  this array is used to store data of queue - simulate queue

    /**
     * constructor for creating queues
     *
     * @param maxSize maximum capacity of the array(or queue)
     */
    public ArrayQueue(int maxSize) {
        this.array = new int[maxSize];
        this.maxSize = maxSize;
        this.front = -1;//point to the head of the queue, which is the previous position of the queue head
        this.rear = -1;//point to the tail of the queue,which is the data of the queue tail
    }

    /**
     * Determine if the queue is full
     *
     * @return
     */
    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    /**
     * Determine if the queue is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * Add data to the queue,enqueue
     *
     * @param data
     */
    public void addQueue(int data) {
        //Determine if the queue is full
        if (isFull()) {
            System.out.println("The queue is full now,so you can't put the data into it.");
            return;
        }
        this.rear++;
        this.array[this.rear] = data;
    }

    /**
     * Get data from the queue,dequeue
     *
     * @return
     */
    public int getData() {
        //Determine if the queue is empty
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty,you can only put data in it.");
        }
        this.front++;
        return this.array[this.front];
    }

    /**
     * Show all data in the queue
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty,no data to show.");
        }
        System.out.println(Arrays.toString(this.array));
        for (int i = 0; i < this.array.length; i++) {
            System.out.printf("arr[%d]=%d\t", i, this.array[i]);
        }
        System.out.println();
    }

    /**
     * Get head data of the queue
     *
     * @return
     */
    public int headData() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty,there is no head of the queue.");
        }
        return this.array[this.front + 1];
    }

}