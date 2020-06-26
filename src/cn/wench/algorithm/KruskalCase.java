package cn.wench.algorithm;

import java.util.Arrays;

public class KruskalCase {

    private int edgeNum;    //边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    //使用INF 表示两个顶点不能连通
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        //创建KruskalCase实例
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        //输出构建的邻接矩阵
        kruskalCase.print();
        kruskalCase.kruskal();

        /*EData[] edges = kruskalCase.getEdges();
        System.out.println("排序前= " + Arrays.toString(edges));
        kruskalCase.sortEdges(edges);
        System.out.println("排序后= " + Arrays.toString(edges));*/

    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        //初始化顶点数和边的个数
        int vlen = vertexs.length;
        //初始化顶点，复制拷贝的方式
        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        //初始化边，使用的是复制拷贝的方式
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边的数目
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0;  //表示最后结果数组的索引
        int[] ends = new int[edgeNum];  //用于保存"已有最小生成树" 中的每个顶点在最小生成树中的终点
        EData[] rets = new EData[edgeNum];  //创建结果数组，保存最后的最小生成树
        EData[] edges = getEdges();     //获取图中所有的边的集合，一共有12边
        System.out.println("图的边的集合为：" + Arrays.toString(edges) + " 共" + edges.length);
        //按照边的权值大小进行排序(从小到大)
        sortEdges(edges);
        //遍历edges 数组，将不构成回路的顶点加入到rets
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);   //获取第i条边的第一个顶点
            int p2 = getPosition(edges[i].end);     //获取第i条边的第二个顶点
            int m = getEnd(ends, p1);               //获取p1在已有最小生成树中的终点
            int n = getEnd(ends, p2);               //获取p2在已有最小生成树中的终点
            if (m != n) {   //没有构成回路
                ends[m] = n;  //设置m 在"已有最小生成树"中的终点
                rets[index++] = edges[i];   //将合适的边加入到rets数组
            }
        }
        //统计并打印"最小生成树"
        System.out.println("最小生成树为：");
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
//        System.out.println("最小生成树为：" + Arrays.toString(rets));

    }

    //打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为：");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 功能：对边进行排序处理，冒泡排序
     *
     * @param edges 边的集合
     */
    private void sortEdges(EData[] edges) {
        EData tmp = null;
        boolean flag = false;
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }

    /**
     * @param ch 顶点的值，比如'A'，'B'
     * @return 返回ch顶点对应的下标，如果找不到，返回-1
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        //找不到，返回-1
        return -1;
    }

    /**
     * 获取图中的边，放到EData[] 数组中，后面我们需要遍历该数组，通过matrix 邻接矩阵来获取
     *
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点，用于后面判断两个顶点的终点是否相同
     *
     * @param ends 记录了各个顶点对应的终点是哪个，ends数组是在遍历过程中，逐步形成
     * @param i    表示传入的顶点对应的下标
     * @return 返回下标为i的顶点对应的终点下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

}

//创建一个类EData，它的对象实例就表示一条边
class EData {
    char start; //边的一个点
    char end;   //变得另一个点
    int weight; //边的权值

    //构造器
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "<" + start +
                "," + end +
                ">=" + weight +
                '}';
    }
}








