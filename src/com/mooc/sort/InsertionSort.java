package com.mooc.sort;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTested("InsertionSort", arr);
            SortingHelper.sortTested("InsertionSort2", arr2);
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将 arr[i] 插入到合适的位置
//            for (int j = i; j > 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0)
//                    swap(arr, j, j - 1);
//                else break;
//            }
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将 arr[i] 插入到合适的位置
            E temp = arr[i];
            int j;
            for (j = i; j > 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }


    private static <E> void swap(E[] target, int x, int y) {
        E temp = target[x];
        target[x] = target[y];
        target[y] = temp;
    }

}
