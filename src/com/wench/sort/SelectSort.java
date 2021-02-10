package com.wench.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
        int[] arr = {101, 34, 119, 1,-1,90,123};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);    //生成一个[0,8000000)之间的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);


        selectSort(arr);

//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + date2Str);

    }

    //选择排序
    public static void selectSort(int[] arr) {

        //在推导的过程中，发现了规律，因此，可以使用一个外层for来解决
        //时间复杂度：O(n^2)
        int minIndex = 0;
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[i];
            //第一轮
            for (int j = i + 1; j < arr.length; j++) {
                if (min < arr[j]) {  //说明假定的最小值，并不是最小   ">" 改为 "<" 便是从大到小的过程了 -_-!!!
                    min = arr[j];   //重置min
                    minIndex = j;   //重置minIndex
                }
            }
            //将最小值交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第" + (i + 1) + "轮");
//            System.out.println(Arrays.toString(arr));
        }

        /*
        使用逐步推导的方式来，讲解排序
        算法：先简单 --> 再复杂 即可以把一个复杂的算法，拆分成简单的问题，然后逐步解决
         */

        /*
        int minIndex = 0;
        int min = arr[0];
        //第一轮
        for (int j = 0 + 1; j < arr.length; j++) {
            if (min > arr[j]) {  //说明假定的最小值，并不是最小
                min = arr[j];   //重置min
                minIndex = j;   //重置minIndex
            }
        }
        //将最小值交换
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }

        System.out.println("第一轮");
        System.out.println(Arrays.toString(arr));

        //第二轮
        minIndex = 1;
        min = arr[1];
        for (int j = 1 + 1; j < arr.length; j++) {
            if (min > arr[j]) {  //说明假定的最小值，并不是最小
                min = arr[j];   //重置min
                minIndex = j;   //重置minIndex
            }
        }
        //将最小值交换
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("第二轮");
        System.out.println(Arrays.toString(arr));

        //第三轮
        minIndex = 2;
        min = arr[2];
        for (int j = 2 + 1; j < arr.length; j++) {
            if (min > arr[j]) {  //说明假定的最小值，并不是最小
                min = arr[j];   //重置min
                minIndex = j;   //重置minIndex
            }
        }
        //将最小值交换
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("第三轮");
        System.out.println(Arrays.toString(arr));

         */

    }

}
