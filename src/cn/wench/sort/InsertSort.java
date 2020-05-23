package cn.wench.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {101, 34, 119, 1, -1, 89};

        arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);    //生成一个[0,8000000)之间的随机数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        insertSort(arr);    //调用插入排序算法

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + date2Str);

    }

    //插入排序
    public static void insertSort(int[] arr) {

        /*
            使用逐步推导的方式来讲解，便于理解
            写完了下面这三轮插入的逻辑
            现在使用for循环来吧代码简化
         */
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];   //定义待插入的数
            insertIndex = i - 1;    //即arr[1]的前面这个数的下标
            //给insertValue找到插入的位置
            //说明
            //1、insertIndex >= 0 保证在给insertValue 找插入位置，不越界
            //2、insertValue < arr[insertIndex] 待插入的数，还没有找到插入位置
            //3、就需要将arr[insertIndex]后移
            while (insertIndex >= 0 && insertValue < /*如果你要从大到小排序 就改为 > */ arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];    //arr[insertIndex]
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，insertIndex+1
            //判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
//            System.out.println("第" + i + "轮插入");
//            System.out.println(Arrays.toString(arr));
        }


        /*
        //第一轮排序
        int insertValue = arr[1];   //定义待插入的数
        int insertIndex = 1 - 1;    //即arr[1]的前面这个数的下标
        //给insertValue找到插入的位置
        //说明
        //1、insertIndex >= 0 保证在给insertValue 找插入位置，不越界
        //2、insertValue < arr[insertIndex] 待插入的数，还没有找到插入位置
        //3、就需要将arr[insertIndex]后移
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];    //arr[insertIndex]
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex + 1] = insertValue;
        System.out.println("第一轮插入");
        System.out.println(Arrays.toString(arr));

        //第二轮排序
        insertValue = arr[2];   //定义待插入的数
        insertIndex = 2 - 1;    //即arr[1]的前面这个数的下标
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];    //arr[insertIndex]
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex + 1] = insertValue;
        System.out.println("第二轮插入");
        System.out.println(Arrays.toString(arr));

        //第三轮排序
        insertValue = arr[3];   //定义待插入的数
        insertIndex = 3 - 1;    //即arr[1]的前面这个数的下标
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];    //arr[insertIndex]
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex + 1] = insertValue;
        System.out.println("第三轮插入");
        System.out.println(Arrays.toString(arr));

         */

    }

}
