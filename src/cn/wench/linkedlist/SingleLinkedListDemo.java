package cn.wench.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个单向链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入节点，目前是按照添加顺序进行加入的，即直接添加到链表的尾部
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        //打印节点信息
        singleLinkedList.list();
    }

}


/**
 * 定一个单链表来管理HeroNode节点
 */
class SingleLinkedList {
    //首先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单向链表
     * 1、找到当前链表的最后一个节点
     * 2、将最后一个节点的next指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //来到了最后一个节点
            if (temp.next == null) {
                break;
            }
            //如果没有到最后，则将temp后移
            temp = temp.next;
        }
        //当退出循环的时候，temp就指向了链表的最后
        temp.next = heroNode;
    }

    /**
     * 显示链表[遍历]
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("该链表为空");
            return;
        }
        //因头节点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到了链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;   //将temp后移，指向下一个节点
        }
    }
}


/**
 * 定义HeroNode，每一个HeroNode对象就代表一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;  //指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为显示方便，重写toString方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}