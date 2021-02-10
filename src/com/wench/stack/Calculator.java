package com.wench.stack;

public class Calculator {

    public static void main(String[] args) {
        String expression = "70+2*6-4";
        //创建两个栈，数栈，符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operateStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;  //用于扫描
        int num1 = 0;
        int num2 = 0;
        int operate = 0;
        int res = 0;
        char ch = ' ';  //将每次扫描得到的char保存到ch中
        String keepNum = "";//用于拼接多位数
        //开始while循环的扫描
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (operateStack.isOperate(ch)) {    //如果是运算符
                //判断当前的符号栈是否为空
                if (!operateStack.isEmpty()) {
                    /*
                    如果符号栈有操作符，就进行比较，如果当前操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop两个数，
                    再从符号栈中pop出一个符号，进行运算，将得到的结果入数栈，然后将当前的操作符入符号栈
                     */
                    if (operateStack.priority(ch) <= operateStack.priority(operateStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operate = operateStack.pop();
                        res = numStack.cal(num1, num2, operate);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //把当前的操作符入符号栈
                        operateStack.push(ch);
                    } else {
                        //如果当前的操作符优先级大于栈中的操作符，就直接入符号栈
                        operateStack.push(ch);
                    }
                } else {
                    //如果为空，直接入符号栈
                    operateStack.push(ch);
                }
            } else {     //如果是数，则直接入数栈
                /*
                在处理数时，需要向expression表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈
                因此需要定义一个变量字符串，用于拼接
                */

                //处理多位数
                keepNum += ch;

                //如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描；如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (operateStack.isOperate(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的！！！！！清空keepNum
                        keepNum = "";
                    }
                }
            }
            //让index+1，并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序地从数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            //如果符号栈为空，则计算到了最后的结果，数栈中只有一个数字了【结果】
            if (operateStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operate = operateStack.pop();
            res = numStack.cal(num1, num2, operate);
            numStack.push(res); //入栈
        }
        //将数栈的最后一个数字pop出来，即为结果
        System.out.println("表达式 " + expression + " = " + numStack.pop());
    }

}

//先创建一个栈，直接使用之前创建好的

/**
 * 定义一个ArrayStack2 表示栈，需要扩展功能
 */
class ArrayStack2 {
    private int maxsize;    //栈的大小
    private int[] stack;    //数组，数组模拟栈，数据就放在该数组中
    private int top = -1;   //top表示栈顶

    public ArrayStack2(int maxsize) {
        this.maxsize = maxsize;
        stack = new int[this.maxsize];
    }

    //增加一个方法，可以返回当前栈顶的值，但是不是真正的pop
    public int peek() {
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxsize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈——push
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("很抱歉，栈满。");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈——pop
    public int pop() {
        //先判断栈是否空
        if (isEmpty()) {
            throw new RuntimeException("很抱歉，栈空。");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的内容[遍历栈]，遍历时，需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("很抱歉，栈空，没有数据。");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示，数字越大，则优先级就越高
    public int priority(int operate) {
        if (operate == '*' || operate == '/') {
            return 1;
        } else if (operate == '+' || operate == '-') {
            return 0;
        } else {
            return -1;  //假定目前的表达式只有+，-，*，/
        }
    }

    //判断是不是一个运算符
    public boolean isOperate(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int operate) {
        int res = 0;    //用来存放计算的结果
        switch (operate) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;  //注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}

