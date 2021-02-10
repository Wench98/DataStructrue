package com.wench.stack;

import java.util.Scanner;

public class LinkedListStackDemo {

    public static void main(String[] args) {
        LinkedListStack listStack = new LinkedListStack();
        String key = "";
        boolean loop = true;    //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show：表示显示栈的数据");
            System.out.println("exit：退出程序");
            System.out.println("push：表示添加数据到栈（入栈）");
            System.out.println("pop：表示从栈取出数据（出栈）");

            System.out.println("请输入您的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    listStack.listStack();
                    break;
                case "push":
                    System.out.println("请您输入一个数");
                    int value = scanner.nextInt();
                    listStack.push(value);
                    break;
                case "pop":
                    int res = listStack.pop();
                    System.out.println("出栈的数据为：" + res);
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("已退出。");
    }

}

class LinkedListStack {
    private DataNode head = new DataNode(0);

    public DataNode getHead() {
        return head;
    }

    public void push(int value) {
        DataNode dataNode = new DataNode();
        DataNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        dataNode.data = value;
        temp.next = dataNode;
    }

    public int pop() {
        DataNode lastNode = new DataNode();
        if (head.next == null) {
            throw new RuntimeException("很抱歉，栈空。");
        }
        DataNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            lastNode = temp;
            temp = temp.next;
        }
        lastNode.next = null;
        return temp.data;
    }

    public void listStack() {
        if (head.next == null) {
            System.out.println("很抱歉，栈空。");
            return;
        }
        DataNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class DataNode {
    public int data;
    public DataNode next;

    public DataNode() {
    }

    public DataNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataNode{" +
                "data=" + data +
                '}';
    }
}
