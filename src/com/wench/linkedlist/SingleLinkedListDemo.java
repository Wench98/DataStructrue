package com.wench.linkedlist;

import java.util.Stack;

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
        HeroNode newHeroNode = new HeroNode(2, "卢君", "是玉麒麟");
        singleLinkedList.update(newHeroNode);

        //打印节点信息
        System.out.println("After update:");
        singleLinkedList.list();

        //删除某个节点
        singleLinkedList.delete(1);
        System.out.println("After delete:");
        singleLinkedList.list();

        //测试获取单链表节点个数的方法
        System.out.println("有效节点的个数为：" + getLength(singleLinkedList.getHead()));

        //测试一下是否找到了倒数第K个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(),3);
        System.out.println("结果："+res);

        //测试逆序打印单链表
        System.out.println("Original LinkedList:");
        singleLinkedList.list();
        System.out.println("Reverse Print:");
        reversePrint(singleLinkedList.getHead());

        //测试一下单链表的反转功能
        System.out.println("Before Reverse:");
        singleLinkedList.list();
        reverseList(singleLinkedList.getHead());
        System.out.println("After Reverse:");
        singleLinkedList.list();

    }

    //使用Stack（栈），将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode hero){
        if (hero.next == null) {
            return; //空链表不能打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack();
        HeroNode cur = hero.next;
        //将链表的所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;     //cur后移，这样就可以压入下一个节点
        }
        //将栈中的节点进行打印，pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());    //stack特点是先进后出
        }
    }

    //将单链表反转
    public static void reverseList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助变量，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;       //指向当前节点【cur】的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表并完成，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最新端
        while (cur != null) {
            next = cur.next;    //先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;    //将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;     //将cur连接到新的链表上
            cur = next; //让cur后移
        }
        head.next = reverseHead.next;
    }

    /**
     * 查找单链表中倒数第K个节点
     * 思路
     * 1、编写一个方法，接收head节点，同时接收一个index
     * 2、index表示的是倒数第index个节点
     * 3、先把链表从头到尾遍历，得到链表的总长度
     * 4、得到size后，从链表的第一个开始遍历（size-index）遍即可
     * 5、如果找到了，这返回该节点，否则返回null
     */
    public static HeroNode findLastIndexNode(HeroNode hero, int index) {
        if (hero.next == null) {    //若链表为空，返回null
            return null;
        }
        //第一次遍历得到链表的长度
        int size = getLength(hero);
        //第二次遍历 size-index 位置，就是我们倒数第K个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义辅助变量
        HeroNode cur = hero.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 获取单链表有效节点的个数(如果是带头节点的链表，则不需要统计头节点
     * head 链表的头节点
     * 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {    //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助变量,这里没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

}


/**
 * 定一个单链表来管理HeroNode节点
 */
class SingleLinkedList {
    //首先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

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
        } else {
            System.out.println("很抱歉，没有找到您欲修改的编号节点。编号 " + newHeroNode.no + " 的节点不存在。");
        }
    }

    /**
     * 删除节点
     * 思路：
     * 1、head节点不动，因此需要一个辅助节点temp找到待删除节点的前一个节点
     * 2、在比较时，是temp.next.no 与 待删除节点的no 进行比较
     */
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;   //标识是否找到待删除节点的前一个节点
        while (true) {
            if (temp.next == null) {    //说明已经遍历到了链表的尾部
                break;
            }
            if (temp.next.no == no) {
                flag = true;    //找到了待删除节点的前一个节点temp
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("很抱歉，您要删除的节点%d在该链表中不存在。\n", no);
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
