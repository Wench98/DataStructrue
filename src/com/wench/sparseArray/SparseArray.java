package com.wench.sparseArray;

public class SparseArray {

    public static void main(String[] args) {
        //create a original two-dimensional array
        int[][] chessArray1 = new int[11][11];
        //0 for no piece    1 for black piece   2 for white piece
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        //output the original two-dimensional array
        System.out.println("\nOriginal two-dimensional array as following:");
        for (int[] row : chessArray1) {
            for (int piece : row) {
                System.out.printf("%d\t", piece);
            }
            System.out.println();
        }

        //transfer the original two-dimensional array to sparse array
        int sum = 0;
        //#01.Traverse the two-dimensional array and get the number of non-zero data
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("\nThe number of non-zero data is : " + sum);
        //#02.Create the corresponding sparse array
        int[][] sparseArray = new int[sum + 1][3];
        //initialize sparse array
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //#03.Traverse two-dimensional array, put the non-zero data to the sparse array
        int count = 0;  // count is used to record the number of non-zero data
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("The resulting sparse array is : ");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

        //Restore sparse array to original two-dimensional array
        /*
            The value of the first row and first column of the sparse array
            is the row and column of the original two-dimensional array
        */
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        //make chessArray2 get correct value of row and column
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("\nThe chessArray2 is :");
        for (int[] row : chessArray2) {
            for (int piece : row) {
                System.out.printf("%d\t", piece);
            }
            System.out.println();
        }

        System.out.println("Sparse array's length is : " + sparseArray.length);

    }

}
