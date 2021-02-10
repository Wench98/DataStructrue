package com.wench.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
//        int arr[] = {3, 9, -1, 10, 20};
//        int arr[] = {1, 2, 3, 4, 5};

//        System.out.println("Before");
//        System.out.println(Arrays.toString(arr));

        //测试一下冒泡排序的速度，给80000个数据进行测试
        //创建一个80000个数的随机数组

        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);    //生成一个[0,8000000)之间的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        bubbleSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + date2Str);

//        System.out.println("After");
//        System.out.println(Arrays.toString(arr));

        //为了容易理解，将冒泡排序的演变过程，以代码演示

        /*
        //第一躺排序，就是将最大的数排在最后
        //第二躺排序，就是将第二大的数排在倒数第二位
        for (int j = 0; j < arr.length - 1 - 1; j++) {
            //如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

            }
        }
        System.out.println("第二躺排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第三躺排序，就是将第三大的数排在倒数第三位
        for (int j = 0; j < arr.length - 1 - 2; j++) {
            //如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

            }
        }
        System.out.println("第三躺排序后的数组");
        System.out.println(Arrays.toString(arr));

        //第四躺排序，就是将第四大的数排在倒数第四位
        for (int j = 0; j < arr.length - 1 - 3; j++) {
            //如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

            }
        }
        System.out.println("第四躺排序后的数组");
        System.out.println(Arrays.toString(arr));

         */

    }

    //将前面的冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr) {
        //冒泡排序时间复杂度：O(n^2),最好自己写出来
        int temp = 0;   //临时变量
        boolean flag = false;   //表示是否进行交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }

//            System.out.println("第" + (i + 1) + "躺排序后的数组");
//            System.out.println(Arrays.toString(arr));

            if (!flag) {    //在某一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false;   //重置flag，进行下次判断交换
            }
        }
    }

}
