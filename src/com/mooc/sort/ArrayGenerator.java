package com.mooc.sort;

import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个长度为 n 的随机数组，每个数字的范围是 [0,bound)
     * @param n
     * @param bound
     * @return
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random(bound);
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
}
