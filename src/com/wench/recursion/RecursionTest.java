package com.wench.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        //通过打印数字，回顾递归调用机制
        //test(4);

        System.out.println(factorial(3));

    }

    //打印数字
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    //打印阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

}
