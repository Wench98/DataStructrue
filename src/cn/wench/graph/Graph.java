package cn.wench.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList;   //存储顶点集合
    private int[][] edges;      //存储图对应的邻接矩阵
    private int numOfEdges;     //表示边的数目
    //定义一个数组boolean[]，记录某个结点是否被访问
    private boolean[] isVisited;

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
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        //显示邻接矩阵
        graph.showGraph();

        //测试dfs遍历是否可行
        System.out.println("深度优先遍历");
//        graph.dfs();

        System.out.println();

        System.out.println("广度优先遍历");
        graph.bfs();

    }

    //构造器
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    /**
     * 得到第一个邻接结点的下标w
     *
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先算法
     *
     * @param isVisited
     * @param i         第一次就是0
     */
    private void dfs(boolean[] isVisited, int i) {
        //首先访问该结点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1) {//说明有
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 对dfs进行一个重载，遍历所有的结点，并进行dfs
     */
    public void dfs() {
        //遍历所有的结点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 对一个结点进行广度优先遍历的方法
     *
     * @param isVisited
     * @param i
     */
    private void bfs(boolean[] isVisited, int i) {
        int u;  //表示队列头结点的下标
        int w;  //邻接结点w
        //队列，记录结点访问的顺序
        LinkedList<Object> queue = new LinkedList<>();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()) {
            //取出队列的头结点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接结点的下标w
            w = getFirstNeighbor(u);
            while (w != -1) {   //找到
                //是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个领结点
                w = getNextNeighbor(u, w);   //体现出我们的广度优先
            }
        }
    }

    /**
     * 遍历所有的结点，都进行广度优先搜索
     */
    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
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
