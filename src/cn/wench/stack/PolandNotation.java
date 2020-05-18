package cn.wench.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {

        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1、1+((2+3)*4)-5 => 1 2 3 + 4 * + 5 -
        //2、因为直接对string进行操作不方便，因此先将"1+((2+3)*4)-5" => 中缀表达式对应的List
        //  即"1+((2+3)*4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3、将得到的中缀表达式对应的List => 后缀表达式对应的List
        //  即ArrayList： [1,+,(,(,2,+,3,),*,4,),-,5] => ArrayList：[1,2,3,+,4,*,+,5,-]

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpression = toInfixExpression(expression);
        System.out.println("中缀表达式对应的List：" + infixExpression);    //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpression);
        System.out.println("后缀表达式对应的List：" + parseSuffixExpressionList);    //List：[1, 2, 3, +, 4, *, +, 5, -]

        System.out.println(expression + "=" + calculate(parseSuffixExpressionList));


        /*
        //此处注释部分是简洁版逆波兰计算器的演示代码，给出一四则后缀表达式即可算出结果
        //先创建一个逆波兰表达式(后缀表达式)
        //(3+4) x 5 -6 => 3 4 + 5 x 6 - => 29
        //(30+4) x 5 -6 => 30 4 + 5 x 6 - => 164
        //4 * 5 -8 +60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +  =>
        //为了方便，逆波兰表达式的数字和符号使用空格隔开
        //String suffixExpression = "30 4 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        //思路
        //1、先将"3 4 + 5 x 6 -" => 放入ArrayList中
        //2、将ArrayList传递给一个方法，遍历ArrayList，配合栈完成计算

        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);
        int res = calculate(rpnList);
        System.out.println("计算的结果是：" + res);
         */

    }

    //将得到的中缀表达式对应的List => 后缀表达式对应的List
    //即ArrayList： [1,+,(,(,2,+,3,),*,4,),-,5] => ArrayList：[1,2,3,+,4,*,+,5,-]
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();   //符号栈
        //说明：因为s2栈在整个转换过程中，没有pop操作，而且后面还需要逆序输出
        //因此比较麻烦，这里选择不使用Stack<String>，而是直接使用ArrayList<Sting> s2
//        Stack<String> s2 = new Stack<>();   //存储中间结果的栈s2
        List<String> s2 = new ArrayList<String>(); //存储中间结果的栈s2

        //遍历ls
        for (String item : ls) {
            //如果是一个数，加入到s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if ("(".equals(item)) {
                s1.push(item);
            } else if (")".equals(item)) {
                //如果是右括号")"，则依次弹出s1栈顶的运算符，并加入到s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!"(".equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.pop();   //将"("弹出栈s1，消除这一对小括号
            } else {
                //当item的优先级小于等于s1栈顶运算符时，将s1栈顶的运算符弹出并加入到s2中，再次与s1中新的栈顶运算符相比较
                //问题：缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;  //因为是存放到List，因此按顺序输出就是对应的后缀表达式对应的List
    }

    /**
     * 将中缀表达式转成对应的List
     *
     * @param s
     * @return
     */
    public static List<String> toInfixExpression(String s) {
        //定义一个List，存放中缀表达式对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0;  //辅助指针，用于遍历中缀表达式字符串
        String str; //做对多位数的拼接之用
        char c;     //每遍历到一个字符，就放入到c
        do {
            //如果c是一个非数字，就需要加入到ls中
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;    //i需要后移
            } else { //如果是一个数需要考虑多位数的问题
                str = "";   //先将str置空       '0'[48] '9'[57]
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;   //拼接
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;  //返回即可
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        //创建一个栈，只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历
        for (String item : ls) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")) {  //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数并运算，仔入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if ("+".equals(item)) {
                    res = num1 + num2;
                } else if ("-".equals(item)) {
                    res = num1 - num2;
                } else if ("*".equals(item)) {
                    res = num1 * num2;
                } else if ("/".equals(item)) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res + "");
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}

//编写一个类Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //编写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
