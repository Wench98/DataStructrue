package cn.wench.avl;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr ={4,3,6,5,7,8};
        //创建一个AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("没有平衡处理前");
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("树的左子树高度："+avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度："+avlTree.getRoot().rightHeight());

    }
}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    /**
     * 查找要删除的结点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 查找父结点的方法
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 删除以 node 为根结点的二叉排序树的最小结点
     *
     * @param node 传入的结点(当作二叉排序树的根结点)
     * @return 返回的是以 node 为根结点的二叉排序树的最小结点的值(也可从左子树中找到最大值)
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子结点，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //此时 target 就指向了最小结点
        //删除最小结点
        delNode(target.value);
        return target.value;
    }

    /**
     * 删除结点
     *
     * @param value
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //先找到要删除的结点 targetNode
            Node targetNode = search(value);
            //若没有找到要删除的结点
            if (targetNode == null) {
                return;
            }
            //如果发现当前这棵二叉排序树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //查找 targetNode 的父结点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if (parent.left != null && parent.left.value == value) {  //是左子结点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) { //是右子结点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {   //删除有两棵子树的结点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else { //删除只有一棵子树的结点
                //如果要删除的结点有左子结点
                if (targetNode.left != null) {
                    if (parent != null) {
                        //targetNode 是parent 的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {     //targetNode 是 parent 的右子结点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else { //如果要删除的结点有右子结点
                    if (parent != null) {
                        if (parent.left.value == value) { //targetNode 是parent 的左子结点
                            parent.left = targetNode.right;
                        } else { //targetNode 是parent 的右子结点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

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

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * @return 返回左子树的高度
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * @return 返回右子树的高度
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * @return 返回以该结点为根结点的树的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 查找要删除的结点
     *
     * @param value 希望删除的结点的值
     * @return 如果找到则返回该结点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {  //说明查找的就是该结点
            return this;
        } else if (value < this.value) {  //如果查找的值小于当前结点，则向当前结点的左子树递归查找
            if (this.left == null) {    //如果左子结点为空
                return null;
            }
            return this.left.search(value);
        } else {    //如果查找的值不小于当前结点，则向当前结点的右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除结点的父结点
     *
     * @param value 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;    //如果当前结点就是要删除的结点的父结点，就返回
        } else {
            if (this.left != null && value < this.value) { //查找值小于当前结点的值，且当前结点的左子结点不为空
                return this.left.searchParent(value);   //向左子树递归查找
            } else if (this.right != null && value >= this.value) { //查找值不小于当前结点的值，且当前结点的右子结点不为空
                return this.right.searchParent(value);  //向右子树递归查找
            } else {
                return null;    //没有找到父结点
            }
        }
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