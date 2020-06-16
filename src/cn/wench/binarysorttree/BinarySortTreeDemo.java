package cn.wench.binarysorttree;

public class BinarySortTreeDemo {

    public static void main(String[] args) {

        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();

    }

}

/**
 * 创建二叉排序树
 */
class BinarySortTree {
    private Node root;

    /**
     * 添加结点的方法
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;  //如果root为空则直接让root指向node
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空，不能遍历。");
        }
    }

}

/**
 * 创建Node结点
 */
class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 添加结点的方法
     * 递归形式添加结点，注意需要满足二叉排序树的值关系
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的结点的值，与当前子树的根结点的值关系
        if (node.value < this.value) {
            if (this.left == null) {  //如果当前结点左子结点为null
                this.left = node;
            } else {
                this.left.add(node);  //递归的向左子树添加
            }
        } else {  //添加的结点的值大于当前结点的值
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node); //递归的向右子树添加
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
