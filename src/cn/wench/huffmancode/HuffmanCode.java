package cn.wench.huffmancode;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);    //40

        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是：" + Arrays.toString(huffmanCodeBytes));
        System.out.println("长度为：" + huffmanCodeBytes.length);

        byte[] sourceBytes = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println("原字符串为：" + Arrays.toString(sourceBytes));

        /*
        List<Node> nodes = getNodes(contentBytes);
        System.out.println("nodes=" + nodes);

        //测试，创建二叉树
        System.out.println("赫夫曼树");
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        huffmanTreeRoot.preOrder();

        //测试是否生成了对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        System.out.println("生成的赫夫曼编码表:" + huffmanCodes);

        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
        System.out.println("huffmanCodeBytes= " + Arrays.toString(huffmanCodeBytes));   //17

         */

    }

    /*
    完成数据的解压
    思路：
        1、将huffmanCodeBytes -> 赫夫曼编码对应的二进制的字符串
        2、赫夫曼编码对应的二进制的字符串 -> 对应的赫夫曼编码 -> 原始的字符串
     */

    /**
     * 编写一个方法，完成对压缩数据的解码
     *
     * @param huffmanCodes 赫夫曼编码表  map
     * @param huffmanBytes 原始字符串经赫夫曼编码表处理后对应的字节数组
     * @return 原始字符串对应的二进制字节数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //得到huffmanBytes 对应的二进制的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //把字符串按照指定的赫夫曼编码表进行解码
        //现在将赫夫曼编码表进行反转
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建一个集合，存放byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;  //计数器
            boolean flag = true;
            Byte b = null;

            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {    //说明没有匹配到
                    count++;
                } else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;   //i自动移动到count
        }
        //当for循环结束后，list中就存放了所有的字符
        //把list中的数据放入到byte[]并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将一个byte 转成一个二进制的字符串
     *
     * @param flag 标识是否需要补高位 true-补高位 false-不补高位    最后一个字节无需补高位
     * @param b    传入的byte
     * @return 传入的b 对应的二进制的字符串 是按补码返回
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存b
        int temp = b;
        //如果是正数还需要进行补高位
        if (flag) {
            temp |= 256;    //按位或
        }
        String str = Integer.toBinaryString(temp);  //返回的是temp对应的二进制的补码
        if (flag) {
            return str.substring(str.length() - 0);
        } else {
            return str;
        }
    }

    /**
     * 使用一个方法，将之前的方法封装起来，便于调用
     *
     * @param bytes
     * @return 经赫夫曼编码表处理后所对应的字节数组
     */
    public static byte[] huffmanZip(byte[] bytes) {

        List<Node> nodes = getNodes(bytes);
        //根据nodes创建的赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //根据赫夫曼树得到对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码，压缩得到 经赫夫曼编码处理后所对应的字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);

        return huffmanCodeBytes;
    }

    /**
     * 编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码表对应的压缩后的byte[]
     *
     * @param bytes        原始字符串对应的byte[]
     * @param huffmanCodes 生成的赫夫曼编码表-map
     * @return 返回字符串经赫夫曼编码表处理后对应的byte[]
     * 这里涉及到的补码、反码、原码，可自行查阅资料，不难，耐心些看看就会明白是怎么回事
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1、利用huffmanCodes 将 bytes 转成 赫夫曼编码表对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes 数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //返回byte[]  huffmanCodeBytes 长度
        //一条语句的写法：int len = (stringBuilder.length() + 7)/8
        int len = 0;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;  //记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte 转成一个byte，放入到 huffmanCodeBytes中
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }

        return huffmanCodeBytes;
    }

    //生成赫夫曼树对应的赫夫曼编码
    //思路：
    //1、将赫夫曼编码表存放在Map<Byte,String> 形式 32->01 97->100 100->11000等形式
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //2、在生成赫夫曼编码表示，需要去拼接路径，定义一个StringBuilder存储某个叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    //为了调用方便，重载getCodes
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        //处理root的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 功能：将传入的node结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCodes集合中
     *
     * @param node          传入结点
     * @param code          路径：左子结点是0，右子结点是1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code加入到 stringBuilder2
        stringBuilder2.append(code);
        if (node != null) { //如果node==null 不处理
            //判断当前node 是叶子结点还是非叶子结点
            if (node.data == null) { //非叶子结点
                //递归处理
                //向左递归
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else {//说明是一个叶子结点
                //就表示找到了某个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    //前序遍历的方法
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }

    /**
     * @param bytes 接受字节数组
     * @return 返回的就是List形式的Node集合
     */
    public static List<Node> getNodes(byte[] bytes) {
        //创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<>();

        //遍历bytes，统计每一个byte出现的次数 -->  Map<key,value>
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {    //Map还没有这个字符数据，第一次
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //把每一个键值对转成一个Node对象，并加入到nodes集合
        //遍历map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    //可以通过List 创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序，从大到小
            Collections.sort(nodes);
            //取出第一棵最小的二叉树
            Node leftNode = nodes.get(0);
            //取出第二棵最小的二叉树
            Node rightNode = nodes.get(1);
            //创建一棵新的二叉树，它的根结点没有data，只有权值
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //将已经处理的两棵二叉树从nodes删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树，加入到nodes
            nodes.add(parent);
        }
        //nodes 最后的结点就是赫夫曼树的根结点
        return nodes.get(0);
    }

}

//创建Node，带数据和权值
class Node implements Comparable<Node> {
    Byte data;  //存放数据(字符)本身，比如'a' => 97  ' ' => 32
    int weight; //权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
