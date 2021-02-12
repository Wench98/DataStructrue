package com.mooc.sort;

public class SelectionSort {
    public SelectionSort() {
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTested("SelectionSort", arr);
//        System.out.println(Arrays.toString(arr));

//        Student[] students = {
//                new Student("Charles", 66),
//                new Student("Alice", 99),
//                new Student("Wench", 100)
//        };
//        selectSort(students);
//        for (Student student : students) {
//            System.out.println(student);
//        }
    }

    public static <E extends Comparable<E>> void sort(E[] array) {
        int minIndex;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex].compareTo(array[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    private static <E> void swap(E[] target, int x, int y) {
        E temp = target[x];
        target[x] = target[y];
        target[y] = temp;
    }
}
