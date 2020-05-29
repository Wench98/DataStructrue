package cn.wench.search;

import java.util.ArrayList;

//注意：使用二分查找的前提是数组是有序的
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int resultIndex = binarySearch(arr, 0, arr.length - 1, 10);
        System.out.println("resultIndex:" + resultIndex);

        int[] arr1 = {1,8,10,89,1000,1000,1000,1000,1234};
        ArrayList<Integer> arrayList = binarySearch2(arr1, 0, arr1.length - 1, 1000);
        if (arrayList.size() != 0) {
            System.out.println(arrayList);
        }else {
            System.out.println("没有找到");
        }

    }

    //二分查找算法

    /**
     * @param arr     数组——此处给出的是从小到大的排序好的
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要找的值
     * @return 如果找到就返回下标，如果没有找到，就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        //当left > right时，说明递归整个数组后没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findVal > midValue) {   //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midValue) {    //向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else
            return mid;
    }

    /*
    当一个数组中，有多个相同的数值时，如何将所有的数值都查找到。
    思路分析：
    1、在找到mid索引值，不要马上返回
    2、向mid索引值的左边扫描，将所有满足匹配值的元素下标，加入到集合ArrayList中
    3、向mid索引值的右边扫描，将所有满足匹配值的元素下标，加入到集合ArrayList中
    4、将ArrayList返回
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        //当left > right时，说明递归整个数组后没有找到
        if (left > right) {
            return new ArrayList();
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findVal > midValue) {   //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midValue) {    //向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resultIndex = new ArrayList<>();
            //向mid索引值的左边扫描，将所有满足匹配值的元素下标，加入到集合ArrayList中
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则，就将temp放入到resultIndex
                resultIndex.add(temp);
                temp--;
            }
            resultIndex.add(mid);

            //向mid索引值的右边扫描，将所有满足匹配值的元素下标，加入到集合ArrayList中
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                //否则，就将temp放入到resultIndex
                resultIndex.add(temp);
                temp++;
            }
            return resultIndex;
        }
    }

}
