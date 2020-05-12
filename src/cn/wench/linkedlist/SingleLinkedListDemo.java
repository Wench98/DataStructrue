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
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //按照编号的顺序进行添加
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero2);

        System.out.println("Before:");
        singleLinkedList.list();

        //测试修改节点
        HeroNode newHeroNode = new HeroNode(2,"卢君","是玉麒麟");
        singleLinkedList.update(newHeroNode);

        //打印节点信息
        System.out.println("After update:");
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
     * 第二种方式添加节点，根据排名将英雄插入到指定的位置
     * 如果这个排名已存在，则添加失败，并给出提示
     */
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此仍然使用一个辅助指针来帮助添加的位置
        //由于是单链表，找到的temp是位于添加位置的前一个节点，否则无法进行插入
        HeroNode temp = head;
        boolean flag = false;   //标识添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {   //说明temp已经在链表的尾部
                break;
            }
            if (temp.next.no > heroNode.no) {   //位置找到了，就在temp的后面进行插入
                break;
            } else if (temp.next.no == heroNode.no) {   //需要插入的位置已经存在
                flag = true;    //标识编号已经存在
                break;
            }
            temp = temp.next;   //后移，遍历当前的链表
        }

        if (flag) {     //不能加入，说明编号已经存在
            System.out.println("该英雄的编号已经存在，不能加入" + heroNode.no + "号英雄节点");
        } else {
            //插入到链表当中，即temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 修改节点的信息，根据no编号来修改，即no编号不能修改
     * 根据新节点的no来修改即可
     */
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("很抱歉改链表为空");
            return;
        }
        //找到需要修改的节点，定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;   //标示是否找到改节点
        while (true) {
            if (temp == null) {     //说明到了链表的尾部，链表的遍历已经结束
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到了需要修改的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到了要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("很抱歉，没有找到您欲修改的编号节点。编号 " + newHeroNode.no + " 的节点不存在。");
        }
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