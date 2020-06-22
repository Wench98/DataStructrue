package cn.wench.algorithm;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = {1, 4, 3};   //物品的重量
        int[] val = {1500, 3000, 2000};//物品的价值 这里val[i] 就是课件中介绍的v[i]
        int m = 4;  //背包的容量
        int n = val.length; //物品的个数

        //创建二维数组
        //v[i][j]   表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        //为记录放入商品的情况，定一个二维数组
        int[][] path = new int[n + 1][m + 1];

        //初始化第一行和第一列，这里在本程序中，可以不去处理，因为默认的就是0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;   //将第一列设置为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;    //将第一行设置为0
        }

        //根据课件公式来进行动态规划处理
        for (int i = 1; i < v.length; i++) {    //不处理第 1 行
            for (int j = 1; j < v[0].length; j++) { //不处理第 1 列
                if (w[i - 1] > j) { //i是从 1 开始的
                    v[i][j] = v[i - 1][j];
                } else {
//                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前情况记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出以下v 看看目前的价值情况
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第 %d 个商品放入到背包中\n", i);
                j -= w[i - 1];
            }
            i--;
        }

    }

}










