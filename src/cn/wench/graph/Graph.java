package cn.wench.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private ArrayList<String> vertexList;   //存储顶点集合
    private int[][] edges;      //存储图对应的邻接矩阵
    private int numOfEdges;     //表示边的数目

    public static void main(String[] args) {
        //测试图是否创建成功
        int n = 5;
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        //显示邻接矩阵
        graph.showGraph();
    }

    //构造器
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }


    //图中常用的方法

    /**
     * @return 返回结点的个数
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 显示图对应的矩阵
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * @return 得到边的数目
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * @param i 结点的下标即索引
     * @return 返回i对应的数据
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * @param v1 下标1
     * @param v2 下标2
     * @return 返回v1和v2的权值
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     表示点的下标(索引)即指第几个顶点
     * @param v2     表示第二个顶点对应的下标
     * @param weight 表示上述两点的连接情况
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

}
