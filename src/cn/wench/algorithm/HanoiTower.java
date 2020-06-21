package cn.wench.algorithm;

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    /**
     * 分治算法实践-汉诺塔
     *
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            hanoiTower(num - 1, a, c, b);   //先把最上面的所有盘 A->B，移动过程中会使用到C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);//把最下面的盘 A->C
            hanoiTower(num - 1, b, a, c);   //把B塔的所有盘从B->C，移动过程中会使用到A
        }
    }
}
