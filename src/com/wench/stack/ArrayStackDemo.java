package com.wench.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        //测试ArrayStack是否正确
        ArrayStack stack = new ArrayStack(4);
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
                    stack.list();
                    break;
                case "push":
                    System.out.println("请您输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    int res = stack.pop();
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

/**
 * 定义一个ArrayStack 表示栈
 */
class ArrayStack {
    private int maxsize;    //栈的大小
    private int[] stack;    //数组，数组模拟栈，数据就放在该数组中
    private int top = -1;   //top表示栈顶

    public ArrayStack(int maxsize) {
        this.maxsize = maxsize;
        stack = new int[this.maxsize];
    }

    //栈满
    public boolean isFull() {
        return top == maxsize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈——push
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("很抱歉，栈满。");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈——pop
    public int pop() {
        //先判断栈是否空
        if (isEmpty()) {
            throw new RuntimeException("很抱歉，栈空。");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的内容[遍历栈]，遍历时，需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("很抱歉，栈空，没有数据。");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }

}
