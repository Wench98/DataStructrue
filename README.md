# 数据结构与算法
    
    这是一个关于数据结构以及算法的项目。
    所有的实现文件均放置在cn.wench包下的各个类别的子包中
    
## 队列与链表
    
### Question for Sparse Array
    
    2020-04-10
    Store the sparse array into a file and read from the file to restore the original array.
    稀疏数组练习
    
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
    完善了毕设的评论、通知以及后台管理的功能，论文重复率降到10%以下。
    开始重新回顾Java语言知识，开始学习JVM的相关知识，同时对数据结构以及算法的进行程序化实现。
    
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
    
## 栈

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
    
## 递归
    
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
    
## 排序算法

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
    实现文件：sort包下的BubbleSort文件——说明注释肯定不能少
    
### 选择排序

    2020-05-22
    实现文件：sort包下的SelectSort文件——详尽的注释与说明会使更容易理解
    
### 插入排序

    2020-05-23
    
    今天答辩结束了，过程不好也不差吧。
    答辩组长老师认为我对自己的毕设框架很熟悉，问了一些基本的问题，也有些我未知的东西。
    往上翻看了一下，我已经连续10多天跟着这个视频走了吧。
    看着视频分析完，理解完后，跟着敲一遍，基本上能明白为什么会这样处理。
    但同时也明白了自己其实也并不是什么聪明人吧，看完一遍基本上能够明白，却仍然无法自行创造出来。
    目前仍在找工作，学历也许是一方面的原因，没有任何开发的实习经验兴许也是一方面的原因，求职很难。
    看到这里的你啊，别灰心，坚持下去。
    跟着我的时间轴走完这一套数据结构与算法，慢慢走下去，但请不要停下来。
    谢谢你能看完这些。
    
    插入排序的基本思想：
    把n个待排序的元素看成一个有序表和一个无序表
    开始时有序表中只包含一个元素，无序表中包含有（n-1）元素
    排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表的排序码进行比较
    将它插入到有序表中的适当位置，使之成为新的有序表
    
    实现文件：sort包下的InsertSort文件
    
### 希尔排序

    2020-05-24～2020-05-25
    24号学校毕业答辩结束，答辩成绩为35，最终成绩83。
    25号写党员转正申请书，写完了一支笔的笔油，手指写得也酸痛。
    这两天算是彻底颓废了。
    
    2020-05-26
    希尔排序基本思想：
    希尔排序是把记录按下标的一定增量进行分组，对每组使用直接插入排序算法排序；
    随着增量逐渐减少，每组包含的关键词越来越少，当增量减至1时，整个文件恰被分成一组，算法便终止
    
    代码实现文件：sort包下的ShellSort文件
    
### 快速排序

    2020-05-26
    快速排序法介绍：
    快速排序是对冒泡排序的一种改进。
     
    基本思想是：
    通过一趟排序将要排序的数据分割成独立的两部分
    其中一部分的所有数据都比另外一部分的所有数据都要小
    然后再按此方法对这两部分数据分别进行快速排序
    整个排序过程可以递归进行，以此达到整个数据变成有序序列
    
### 归并排序

    2020-05-27
    归并排序介绍：
    归并排序是利用归并的思想实现的排序方法
    该算法采用经典的分治策略
    分治法将问题分成一些小的问题然后递归求解
    而治的阶段则将分的阶段得到的各答案"修补"在一起
    即分而治之
    
    实现文件：sort包下的MergeSort文件
    
### 基数排序

    2020-05-28
    基数排序(桶排序)介绍：
    1、基数排序属于"分配式"排序，又称"桶子法"。顾名思义，它是通过键值的各个位的值，将要排序的元素分配至某些桶中，达到排序的目的。
    2、基数排序法是属于稳定性的排序，是高效率的稳定性排序法。
    3、基数排序是桶排序的扩展。
    4、具体实现：将整数按位数切割成为不同的数字，然后按每个位数分别比较。
    
    基数排序的基本思想：
    1、将所有带比较的数值统一为同样的位数长度，位数较短的在前面补零。
    2、然后，从最低位开始，依次进行排序。
    3、这样从低位排序一直到最高位排序完成以后，数列就变成一个有序序列。
    
## 查找算法

    2020-05-29
    查找算法介绍：
    1、顺序(线性)查找
    2、二分查找/折半查找
    3、插值查找
    4、斐波那契查找
    
    顺序(线性)查找——search包下的SeqSearch文件
    
    二分查找/折半查找——search包下的BinarySearch文件
    
    2020-05-30
    插值查找原理介绍：
    1、插值查找算法类似于二分查找，不同的是插值查找每次从自适应mid处开始查找
    2、将折半查找中的求mid索引的公式，更改为：int mid = low + (high-low) * (findVal - arr[low]) / (arr[high] - arr[low])
    说明：low表示左边索引，high表示右边索引，findVal是要查找的值，上述公式即为插值索引的求取
    
    代码实现文件——search包下的InsertValueSearch文件
    
    2020-06-01
    斐波那契查找(黄金分割点)基本介绍：
    
    黄金分割点是指把一条线段分割为两个部分，使其中一部分与全长之比等于另一部分与这部分之比。
    取其前三位数字的近似值是0.618。由于按此比例设计的造型十分美丽，因此称为黄金分割，也称中外比。
    
    斐波那契数列的两个相邻数的比例，无限接近黄金分割值0.618
    
    斐波那契原理：
    斐波那契查找原理与前两种相似，仅仅改变了中间结点(mid)的位置
    mid不再是中间或插值得到，而是位于黄金分割点附近，mid=low + F(k-1) - 1
    
    代码实现文件——sort包下的FibonacciSearch文件
    
## 哈希表  

    2020-06-02
    
    散列表(Hash Table，也叫哈希表)：
    是根据关键码值(key-value)而直接进行访问的数据结构。
    也就是说，它通过关键码值映射到表中一个位置来访问记录，以加快查找的速度。
    这个映射函数叫叫做散列函数，存放记录的数组叫散列表。
    
    代码实现实现文件——hashtab包下的HashTabDemo文件
    
## 树结构基础部分

    2020-06-03
    为什么需要树这种数据结构？
    1、数组存储方式的分析
        优点：通过下标方式访问元素，速度快。对于有序数组，还可使用二分查找提高检索速度。
        缺点：如果要检索具体某个值，或者插入值(按一定顺序)会整体移动，效率低。
    2、链式存储方式的分析
        优点：在一定程度上对数组存储方式有优化(比如：插入一个数值节点，只需要将插入节点，链接到链表中即可，删除效率也很好)。
        缺点：在进行检索时，效率仍然较低，比如检索某个值，需要从头节点开始遍历。
    3、树存储方式的分析
        能提高数据存储，读取的效率。
        比如利用二叉排序树(Binary Sort Tree)，既可以保证数据的检索速度，同时也可以数据的插入，删除，修改的速度。
        
    树的常用术语：节点、根节点、父节点、子节点、叶子节点(没有子节点的节点)、节点的权(节点值)、路径(从root节点找到该节点的路线)
                层、子树、树的高度(最大层数)、森林(多颗子树构成森林)
                
    二叉树的概念：
        1、树有很多种，每个节点最多只能有两个节点的一种形式称为二叉树。
        2、二叉树的子节点分为左节点和右节点。
        3、如果该二叉树的所有叶子节点都在最后一层，并且节点总数=2^n-1,n为层数，则我们称为满二叉树。
        4、如果该二叉树的所有叶子节点都在最后一层或者倒数第二层，
            而且最后一层的叶子节点在左边连续，倒数第二层的叶子节点在右边连续，则称之为完全二叉树。
            
### 二叉树的遍历
   
    2020-06-04
    二叉树遍历的说明：
        前序遍历：先输出父节点，再遍历左子树和右子树
        中序遍历：先遍历左子树，在输出父节点，再遍历右子树
        后序遍历：先遍历左子树，在遍历右子树，最后输出父节点
        小结：看输出父节点的顺序，就确定是前序，中序还是后序。
        
    分析二叉树的前序、中序、后序的遍历步骤
        1、创建一颗二叉树
        2、前序遍历
            2.1、先输出当前节点(初始的时候是root节点)
            2.2、如果当前节点的左子节点不为空，这递归进行前序遍历
            2.3、如果当前节点的右子节点不为空，则递归进行前序遍历
        3、中序遍历
            3.1、如果当前节点的左子节点不为空，则递归中序遍历
            3.2、输出当前节点
            3.3、如果当前节点的右子节点不为空，着递归中序遍历
        4、后序遍历
            4.1、如果当前节点的左子节点不为空，则递归后序遍历
            4.2、如果当前节点的右子节点不为空，着递归后序遍历
            4.3、输出当前节点
            
    代码实现文件：tree包下的BinaryTreeDemo下的HeroNode节点中和BinaryTree中的前序、中序、后序遍历的方法
    
### 二叉树的查找
    
    2020-06-05
    前序查找思路：
        1、先判断当前节点的no是否等于要查找的
        2、如果相等，这返回当前节点
        3、如果不等，则判断当前节点的左子节点是否为空；如果不为空，则递归前序查找
        4、如果左递归前序查找，找到节点则返回；否则继续判断当前节点的右子节点是否为空，
            如果不空，则继续向右递归前序查找
    
    中序查找思路
        1、判断当前节点的左子节点是否为空，若不为空则递归中序查找
        2、如果找到，则返回；如果没有找到，就和当前节点比较
            如果是则返回当前节点，否则继续进行右递归的中序查找
        3、如果右递归中序查找，找到了就返回，否则返回null
        
    后序查找思路
        1、判断当前节点的左子节点是否为空，如果不为空，则递归后序查找
        2、如果找到，就返回；如果没有找到，就判断当前节点的右子节点是否为空
            如果不为空，则右递归进行后序查找，若找到就返回
        3、和当前节点进行比较，如果是这返回，否则返回null
    
    代码实现：tree包下的BinaryTreeDemo下的HeroNode节点中和BinaryTree中的前序、中序、后序查找方法
    
### 二叉树的节点删除

    2020-06-06
    1、如果删除的节点是叶子节点，则删除该节点
    2、如果删除的节点是非叶子节点，则删除该树
    3、测试，删除掉上述示例中5号叶子节点和3号子树
    
    删除思路：
        首先考虑一下树是否是空树，如果只有一个root节点，则等价于将二叉树置空
        
        1、因为示例的二叉树是单向的，所以应该判断当前节点的子节点是否需要删除节点，
            而不能去判断当前这个节点是不是需要删除节点
        2、如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，则this.left=null；
            并且返回，结束递归删除
        3、如果当前节点的右子节点不为空，并且右子节点就是要删除的节点，则this.right=null；
            并且返回，结束递归删除
        4、如果第2步和第3步没有删除节点，那么我们就需要向左子树进行递归删除
        5、如果第4步也没有删除节点，则应当向右子树进行递归删除
    
    代码实现：tree包下的BinaryTreeDemo下的HeroNode节点中和BinaryTree中的delNode(int no)方法
    
### 顺序存储二叉树
    
    2020-06-07
    顺序存储二叉树的概念
    基本说明：
        从数据存储来看，数据存储方式跟树的存储方式可以相互转换
        即数组可以转换成树，树也可以转换成数组
    顺序存储二叉树的特点：
        1、顺序二叉树通常只考虑完全二叉树
        2、第n个元素的左子节点为 2*n + 1
        3、第n个元素的右子节点为 2*n + 2
        4、第n个元素的父节点为 (n-1)/2
        5、n：表示二叉树中的第几个元素(按0开始编号)
        
    实现文件：tree包下的ArrayBinaryTreeDemo.java文件
    
### 线索化二叉树

    2020-06-08
    线索二叉树基本介绍
    1、n个节点的二叉树链表中含有n+1[公式 2n-(n-1) = n+1]个空指针域。利用
        二叉链表中的空指针域，存放指向该节点在某种遍历次序下的前驱和后继节点的指针（这种附加的指针称为"线索"）
    2、这种加上了线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树(ThreadedBinaryTree)。
        根据线索性质的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种
    3、一个节点的前一个节点，称为前驱节点
    4、一个节点的后一个节点，称为后继节点
    
    线索二叉树举例——中序线索二叉树：tree包下threadedbinarytree包中的ThreadBinaryTreeDemo文件
    
    遍历线索化二叉树——对上述的中序线索化的二叉树，进行遍历
    示例文件：tree包下threadedbinarytree包中的ThreadBinaryTreeDemo文件
    
## 树结构实际应用

### 堆排序

    2020-06-09
    堆排序
        堆排序基本介绍
        1、堆排序是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序
            它的最坏，最好，平均时间复杂度均为O(nlog n)，它也是不稳定排序
        2、堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值
            称为大顶堆，注意：没有要求结点的左孩子的值和右孩子的值的大小关系
        3、每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
        一般升序采用大顶堆，降序采用小顶堆
        
        堆排序的基本思想：
        1、将待排序序列构造层一个大顶堆
        2、此时，整个序列的最大值就是堆顶的根结点
        3、将其于末尾元素进行交换，此时末尾就是最大值
        4、然后将剩余n-1个元素重新构造成一个堆，这样就会得到n个元素的次小值
            如此反复执行，便能得到一个有序序列了
        可以看到，在构建大顶堆的过程中，元素的个数逐渐减少，最后就得到一个有序序列了
        
    实现文件：tree包下的HeapSort文件
 
 ### 赫夫曼树
 
    2020-06-10
    
    基本介绍：
        1、给定n个权值作为n个叶子节点，构造一棵二叉树，若该树的带权路径长度
            (wpl)达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman Tre)
            有的也称霍夫曼树
        2、赫夫曼树是带权路径长度最短的树，权值较大的结点离根较近
        
    赫夫曼树几个重要概念
        1、路径和路径长度：在一棵树中，从一个结点往下可以达到的孩子或孙子结点
            之间的通路，称为路径。通路中分支的数目称为路径长度。若规定根结点
            的层数为1，则从根结点到地L层结点的路径长度为L-1
        2、结点的权及带权路径长度：若将树中结点赋给一个有着某种含义的数值，
            则这个数值称为该结点的权。结点的带权路径长度为：从根结点到该
            结点之间的路径长度与该结点的权的乘积
        3、树的带权路径长度：树的带权路径长度规定为所有叶子结点的带权路径长度之和
            记为：WPL(weighted path length)，权值越大的结点离根结点越近的
            二叉树才是最优二叉树
        4、WPL最小的就是赫夫曼树
        
    构建赫夫曼树的步骤：
        1、从小到大进行排序，将每一个数据，每个数据都是一个结点，每一个结点可以看
            成是一棵最简单的二叉树
        2、取出根结点权值最小的两棵二叉树
        3、组成一棵新的二叉树，该树的二叉树根结点的权值是前面两棵二叉树根结点权值的和
        4、再将这棵新的二叉树，以根结点的权值大小再次排序，不断重复1-2-3-4的步骤：
            直到数列中，所有的数据都被处理，就得到一棵赫夫曼树
        
    代码实现：huffmantree包下的HuffmanTree文件
    
### 赫夫曼编码

    2020-06-11
    赫夫曼编码是可变长编码的一种。
    字符的编码都不能是其他字符编码的前缀，符合此要求的编码叫做前缀编码，即不能匹配到重复的编码。
    
    一、以给字符串为例说明编码步骤：
        1、按照字符出现的次数构建一棵赫夫曼树，次数作为权值
        2、根据赫夫曼树，给各个字符规定编码(前缀编码)，向左
            的路径为0，向右的路径为1
        3、根据上述的编码规则就能得到字符串对应的编码
        
    此编码满足前缀编码，即字符的编码都不能是其他字符编码的前缀，不会造成匹配的多义性。
    
    注意：这个赫夫曼树根据排序方法不同，也可能不太一样，这样对应的赫夫曼编码也不完全一样，
            但是wpl是一样的，都是最小的。最后生成的赫夫曼编码的长度是一样的。
            
    二、最佳实践——数据压缩（创建赫夫曼树）
        以"i like like like Java do you like a Java"字符串为例
        创建其对应的赫夫曼树
        实现文件：huffmancode包下的HuffmanCode文件
                实现了将字符串转为对应的赫夫曼树以及其对应的赫夫曼编码表
                
    2020-06-13
    1、数据压缩-赫夫曼编码字节数组
        代码实现：huffmancode包下的HuffmanCode文件中的zip(byte[] bytes, Map<Byte, String> huffmanCodes)方法
    2、数据压缩-赫夫曼字节数组封装
        代码实现：huffmancode包下的HuffmanCode文件中的huffmanZip(byte[] bytes)方法
    3、数据解压(使用赫夫曼编码解码)-字节转二进制字符串
        代码实现：huffmancode包下的HuffmanCode文件中的byteToBitString(boolean flag, byte b)方法
    4、数据解压-赫夫曼解码
        代码实现：huffmancode包下的HuffmanCode文件中的decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes)方法
        Tips：此处关于StringIndexOutOfBoundException尚未解决！！！
        
    2020-06-15
    1、使用赫夫曼编码压缩文件
        代码实现：huffmancode包下的HuffmanCode文件中的zipFile(String srcFile,String dstFile)方法
    2、使用赫夫曼编码解压文件
        代码实现：huffmancode包下的HuffmanCode文件中的unZipFile(String zipFile, String dstFile)方法
    3、赫夫曼编码压缩文件注意事项
        1、若文件本身就是经过压缩处理的，那么使用赫夫曼编码再压缩，效率不会有明显变化。
        2、赫夫曼编码是按字节来处理的，因此可以处理所有的文件
        3、如一个文件中的内容，重复的数据不多，压缩效果也不会很明显
        
### 二叉排序树
    
    2020-06-16
    二叉排序树介绍
        二叉排序树：BST(Binary Sort Tree)，对于二叉排序树的任何一个非叶子结点，
        要求左子结点的值比当前结点的值小，右子结点的值比当前结点的值大。
        特别说明：如果有相同的值，可以将该结点放在左子结点或右子结点
        
    二叉排序树的创建与遍历
        代码实现——binarysorttree包下的BinarySortTreeDemo文件中的BinarySortTree类下的add(Node node)方法、infixOrder()方法
        
    二叉排序树的删除：
        1、删除叶子结点
        2、删除只有一棵子树的结点
        3、删除有两棵子树的结点
    代码实现——binarysorttree包下的BinarySortTreeDemo文件中的BinarySortTree类下的delNode(int value)方法
        
    删除叶子结点的思路：
        1、需要先去找到要删除的结点 targetNode
            代码实现——binarysorttree包下的BinarySortTreeDemo文件中的Node类中的search(int value)方法
        2、找到targetNode的父结点parent
            代码实现——binarysorttree包下的BinarySortTreeDemo文件中的Node类中的searchParent(int value)方法
        3、确定targetNode 是 parent的左子结点还是右子结点
        4、根据前面所述的情况来做出相应的删除
            左子结点：parent.left = null
            右子结点：parent.right = null
    
    删除只有一棵子树的结点：
        1、需要先去找到要删除的结点 targetNode
            代码实现——binarysorttree包下的BinarySortTreeDemo文件中的Node类中的search(int value)方法
        2、找到targetNode的父结点 parent
            代码实现——binarysorttree包下的BinarySortTreeDemo文件中的Node类中的searchParent(int value)方法
        3、确定 targetNode 的子结点是左子结点还是右子结点
        4、确定targetNode 是 parent的左子结点还是右子结点
        5、如果 targetNode 有左子结点
            5.1、如果 targetNode 是 parent 的左子结点
                    parent.left = targetNode.left
            5.1、如果 targetNode 是 parent 的右子结点
                    parent.right = targetNode.left
        6、如果 targetNode 有右子结点
            6.1、如果 targetNode 是 parent 的左子结点
                    parent.left = targetNode.right
            6.2、如果 targetNode 是 parent 的右子结点
                    parent.right = targetNode.right
                    
    删除有两棵子树的结点：
        1、需要先去找到要删除的结点 targetNode
            代码实现——binarysorttree包下的BinarySortTreeDemo文件中的Node类中的search(int value)方法
        2、找到 targetNode 的父结点 parent
            代码实现——binarysorttree包下的BinarySortTreeDemo文件中的Node类中的searchParent(int value)方法
        3、从 targetNode 的右子树找到最小的结点
        4、用一个临时变量，将最小结点的值保存在临时变量 temp 中
        5、删除该最小结点
        6、targetNode.value = temp
        
### 平衡二叉树

    2020-06-17
    基本介绍：
        1、平衡二叉树也叫平衡二叉搜索树，又被称为AVL树，可以保证查询效率较高
        2、具有以下特点：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
            并且左右两个子树都是一棵平衡二叉树。平衡二叉树的常用实现方法有红黑树、
            AVL、替罪羊树、Treap、伸展树等
            
    实现文件：avl包下的AVLTreeDemo类文件——实现了左旋转、右旋转、以及左右旋转
    
## 图

    2020-06-18
    图的基本介绍：
        但需要处理多对多的关系时，就使用到了图。
        图是一种数据结构，其中结点可以具有零个或多个相邻元素。
        两个结点之间的连接称为边。结点也可以称为顶点。
        
    图的常用概念：
        1、顶点
        2、边
        3、路径
        4、无向图
        6、有向图
        7、带权图
        
    图的表示方式：
        1、二维数组表示(邻接矩阵)
            邻接矩阵是表示图形中顶点之间相邻关系的矩阵，对于
            n个顶点的图而言，矩阵的row和col表示1...n个点
            1——表示能够直接连接
            0——表示不能直接连接
        2、链表表示(邻接表)
            2.1、邻接矩阵需要为每个顶点都分配n个边的空间，
                 其实有很多边都是不存在，会造成空间的一定损失
            2.2、邻接表的实现只关心存在的边，不关心不存在的边。
                 因此没有空间浪费，邻接表由数组+链表组成
                 
    图的创建：实现文件——graph包下的Graph类文件
    
    2020-06-19
    图遍历介绍
        所谓图的遍历，即是对结点的访问。
        一个图有那么多结点，如何遍历这些结点，需要特定策略。
        一般有两种访问策略：(1)深度优先遍历 (2)广度优先遍历
        
    图的深度优先搜索(Depth First Search)
        1、深度优先遍历，从初始访问结点出发，初始访问结点可能有多个邻接结点
           深度优先遍历的策略就是首先访问第一个邻接结点，然后再以这个被访问
           的邻接结点作为初始结点，访问它的第一个邻接结点，可以这样理解：
                每次都在访问完当前结点后首先访问当前结点的第一个邻接结点
        2、我们可以看到，这样的访问策略是优先往纵向挖掘深入，而不是对一个结点的
            所有邻接结点进行横向访问
        3、显然，深度优先搜索是一个递归的过程
        
    深度优先遍历算法步骤
        1、访问初始结点v，并标记结点v为已访问
        2、查找结点v的第一个邻接结点w
        3、若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续
        4、若w未被访问，对w进行深度优先遍历递归(即把w当做另一个v，然后进行步骤123)
        5、查找结点v的w邻接结点的下一个邻接结点，转到步骤3
        
    实现文件：graph包下的Graph类文件的48行～104行
    
    图的广度优先搜索(Broad First Search)
        类似于一个分层搜索的过程，广度优先遍历需要使用一个队列以保持访问过的结点的顺序
        以便按这个顺序来访问这些结点的邻接结点
    
    广度优先遍历算法步骤
        1、访问初始结点v并标记结点v为已访问
        2、结点v入队列
        3、当队列非空时，继续执行，否则算法结束
        4、出队列，取得队头结点u
        5、查找结点u的第一个邻接结点w
        6、若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤
            6.1、若结点w尚未被访问，则访问结点w并标记为已访问
            6.2、结点w入队列
            6.3、查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6
            
    实现文件：graph包下的Graph类文件的112行～159行
    
 ## 常用的10种算法
    
    2020-06-20
    用代码实现常用的10钟算法
        
### 二分查找非递归算法

    2020-06-20
    二分查找非递归算法的简单介绍：
        1、二分查找只适用于从有序的数列中进行查找(比如数字和字母等)，将数列排序后再进行查找
        2、二分查找法的运行时间为对数时间O(log2 n)，即查找到需要的目标位置最多只需要log2 n步
        
    代码实现：algorithm包下的BinarySearchNoRecursion文件
    
### 分治算法

    2020-06-21
    分治算法介绍：
        分治算法是一种很重要的算法。字面上的解释是"分而治之"，就是把一个复杂问题分
        成两个或更多的相同或相似的子问题，再把子问题分成更小的子问题。直到最后子问题
        可以简单的直接求解，原问题的解即子问题的解的合并。
        
    分治算法的基本步骤：
        分治算法在每一层递归上都有三个步骤：
        1、分解：将原问题分解为若干个规模较小，相互独立，与原问题形式相同的子问题
        2、解决：若子问题规模较小而容易被解决则直接解，否则递归地解各个子问题
        3、合并：将各个子问题的解合并为原问题的解
        
    算法实践-汉诺塔
        如果只有一个盘，则 A -> C
           如果有 n >= 2情况，可以看作是两个盘：最下面的一个盘、上面所有的盘
                1、先把最上面所有的盘 A -> B
                2、把最下边的盘 A -> C
                3、把B塔的所有盘 B -> C
    代码实现：algorithm包下的HanoiTower类文件
    
### 动态规划

    2020-06-22
    动态规划算法介绍
        1、动态规划(Dynamic Programming)算法的核心思想是：
            将大问题划分为小问题进行解决，从而一步步获取最优解的处理算法
            
        2、动态规划算法与分治算法类似，其基本思想也是将待求解问题分解成若干个
            子问题，先求解子问题，然后从这些子问题的解得到原问题的解
           
        3、与分治算法不同的是，适合于用动态规划求解的问题，经分解得到子问题
            往往不是互相独立的。
            (即下一个子阶段的求解是建立在上一个子阶段的解的基础上，进行进一步的求解)
        
        4、动态规划可以通过填表的方式来逐步推进，得到最优解
        
    代码实现：algorithm包下的KnapsackProblem类文件
        
        
        
        
        
        
        
        