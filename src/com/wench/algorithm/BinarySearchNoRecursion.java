package com.wench.algorithm;

/**
 * 二分查找非递归
 */
public class BinarySearchNoRecursion {

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 10);
        if (index == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println("index = " + index);
        }

    }

    /**
     * 二分查找非递归算法
     *
     * @param arr    待查找的数组，arr是升序排序
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr, int target) {
        int right = arr.length - 1;
        int left = 0;
        int mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
