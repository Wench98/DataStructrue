package com.wench.linkedlist;

public class Josephu {

    public static void main(String[] args) {
        //测试构建环形链表和遍历是否OK
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        //测试出圈
        circleSingleLinkedList.countBoy(2, 2, 5);
    }

}

/**
 * 创建一个环形的单向链表
 */
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = null;

    //添加小孩节点，构建一个环形的链表
    public void addBoy(int nums) {
        //对nums做一个数据校验
        if (nums < 1) {
            System.out.println("很抱歉，nums的值不正确。");
            return;
        }
        Boy curBoy = null;  //辅助指针，帮助构建环形链表
        //使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建boy节点
            Boy boy = new Boy(i);
            //如果是第一个boy
            if (i == 1) {
                first = boy;
                first.setNext(first);   //构成环
                curBoy = first;     //让curBoy指向第一个boy
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("很抱歉，链表为空。");
            return;
        }
        //因为first不能动，因此需要一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("当前boy编号为：" + curBoy.getNo());
            if (curBoy.getNext() == first) {    //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();  //curBoy后移
        }
    }

    //根据用户的输入，计算出boy出圈的顺序

    /**
     * @param startNo  表示从第几个Boy开始计数
     * @param countNum 表示数几下，即步长
     * @param nums     表示最初有多少个Boy在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("很抱歉，参数输入有误，请重新输入。");
            return;
        }
        //创建一个辅助指针，帮助完成Boy出圈
        Boy helper = first;//可能你会诱惑这里为什么初始赋值是first，下面的while循环做了helper指向最后一个节点的事情
        //helper指向环形链表的最后一个节点
        while (true) {
            if (helper.getNext() == first) {    //说明helper指向最后boy节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动 startNo-1 次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //报数时，让first和helper指针同时移动 m-1 次，然后出圈，直到圈中只剩一个节点
        while (true) {
            if (helper == first) {  //说明圈中只有一个节点
                break;
            }
            //让first和helper指针同时移动 countNum-1 次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向的节点就是出圈的节点
            System.out.println("节点" + first.getNo() + "出圈");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后一个节点为：" + first.getNo());
    }

}

/**
 * 创建一个Boy类，表示一个节点
 */
class Boy {
    private int no;     //编号
    private Boy next;   //指向下一个节点，默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
