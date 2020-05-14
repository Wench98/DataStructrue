package cn.wench.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        //修改
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表情况");
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 遍历双向链表的方法
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("很抱歉，链表为空。");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            //判断链表是否到达最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    /**
     * 添加一个节点到双向链表的最后
     */
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此需要一个辅助变量temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 修改一个节点的内容
     * 双向链表的节点信息修改和单向链表一样
     * 只是节点的类型改为了HeroNode2
     */
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("很抱歉，链表为空。");
            return;
        }
        //找到需要修改的节点，根据no编号
        HeroNode2 temp = head.next;     //定义一个辅助变量
        boolean flag = false;       //表示是否找到该节点
        while (true) {
            if (temp == null) {     //链表已遍历完毕
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;    //说明找到了
                break;
            }
            temp = temp.next;
        }
        //判断flag是否找到了要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {     //没有找到
            System.out.println("很抱歉，没有找到编号为" + newHeroNode.no + "的节点。");
        }
    }

    /**
     * 从双向链表中删除一个节点
     * 说明
     * 1、对于双向链表，我们可以直接找到要删除的这个节点
     * 2、找到后，自我删除即可
     */
    public void delete(int no) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("很抱歉，链表为空。");
            return;
        }
        HeroNode2 temp = head.next;     //辅助变量
        boolean flag = false;           //标识是否找到待删除节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;    //找到了待删除的节点
                break;
            }
            temp = temp.next;   //temp后移，遍历
        }
        //判断flag
        if (flag) {
            //进行删除
            temp.pre.next = temp.next;
            if (temp.next != null) {    //如果是最后一个节点，就不需要执行下面的语句，否则会出现空指针异常
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("编号为" + no + "的节点不存在");
        }

    }

}


/**
 * 定义HeroNode，每一个HeroNode对象就代表一个节点
 */
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;  //指向下一个节点，默认为null
    public HeroNode2 pre;   //指向前一个节点，默认为null

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为显示方便，重写toString方法

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
