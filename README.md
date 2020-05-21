# DataStructure
    By Wench Guo
    
    It's just a practise for the data structure and algorithm. 
    这是一个学习数据结构以及算法的项目。
    学习来源：https://www.bilibili.com/video/BV1E4411H73v/?p=1
    
## 第一部分——队列与链表
    
### Question for Sparse Array
    
    2020-04-10
    Store the sparse array into a file and read from the file to restore the original array.
    稀疏数组练习的第一遍敲完
    
### ArrayQueueDemo
    
    2020-04-11
    There is a problem in the process of running the program.
    This queue can only be used once, and the data in the queue cannot be reused.
    使用了一个一位数组来模拟一个简单的队列。但是，该数组只能被使用一次，无法做到重用。

### CircleArrayQueueDemo
    
    2020-04-12
    The key to the circular array is: modulo.
    用了一个环形数组来模拟队列，达到了队列的重用。
    
### 完善毕设、论文降重
    
    2020-04-13～2020-05-11
    完善了毕设的评论、通知以及后台管理的功能，论文重复率降到10%以下后，笔者便着手找工作。
    很惭愧，基本上没有收到简历的回应。7号投了一个简历后，过了两轮测试，约13号公司现场进行机试。
    但至今没有收到确认邮件或其他通知消息，在前两次测试中深知自己基础不够扎实。
    便开始重新回顾Java语言知识，开始学习JVM的相关知识，同时对数据结构以及算法的进行程序化实现。
    
### 单链表的创建与遍历
    
    2020-05-11
    代码实现单链表的创建以及对该单链表进行遍历，该方式是直接添加到此单链表的尾部
    文件所在包：cn.wench.linkedlist
    类名称：SingleLinkedListDemo
    
### 按顺序插入节点到单链表、修改单链表的某个节点信息
    
    2020-05-12
    在cn.wench.linkedlist.SingleLinkedListDemo.java文件中添加了addByOrder方法，实现了按照编号的顺序进行插入节点。
    在cn.wench.linkedlist.SingleLinkedListDemo.java文件中添加了update方法，实现了按照编号修改某个节点信息，但不可修改编号属性。
    
### 单链表中的节点删除
    
    2020-05-12
    在cn.wench.linkedlist.SingleLinkedListDemo.java文件中添加了delete方法，实现了对单链表中某个节点的删除——根据节点no编号。
    
### 单链表练习题
    
    2020-05-13
    1、求单链表中有效节点的个数
    解答：cn.wench.linkedlist.SingleLinkedListDemo.java文件中的getLength(HeroNode head)方法。
    2、查找单链表中的倒数第K个节点
    解答：cn.wench.linkedlist.SingleLinkedListDemo.java文件中的findLastIndexNode(HeroNode hero, int index)方法。
    
    今天面试了两家公司，一家外包，一家因为自己知识储备量不够没能抓住机会，没有怨言。
    我也不知道自己能不能找到合心意的Java开发工作，就目前来看，应该是没有任何希望了。
    我选择把Java基础打牢一点，再回头看一遍，也继续每天更新数据结构的提交，宋红康的JVM教程第一篇也已经看完大半了。
    如果这些都做完了，还是没法找到合适工作的话，那便试试看其他的出路吧。
    
    3、单链表的反转
    解答：cn.wench.linkedlist.SingleLinkedListDemo.java文件中的reverseList(HeroNode head)方法
    4、从尾到头打印单链表，使用栈的先进后出特点进行打印
    解答：cn.wench.linkedlist.SingleLinkedListDemo.java文件中的reversePrint(HeroNode hero)方法
    
    5、合并两个有序的单链表，合并之后的链表依然有序
    解答：待完成。
    
### 双向链表的增删改查
    
    2020-05-14
    cn.wench.linkedlist.DoubleLinkedListDemo.java文件实现了对双向链表的增删改查操作
    待完成：双向链表的第二种添加方式，按照编号顺序进行添加。按照单链表的顺序添加，稍作修改。
    
### 约瑟夫问题——环形链表
    
    2020-05-15
    cn.wench.linkedlist.Josephu.java文件完成了环形链表，即约瑟夫环的实现。
    数到规定数字的人出圈，直到剩下最后一个。
    
## 第二部分——栈

### 数组模拟栈
    
    2020-05-16
    cn.wench.stack 包下的ArrayStackDemo.java 文件实现了数组模拟栈的操作，编写了出栈、入栈、显示栈数据、栈空、栈满的方法。
    小练习：实现使用链表来模拟栈——cn.wench.stack 包下的LinkedListStackDemo.java文件实现了与上述一致的栈操作，使用的是单链表实现的。
    
### 栈实现综合计算器——中缀表达式
    
    2020-05-17
    示例文件：stack包下的Calculator.java——中缀表达式
    
    如何处理多位数的问题？
    解决：示例文件stack包下的Calculator.java的48～66行
    
    给表达式加入小括号——待解决
    
### 逆波兰计算器

    2020-05-18
    示例文件：stack包下的PolandNotation文件
    给出一个后缀表达式的字符串，根据字符串求出表达式的结果。
    
### 中缀转后缀表达式

    2020-05-18
    示例文件：stack包下的PolandNotation文件
    
    完整版的逆波兰计算器：支持+ - * / ()；多位数，支持小数；兼容处理，过滤任何空白字符，包括空格、制表符、换页符
    仍然使用中缀表达式转后缀表达式
    示例文件：stack包下的PerfectPolishMultiCalc文件
    
## 第三部分——递归
    
    2020-05-19
    递归的概念：
        简单的说：递归就是方法自己调用自己，每次调用时传入不同的变量。递归有助于编程者解决复杂的问题，同时可以让代码便得简洁。
    
    递归调用机制的两个小案例：
        示例文件：recursion包下的RecursionTest文件
        1、打印数字
        2、打印阶乘结果
        
    递归调用规则：
        1、当程序执行到一个方法时，就会开辟一个独立的空间（栈）
        2、每个空间的数据（局部变量），是独立的
        3、如果方法中使用的是引用类型变量（比如数组），就会共享该引用类型的数据
        4、递归必须向退出递归的条件逼近，否则就会无限递归，出现StackOverflowError
        5、当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕
        
### 递归——迷宫问题
    
    2020-05-19
    示例文件：recursion包下的Maze文件
    setWay(int[][] map, int i, int j) —— 策略：下 -> 右 -> 上 -> 左
    setWay2(int[][] map, int i, int j) —— 策略：上 -> 右 -> 下 -> 左
    如何得出最短路径？—— 待解决，使用数组记录走通路径2的总和，总和小的即为最短路径
  
### 递归回溯——八皇后问题  
    2020-05-20
    示例文件：recursion包下的Queue8文件
    核心思路：在皇后在第一行时，找出所有可能的情况；第一行所有可能找尽后，找出皇后在第二行时所有可能的情况。
    
## 第四部分——排序算法

    2020-05-21
    排序算法的介绍——排序是将一组数据，依照指定的顺序进行排列的过程
    排序的分类：
        1、内部排序：值将需要处理的所有数据都加载到内部存储器中进行排序。
            包括：直接插入排序、希尔排序、简单选择排序、堆排序、冒泡排序、快速排序、归并排序、基数排序
        2、外部排序：数据量过大，无法全部加载到内存中，需要借助外部存储进行排序。
    T(n)：随着n规模的不断增加，常数项可以忽略、低次项可以忽略、高次项系数可以忽略
    
    常数阶O(1) < 对数阶O(log2 n) < 线性阶O(n) < 线性对数阶O(nlog2 n) < 平方阶O(n^2) < 立方阶O(n^3) < k次方阶O(n^k) < 指数阶O(2^n)
    
### 冒泡排序

    2020-05-21
    实现文件：sort包下的BubbleSort文件
 