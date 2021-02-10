package com.mooc.search;

public class LinearSearch {
    private LinearSearch() {
    }

    public static void main(String[] args) {
//        int[] array = {24, 18, 12, 9, 16, 66, 32, 4};
//        Integer[] array = {24, 18, 12, 9, 16, 66, 32, 4};
        int n = 10000000;
        Integer[] array = ArrayGenerator.generateOrderedArray(n);
        long startTime = System.nanoTime();
        search(array, n);
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println(time + "s");

        /*
        int result = search(array, 16);
        System.out.println(result);

        int res = search(array, 666);
        System.out.println(res);

        Student[] students = {
                new Student("Alice"),
                new Student("Lily"),
                new Student("Wench")};

        Student wench = new Student("Wench");
        int res3 = search(students, wench);
        System.out.println(res3);
         */

    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
