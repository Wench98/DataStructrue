package cn.wench.queue;

import javafx.scene.shape.Circle;

import java.util.Arrays;
import java.util.Scanner;

public class CircleArrayQueueDemo {

    /**
     * Let's have a try
     *
     * @param args
     */
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(4);//why maxSize is 4 ? Don't forget, there is a free position for buffering
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
 * In this java file
 * I made an adjustment to the definition of front and rear
 */
class CircleQueue {

    private int maxSize;    //  represents the maximum capacity of the array
    private int front;      //  queue head:point to the position of the first element of the queue
    private int rear;       //  queue tail:points to the next element in the last position of the queue,so that there is a proper position to buffer
    private int[] array;    //  this array is used to store data of queue - simulate queue

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        //initial value of front and rear are 0
    }

    /**
     * Determine if the queue is full
     *
     * @return
     */
    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
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
        this.array[this.rear] = data;
        this.rear=(this.rear + 1) % this.maxSize;
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
        int temp = this.array[this.front];
        this.front=(this.front + 1) % this.maxSize ;
        return temp;
    }

    /**
     * Show all data in the queue
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty,no data to show.");
        }
//        System.out.println(Arrays.toString(this.array));
        for (int i = this.front; i < this.front + size(); i++) {
            System.out.printf("arr[%d]=%d\t", i % this.maxSize, this.array[i % this.maxSize]);
        }
        System.out.println();
    }

    /**
     * Calculate the number of valid data in the queue
     * @return
     */
    public int size(){
        return (this.rear + this.maxSize - this.front) % this.maxSize;
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
        return this.array[this.front];
    }

}



